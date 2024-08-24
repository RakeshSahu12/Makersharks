package com.makersharks.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.makersharks.model.ManufacturingProcess;
import com.makersharks.model.NatureOfBusiness;
import com.makersharks.model.Supplier;
import com.makersharks.service.SupplierService;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @PostMapping("/query")
    public ResponseEntity<List<Supplier>> querySuppliers(
        @RequestParam String location,
        @RequestParam NatureOfBusiness natureOfBusiness,
        @RequestParam ManufacturingProcess manufacturingProcess,
        @RequestParam(defaultValue = "10") int limit
    ) {
        List<Supplier> suppliers = supplierService.findSuppliers(location, natureOfBusiness, manufacturingProcess, limit);
        return ResponseEntity.ok(suppliers);
    }
}

