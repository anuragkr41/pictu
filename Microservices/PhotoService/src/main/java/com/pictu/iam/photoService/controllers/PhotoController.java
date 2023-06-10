package com.pictu.iam.photoService.controllers;

import com.pictu.iam.core.payloads.ApiResponse;
import com.pictu.iam.photoService.entities.Photo;
import com.pictu.iam.photoService.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/photos")
public class PhotoController {

    @Autowired
    private PhotoService photoService;

    @PostMapping
    public ResponseEntity<Photo> create (@RequestBody Photo photo){
        return ResponseEntity.status(HttpStatus.CREATED).body(photoService.createPhoto(photo));
    }

    @GetMapping
    public ResponseEntity<List<Photo>> getAllPhotos(){
        return ResponseEntity.ok(photoService.getAllPhotos());
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Photo>> getAllPhotosByCustomerId(@PathVariable String customerId){
        return ResponseEntity.ok(photoService.getPhotosByCustomerId(customerId));
    }

    @GetMapping("/{photoId}")
    public ResponseEntity<Photo> getSinglePhoto(@PathVariable String photoId){
        return ResponseEntity.ok(photoService.getPhoto(photoId));

    }

    @DeleteMapping("/{photoId}")
    public ApiResponse deletePhoto(@PathVariable String photoId){
        this.photoService.deletePhoto(photoId);
        return new ApiResponse("Photo Deleted Successfully", true);


    }
}
