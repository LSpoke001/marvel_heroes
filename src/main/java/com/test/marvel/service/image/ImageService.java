package com.test.marvel.service.image;

import com.test.marvel.entity.Hero;
import com.test.marvel.entity.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ImageService {
    void saveImage(MultipartFile file, Hero hero) throws IOException;
    List<Image> getAllImage();
    Image getImageById(int id);
    Image getImageWithoutByte(int id);
}
