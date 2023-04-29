package com.pictu.photoService.service;

import com.pictu.core.exceptions.ResourceNotFoundException;
import com.pictu.photoService.entities.Photo;
import com.pictu.photoService.repositories.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
public class PhotoServiceImpl  implements  PhotoService{

    @Autowired
    private PhotoRepository photoRepository;
    @Override
    public Photo create(Photo photo) {

        String randomPhotoId = UUID.randomUUID().toString();
        photo.setPhotoId(randomPhotoId);

        return photoRepository.save(photo);
    }

    @Override
    public List<Photo> getAllPhotos() {
        List<Photo> photoList = photoRepository.findAll();
        return photoList;
    }

    @Override
    public Photo get(String photoId) {
        Photo photo = photoRepository.findById(photoId).orElseThrow(() -> new ResourceNotFoundException("Photo Not found"));
        return photo;
    }

    @Override
    public List<Photo> getPhotosByCustomerId(String customerId) {
        return photoRepository.findByCustomerId(customerId);
    }
}
