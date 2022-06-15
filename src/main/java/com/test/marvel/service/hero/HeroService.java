package com.test.marvel.service.hero;

import com.test.marvel.entity.Hero;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface HeroService {
    void saveHero(Hero hero, MultipartFile file) throws IOException;
    List<Hero> getAllHeroes();
    Hero getHeroById(int id);
}
