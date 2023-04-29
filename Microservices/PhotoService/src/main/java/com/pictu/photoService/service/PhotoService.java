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

    Photo get(String photoId);

    // For custom methods

    List<Photo> getPhotosByCustomerId(String customerId);


}
