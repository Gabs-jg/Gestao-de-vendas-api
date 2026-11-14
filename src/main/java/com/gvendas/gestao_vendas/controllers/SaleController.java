package com.gvendas.gestao_vendas.controllers;

import com.gvendas.gestao_vendas.dto.sale.CustomerSaleResponseDTO;
import com.gvendas.gestao_vendas.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sale")
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

}
