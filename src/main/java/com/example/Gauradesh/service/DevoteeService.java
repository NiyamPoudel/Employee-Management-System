package com.example.Gauradesh.service;

import com.example.Gauradesh.model.Devotee;
import com.example.Gauradesh.repository.DevoteeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class DevoteeService {

    @Autowired
    DevoteeRepo devoteeRepo;

    @Autowired


    public List<Devotee> getDevoteesList(){
        return devoteeRepo.findAll();
    }

    public void addDevotees(Devotee devotee){
        devoteeRepo.save(devotee);
    }

    public Optional<Devotee> getDevoteeById(int devoteeId) {
        return devoteeRepo.findById(devoteeId);
    }

    public void updateDevotee(Devotee devotee) {
        devoteeRepo.save(devotee);
    }

    public void deleteDevotee(int devoteeId) {
        devoteeRepo.deleteById(devoteeId);
    }

    public Devotee addDevoteesFromForm(String devoteeName, MultipartFile imageFile) throws IOException {
        Devotee devotee = new Devotee();
        devotee.setDevoteeName(devoteeName);
        devotee.setDevoteeImageName(imageFile.getOriginalFilename());
        devotee.setDevoteeImageData(imageFile.getBytes());
        return devoteeRepo.save(devotee);
    }

    public List<Devotee> searchDevoteeWithParam(String keyword) {
        return devoteeRepo.findByParam(keyword);
    }
}
