package com.test.marvel.controller;

import com.test.marvel.exception.NoSuchHeroException;
import com.test.marvel.entity.Hero;
import com.test.marvel.entity.Image;
import com.test.marvel.service.hero.HeroService;
import com.test.marvel.service.image.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HeroRESTController {

    private HeroService heroService;
    private ImageService imageService;
    @Autowired
    public HeroRESTController(HeroService heroService, ImageService imageService) {
        this.heroService = heroService;
        this.imageService = imageService;
    }

    @GetMapping("/heroes")
    public List<Hero> showAllHeroes(){
        return heroService.getAllHeroes();
    }

    @GetMapping("/heroes/{id}")
    public Hero showHeroById(@PathVariable int id) throws NoSuchHeroException{

            Hero hero = heroService.getHeroById(id);
          /*  if(hero == null){
                throw new NoSuchHeroException("Hero with id " + id + "not find");
            }*/
            return hero;
    }

    @GetMapping("/images/{id}")
    public Image showHeroesImageById(@PathVariable int id){
        return imageService.getImageWithoutByte(id);
    }

    @GetMapping("/images")
    public List<Image> showAllImage(){
        return imageService.getAllImage();
    }
}
