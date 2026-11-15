package com.gvendas.gestao_vendas.services;

import com.gvendas.gestao_vendas.dto.sale.CustomerSaleResponseDTO;
import com.gvendas.gestao_vendas.dto.sale.ItemSaleRequestDTO;
import com.gvendas.gestao_vendas.dto.sale.SaleRequestDTO;
import com.gvendas.gestao_vendas.dto.sale.SaleResponseDTO;
import com.gvendas.gestao_vendas.entities.Customer;
import com.gvendas.gestao_vendas.entities.ItemSale;
import com.gvendas.gestao_vendas.entities.Product;
import com.gvendas.gestao_vendas.entities.Sale;
import com.gvendas.gestao_vendas.exceptions.QuantityProductAvaliableException;
import com.gvendas.gestao_vendas.exceptions.SaleNotFoundException;
import com.gvendas.gestao_vendas.repositories.ItemSaleRepository;
import com.gvendas.gestao_vendas.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SaleService extends AbstractSaleService {

    private final SaleRepository saleRepository;
    private final ItemSaleRepository itemSaleRepository;
    private final CustomerService customerService;
    private final ProductService productService;

    @Autowired
    public SaleService(SaleRepository saleRepository, ItemSaleRepository itemSaleRepository, CustomerService customerService, ProductService productService) {
        this.saleRepository = saleRepository;
        this.customerService = customerService;
        this.itemSaleRepository = itemSaleRepository;
        this.productService = productService;
    }

    public CustomerSaleResponseDTO listSaleByCustomer(Long idCustomer) {
        Customer customer = validateCustomerSaleExists(idCustomer);
        List<SaleResponseDTO> saleResponseDTOList = saleRepository.findByCustomerId(idCustomer).stream()
                .map(sale -> createSaleResponseDTO(sale, itemSaleRepository.findBySaleId(sale.getId()))).toList();
        return new CustomerSaleResponseDTO(customer.getName(), saleResponseDTOList);
    }

    // TODO: Resolver status code 500 quando não encontra a venda com o id especificado
    public CustomerSaleResponseDTO listSaleById(Long idSale) {
        Sale saleExists = validateSaleExists(idSale);
        List<ItemSale> itemSaleList = itemSaleRepository.findBySaleId(saleExists.getId());
        return returnCustomerSaleResponseDTO(saleExists, itemSaleList);
    }

    // TODO: Conferir Validações
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
    public CustomerSaleResponseDTO save(Long idCustomer, SaleRequestDTO saleDto) {
        Customer customer = validateCustomerSaleExists(idCustomer);
        validateProductExistsAndUpdateQuantity(saleDto.getItemSaleDTO());
        Sale saleSave = saveSale(customer, saleDto);
        List<ItemSale> itemSaleList = itemSaleRepository.findBySaleId(saleSave.getId());
        return returnCustomerSaleResponseDTO(saleSave, itemSaleList);
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
    public void delete(Long idSale) {
        Sale saleExists = validateSaleExists(idSale);
        List<ItemSale> itemsSale = itemSaleRepository.findBySaleId(idSale);
        validateProductExistsAndReturnValueToStock(itemsSale);
        itemSaleRepository.deleteAll(itemsSale);
        saleRepository.delete(saleExists);
    }

    private Sale saveSale(Customer customer, SaleRequestDTO saleDTO) {
        Sale saleSave = saleRepository.save(new Sale(saleDTO.getDate(), customer));
        saleDTO.getItemSaleDTO().stream().map(itemSaleRequestDTO -> createItemSale(itemSaleRequestDTO, saleSave))
                .forEach(itemSaleRepository::save);
        return saleSave;
    }

    private void validateProductExistsAndReturnValueToStock(List<ItemSale> itemSales) {
        itemSales.forEach(item -> {
            Product product = productService.validatesIfProductExists(item.getProduct().getId());
            product.setQuantity(product.getQuantity() + item.getQuantity());
            productService.updateQuantityInStock(product);
        });
    }

    // TODO: Erro 500 se informar id de produto inexistente
    // TODO: Erro 500 se colocar quantidade maior do que em estoque
    private void validateProductExistsAndUpdateQuantity(List<ItemSaleRequestDTO> itemSaleDTO) {
        itemSaleDTO.forEach(item -> {
            Product product = productService.validatesIfProductExists(item.getIdProduct());
            validateQuantityProduct(product, item.getQuantity());
            product.setQuantity(product.getQuantity() - item.getQuantity());
            productService.updateQuantityInStock(product);
        });
    }

    private void validateQuantityProduct(Product product, Integer quantitySaleDTO) {
        if(!(product.getQuantity() >= quantitySaleDTO)) {
            throw new QuantityProductAvaliableException(String.format("The quantity of %s requested for the product %s is not available in stock.", quantitySaleDTO, product.getDescription()));
        }
    }

    private Sale validateSaleExists(Long idSale) {
        Optional<Sale> sale = saleRepository.findById(idSale);
        return sale.orElseThrow(() -> new SaleNotFoundException(String.format("Sale with code %s not found", idSale)));
    }

    private Customer validateCustomerSaleExists(Long idCustomer) {
        return customerService.findById(idCustomer);
    }

}
