package com.pictu.photoService.service;

import com.pictu.photoService.entities.Photo;

import java.util.List;

public interface PhotoService {

    //Create

    Photo create (Photo photo);


    //GetAll

    List<Photo> getAllPhotos();

    //Get Single

    Photo get(String photoId);
}
