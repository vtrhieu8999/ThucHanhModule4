package com.example.demo.controller;

import com.example.demo.model.City;
import com.example.demo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CityController {
    @Autowired
    CityService cityService;

    @GetMapping("/")
    public ModelAndView list(){
        List<City> cities= (List<City>) cityService.findAll();
        ModelAndView modelAndView= new ModelAndView("/index");
        modelAndView.addObject("cities", cities);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView= new ModelAndView("/create");
        modelAndView.addObject("city", new City());
        return modelAndView;
    }

    @PostMapping("/create")
    public String saveCity(@Validated @ModelAttribute City city){
        cityService.save(city);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable(value= "id") Long id){
        City city= cityService.findById(id).get();
        ModelAndView modelAndView= new ModelAndView("/edit");
        modelAndView.addObject("city", city);
        return modelAndView;
    }

    @PostMapping("/edit")
    public String updateCity(@Validated @ModelAttribute("city") City city){
        cityService.save(city);
        return "redirect:/";
    }

    @GetMapping("/view/{id}")
    public ModelAndView view(@PathVariable("id") Long id){
        ModelAndView modelAndView= new ModelAndView("/view");
        City city= cityService.findById(id).get();
        modelAndView.addObject("city", city);
        return modelAndView;
    }

    @PostMapping("/delete/{id}")
    public String deleteCity(@PathVariable(value= "id") Long id){
        cityService.remove(id);
        return "redirect:/";
    }
}
