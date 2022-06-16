package com.test.marvel.controller;

import com.test.marvel.entity.Hero;
import com.test.marvel.service.hero.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HeroRESTController {

    private HeroService heroService;
    @Autowired
    public HeroRESTController(HeroService heroService) {
        this.heroService = heroService;
    }

    @GetMapping("/heroes")
    public List<Hero> showAllHeroes(){
        return heroService.getAllHeroes();
    }

    @GetMapping("/heroes/{id}")
    public Hero showHeroById(@PathVariable int id){
        return heroService.getHeroById(id);
    }
}
