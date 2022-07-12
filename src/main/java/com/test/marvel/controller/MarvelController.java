package com.test.marvel.controller;

import com.test.marvel.entity.Hero;
import com.test.marvel.service.gender.GenderService;
import com.test.marvel.service.hero.HeroService;
import com.test.marvel.service.image.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class MarvelController {
    private GenderService genderService;
    private HeroService heroService;

    @Autowired
    public MarvelController(GenderService genderService, HeroService heroService) {
        this.genderService = genderService;
        this.heroService = heroService;
    }

    @GetMapping("/contacts")
    public String showMyContacts(){
        return "contact";
    }

    @GetMapping("/heroes")
    public String showAllHeroes(Model model){
        model.addAttribute("heroes", heroService.getAllHeroes());
        return "heroes";
    }

    @GetMapping("/main")
    public String showIndex(){
        return "main";
    }

    @GetMapping("/form")
    public String showForm(Model model){
        Hero hero = new Hero();
        model.addAttribute("hero", hero);
        model.addAttribute("genders", genderService.getAllGender());
        return "form";
    }

    @PostMapping("/form")
    public String saveForm(@ModelAttribute(value = "hero")Hero hero, @RequestParam(value = "file") MultipartFile file)throws IOException {
        heroService.saveHero(hero, file);
        return "redirect:/heroes";
    }

    @GetMapping("/hero/{id}")
    public String showHeroById(Model model, @PathVariable int id){
        Hero hero = heroService.getHeroById(id);
        model.addAttribute("hero", hero);
        return "one_hero";
    }
}
