package com.example.projectIsa.renting.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectIsa.renting.service.ICottageService;

@RestController
@RequestMapping(value = "/cottage")
public class CottageController {

	private final ICottageService cottageService;

    @Autowired
    public CottageController(ICottageService cottageService) {
        this.cottageService = cottageService;
    }
    
    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() throws ParseException {
        return new ResponseEntity<>(cottageService.getAll(),HttpStatus.OK);
    }
}
