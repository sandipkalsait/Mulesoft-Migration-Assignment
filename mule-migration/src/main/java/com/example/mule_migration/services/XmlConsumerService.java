package com.example.mule_migration.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.mule_migration.entity.Product;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class XmlConsumerService {
    
    private final RestTemplate restTemplate;
    private final XmlMapper mapper;
     
    public XmlConsumerService()
    {
        this.mapper=new XmlMapper();
        this.restTemplate=new RestTemplate();
    }

    public Product parseProduct()
    {
        try {
            String xmlResponse= restTemplate.getForObject("http://localhost:8080/products/produce/product", String.class);
            
            Product product=mapper.readValue(xmlResponse,Product.class);
            
            log.info("Consumed Product : {} ",product);
            return product;

        } catch (Exception e) {
            log.error("Failed to consume/parse product xml"+e);
            return null;
            // TODO: handle exception
        }
    }

}
