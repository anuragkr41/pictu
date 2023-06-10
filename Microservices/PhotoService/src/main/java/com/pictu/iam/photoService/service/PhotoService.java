package com.pictu.iam.photoService.service;

import com.pictu.iam.photoService.entities.Photo;

import java.util.List;

public interface PhotoService {

    //Create

    Photo createPhoto (Photo photo);


    //GetAll

    List<Photo> getAllPhotos();

    //Get Single

    Photo getPhoto(String photoId);

    // For us methods

    List<Photo> getPhotosByCustomerId(String customerId);

    //For Delete

    void deletePhoto(String photoId);


}
