package com.test.marvel.service.gender;

import com.test.marvel.entity.Gender;
import com.test.marvel.repository.GenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenderServiceImpl implements GenderService{
    private GenderRepository genderRepository;
    @Autowired
    public GenderServiceImpl(GenderRepository genderRepository) {
        this.genderRepository = genderRepository;
    }

    @Override
    public List<Gender> getAllGender() {
        return genderRepository.findAll();
    }

    @Override
    public Gender showGenderById(int id) {
        Optional<Gender> optional = genderRepository.findById(id);
        return optional.get();
    }
}
