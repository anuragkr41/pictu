package com.pictu.photoService.controllers;

import com.pictu.core.payloads.ApiResponse;
import com.pictu.photoService.entities.Photo;
import com.pictu.photoService.service.PhotoService;
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

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Photo>> getAllPhotosByUserId(@PathVariable String userId){
        return ResponseEntity.ok(photoService.getPhotosByUserId(userId));
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
