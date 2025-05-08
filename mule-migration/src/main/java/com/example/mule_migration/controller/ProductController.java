package com.example.mule_migration.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mule_migration.entity.Product;
import com.example.mule_migration.services.XmlConsumerService;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/products")
public class ProductController {

    private final XmlConsumerService xmlService;
    
    public ProductController()
    {
        this.xmlService= new XmlConsumerService();
    }

    @GetMapping(value = "/produce/product",produces=MediaType.APPLICATION_XML_VALUE )
    public String getProduct() {
        
        String xmlResponse="""
                <product>
                    <productId> {productId} </productId>
                    <name> {name} </name>
                    <price> {price} </price>
                </product>
                """;
        String finalResponse=xmlResponse.replace("{productId}", "983").replace("{name}","Laptop").replace("{price}","300083.00");
        return finalResponse;
    }

    @GetMapping(value="/product",produces=MediaType.APPLICATION_JSON_VALUE)
    public Product getProductJSON()
    {
        return xmlService.parseProduct();
    }

    
}
