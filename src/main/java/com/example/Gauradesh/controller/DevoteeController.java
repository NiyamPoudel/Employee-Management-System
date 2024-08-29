package com.example.Gauradesh.controller;

import com.example.Gauradesh.model.Devotee;
import com.example.Gauradesh.service.DevoteeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class DevoteeController {

    @Autowired
    DevoteeService devoteeService;

    @RequestMapping("/devoteesList")
    public ResponseEntity<List<Devotee>> getDevotees(){
        return new ResponseEntity<>(devoteeService.getDevoteesList(), HttpStatus.OK);
    }

    @PostMapping("/devotee")
    public void addDevotees(@RequestBody Devotee devotee){
        System.out.println(devotee.toString());
        devoteeService.addDevotees(devotee);
    }

    @PostMapping("/devoteeform")
    public ResponseEntity<Devotee> addDevoteesFromForm(@RequestParam("devoteeName") String devoteeName, @RequestParam("devoteeImage") MultipartFile imageFile) throws IOException {
        System.out.println(devoteeName);
        return new ResponseEntity<>(devoteeService.addDevoteesFromForm(devoteeName, imageFile), HttpStatus.OK) ;
    }

    @GetMapping("/devotee/{devoteeId}")
    public ResponseEntity<Optional<Devotee>> getDevoteeById(@PathVariable int devoteeId){

        Optional<Devotee> devotee = devoteeService.getDevoteeById(devoteeId);

        if (devotee.isPresent()){
            return new ResponseEntity<>(devotee, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/devotee")
    public void updateDevotee(@RequestBody Devotee devotee){
        devoteeService.updateDevotee(devotee);
    }
    
    @DeleteMapping("/devotee/{devoteeId}")
    public void deleteDevotee(@PathVariable int devoteeId){
        devoteeService.deleteDevotee(devoteeId);
    }

    @GetMapping("/devotee/{devoteeId}/image")
    public ResponseEntity<byte []> getImageByID(@PathVariable int devoteeId){
        Optional<Devotee> devotee = devoteeService.getDevoteeById(devoteeId);
        if (devotee.isPresent()){
            byte[] imageFile = devotee.orElseThrow().getDevoteeImageData();
            return ResponseEntity.ok()
                    .body(imageFile);
        } else {
            return null;
        }
    }

    @GetMapping("/devotee/search")
    public ResponseEntity<List<Devotee>> searchDevotee(@RequestParam("keyword") String keyword){
        List<Devotee> devoteeList = devoteeService.searchDevoteeWithParam(keyword);
        return new ResponseEntity<>(devoteeList, HttpStatus.OK);
    }
}
