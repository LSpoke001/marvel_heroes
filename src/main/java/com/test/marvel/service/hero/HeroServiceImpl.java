package com.test.marvel.service.hero;

import com.test.marvel.entity.Hero;
import com.test.marvel.entity.Image;
import com.test.marvel.repository.HeroRepository;
import com.test.marvel.repository.ImageRepository;
import com.test.marvel.service.image.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class HeroServiceImpl implements HeroService{
    private HeroRepository heroRepository;
    private ImageService imageService;
    @Autowired
    public HeroServiceImpl(HeroRepository heroRepository, ImageService imageService) {
        this.heroRepository = heroRepository;
        this.imageService = imageService;
    }

    @Override
    public void saveHero(Hero hero, MultipartFile file) throws IOException {
        imageService.saveImage(file, hero);
        heroRepository.save(hero);
    }

    @Override
    public List<Hero> getAllHeroes() {
        return heroRepository.findAll();
    }

    @Override
    public Hero getHeroById(int id) {
        Optional<Hero> optional = heroRepository.findById(id);
        return optional.get();
    }
}
