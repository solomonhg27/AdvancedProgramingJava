package com.sol.turismmanagement.controller;

import com.sol.turismmanagement.model.Places;
import com.sol.turismmanagement.repository.PlacesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class PlacesController {
    @Autowired
    PlacesRepository placesRepository;


    @RequestMapping(value = "/places/new", method = RequestMethod.GET)
    public String newPlacesForm(Model model){
        model.addAttribute("places", new Places());
        return "places/new";
    }
    @RequestMapping(value = "/places/new", method = RequestMethod.POST)
    public String savePlaces(Model model, Places places){
        placesRepository.save(places);
        model.addAttribute("places", places);
        return "redirect:/places/list";

    }
    @RequestMapping(value = "/places/list", method = RequestMethod.GET)
    public String findAllPlaces(Model model){

        List<Places> places= placesRepository.findAll();
        model.addAttribute("places", places);
        return "places/list";
    }
    @RequestMapping(value = "/places/edit/{id}", method = RequestMethod.GET)
    public String editPlaces(Model model,@PathVariable Long id){
        Places places= placesRepository.findById(id).orElse(null);
        model.addAttribute("places", places);
        return "places/edit";
    }


    @RequestMapping(value = "/places/edit", method = RequestMethod.POST)
    public String updatePlaces(Model model,Places places){
        placesRepository.save(places);
        model.addAttribute("places", places);
        return "redirect:/places/list";
    }

    @RequestMapping(value = "/places/delete/{id}", method = RequestMethod.GET)
    public String deletePlaces(@PathVariable Long id){
        placesRepository.deleteById(id);
        return "redirect:/places/list";
    }
}
