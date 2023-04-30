package com.pictu.photoService.service;

import com.pictu.photoService.entities.Photo;

import java.util.List;
import java.util.Set;

public interface PhotoService {

    //Create

    Photo create (Photo photo);


    //GetAll

    List<Photo> getAllPhotos();

    //Get Single

    Photo getPhoto(String photoId);

    // For us methods

    List<Photo> getPhotosByUserId(String userId);


}
