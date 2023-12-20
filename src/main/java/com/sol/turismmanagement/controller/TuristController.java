package com.sol.turismmanagement.controller;

import com.sol.turismmanagement.model.Places;
import com.sol.turismmanagement.model.Turist;
import com.sol.turismmanagement.repository.PlacesRepository;
import com.sol.turismmanagement.repository.TuristRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class TuristController {


    @Autowired
    TuristRepository turistRepository;

    @Autowired
    PlacesRepository placesRepository;
    @RequestMapping(value = "/turist/new", method = RequestMethod.GET)
    public String newOrdersForm(Model model){
        Turist turist=new Turist();
        model.addAttribute("turist", turist);
        List<Places> places= placesRepository.findAll();
        model.addAttribute("place",places);
        return "turist/new";
    }
    @RequestMapping(value = "/turist/new", method = RequestMethod.POST)
    public String saveTurist(Model model, Turist turist){

        turistRepository.save(turist);

        model.addAttribute("turist", turist);
        return "redirect:/turist/list";

    }
    @RequestMapping(value = "/turist/list", method = RequestMethod.GET)
    public String findAllTurist(Model model){

        List<Turist> turist= turistRepository.findAll();

        model.addAttribute("turist", turist);

        return "turist/list";
    }
    @RequestMapping(value = "/turist/edit/{id}", method = RequestMethod.GET)
    public String editOrders(Model model,@PathVariable Long id){
        Turist turist= turistRepository.findById(id).orElse(null);
        model.addAttribute("turist", turist);
        List< Places >places= placesRepository.findAll();
        model.addAttribute("place",places);
        return "turist/edit";
    }


    @RequestMapping(value = "/turist/edit", method = RequestMethod.POST)
    public String updateTurist(Model model,Turist turist){
        turistRepository.save(turist);
        model.addAttribute("turist", turist);
        return "redirect:/turist/list";
    }

    @RequestMapping(value = "/turist/delete/{id}", method = RequestMethod.GET)
    public String deleteTurist(@PathVariable Long id){
        turistRepository.deleteById(id);
        return "redirect:/turist/list";
    }
}
