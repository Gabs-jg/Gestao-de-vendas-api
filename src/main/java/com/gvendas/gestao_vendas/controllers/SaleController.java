package com.gvendas.gestao_vendas.controllers;

import com.gvendas.gestao_vendas.dto.sale.CustomerSaleResponseDTO;
import com.gvendas.gestao_vendas.dto.sale.SaleRequestDTO;
import com.gvendas.gestao_vendas.services.SaleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sales")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @GetMapping("/customer/{idCustomer}")
    public ResponseEntity<CustomerSaleResponseDTO> listSaleByCustomer(@PathVariable Long idCustomer) {
        CustomerSaleResponseDTO customerSaleResponseDTO = saleService.listSaleByCustomer(idCustomer);
        return ResponseEntity.ok(customerSaleResponseDTO);
    }

    @GetMapping("/{idSale}")
    public ResponseEntity<CustomerSaleResponseDTO> listSaleById(@PathVariable Long idSale) {
        CustomerSaleResponseDTO customerSaleResponseDTO = saleService.listSaleById(idSale);
        return ResponseEntity.ok(customerSaleResponseDTO);
    }

    @PostMapping("/customer/{idCustomer}")
    public ResponseEntity<CustomerSaleResponseDTO> save(@PathVariable Long idCustomer, @Valid @RequestBody SaleRequestDTO saleDto) {
        CustomerSaleResponseDTO customerSaleResponseDTO = saleService.save(idCustomer, saleDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(customerSaleResponseDTO);
    }

    @DeleteMapping("/{idSale}")
    public ResponseEntity<Void> delete(@PathVariable Long idSale) {
        saleService.delete(idSale);
        return ResponseEntity.noContent().build();
    }

}
