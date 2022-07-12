package com.test.marvel.repository;

import com.test.marvel.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer> {

    @Query(value = "select new com.test.marvel.entity.Image(i.id, i.name, i.url, i.type, i.size) from Image i where i.id = :imageId")
    Image findImageWithoutByte(@Param("imageId") int imageId);
    @Query(value = "select new com.test.marvel.entity.Image(i.id, i.name, i.url, i.type, i.size) from Image i")
    List<Image> findAllImages();
}
