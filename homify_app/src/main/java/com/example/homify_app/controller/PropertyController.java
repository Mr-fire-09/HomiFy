package com.example.homify_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.homify_app.model.Property;
import com.example.homify_app.repository.PropertyRepository;

@Controller
public class PropertyController {
    @Autowired
    private PropertyRepository propertyRepository;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("properties", propertyRepository.findAll());
        model.addAttribute("property", new Property());
        return "index";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Property property) {
        propertyRepository.save(property);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        propertyRepository.deleteById(id);
        return "redirect:/";
    }
}
