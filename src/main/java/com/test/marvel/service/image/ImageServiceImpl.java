package com.test.marvel.service.image;

import com.test.marvel.entity.Hero;
import com.test.marvel.entity.Image;
import com.test.marvel.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ImageServiceImpl implements ImageService{
    private ImageRepository imageRepository;
    @Autowired
    public ImageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public List<Image> getAllImage() {
        return imageRepository.findAllImages();
    }

    @Override
    public Image getImageById(int id) {
        Optional<Image> optional = imageRepository.findById(id);
        return optional.get();
    }

    @Override
    public Image getImageWithoutByte(int id) {
        return imageRepository.findImageWithoutByte(id);
    }

    public void saveImage(MultipartFile file, Hero hero) throws IOException {
        Image image;
        if(file.getSize() != 0){
            image = toImageEntity(file);
            imageRepository.save(image);
            image.setUrl("http://localhost:8080/images/" + image.getId());
            imageRepository.save(image);
            hero.setImage(image);
        }
    }
    private Image toImageEntity(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setName(file.getOriginalFilename());
        image.setType(file.getContentType());
        image.setSize((int) file.getSize());
        image.setBytes(file.getBytes());
        return image;
    }
}
