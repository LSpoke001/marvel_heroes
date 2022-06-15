package com.test.marvel.service.gender;

import com.test.marvel.entity.Gender;

import java.util.List;

public interface GenderService {
    List<Gender> getAllGender();
    Gender showGenderById(int id);
}
