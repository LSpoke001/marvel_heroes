package com.test.marvel.controller;

import com.test.marvel.entity.Image;
import com.test.marvel.service.image.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.io.ByteArrayInputStream;

@RestController
public class ImageMarvelController {
    @Autowired
    private ImageService imageService;
    @GetMapping("/images/{id}")
    private ResponseEntity<?> getImageById(@PathVariable int id){

        Image image = imageService.getImageById(id);
        return ResponseEntity.ok()
                .header("file", image.getName())
                .contentType(MediaType.valueOf(image.getType()))
                .contentLength(image.getSize())
                .body(new InputStreamResource(new ByteArrayInputStream(image.getBytes())));
    }
}
