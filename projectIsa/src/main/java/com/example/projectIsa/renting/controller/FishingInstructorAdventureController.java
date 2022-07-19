package com.example.projectIsa.renting.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectIsa.renting.model.FishingInstructorAdventure;
import com.example.projectIsa.renting.service.IFishingInstructorAdventureService;

@RestController
@RequestMapping(value = "/fishingInstructorAdventure")
public class FishingInstructorAdventureController {

	private final IFishingInstructorAdventureService fishingInstructorAdventureService;

    @Autowired
    public FishingInstructorAdventureController(IFishingInstructorAdventureService fishingInstructorAdventureService) {
        this.fishingInstructorAdventureService = fishingInstructorAdventureService;
    }
    
    @GetMapping("/getAll")
    public @ResponseBody List<FishingInstructorAdventure> getAll() throws ParseException {
        return fishingInstructorAdventureService.getAll();
    }
    
    @GetMapping("/search/{searchInput}")
    public List<FishingInstructorAdventure> search(@PathVariable String searchInput) {
        return fishingInstructorAdventureService.search(searchInput);
    }
}
