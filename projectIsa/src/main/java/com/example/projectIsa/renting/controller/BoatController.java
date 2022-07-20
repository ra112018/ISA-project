package com.example.projectIsa.renting.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectIsa.renting.model.Boat;
import com.example.projectIsa.renting.service.IBoatService;

@RestController
@RequestMapping(value = "/boat")
public class BoatController {

	private final IBoatService boatService;

    @Autowired
    public BoatController(IBoatService boatService) {
        this.boatService = boatService;
    }
    
    @GetMapping("/getAll")
    public @ResponseBody List<Boat> getAll() throws ParseException {
        return boatService.getAll();
    }
    
    @GetMapping("/search/{searchInput}")
    public List<Boat> search(@PathVariable String searchInput) {
        return boatService.search(searchInput);
    }
}
