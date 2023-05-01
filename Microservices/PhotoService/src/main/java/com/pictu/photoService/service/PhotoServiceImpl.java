package com.pictu.photoService.service;
import com.pictu.core.exceptions.ResourceNotFoundException;
import com.pictu.core.utilities.IdGeneratorString;
import com.pictu.photoService.entities.Photo;
import com.pictu.photoService.repositories.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PhotoServiceImpl  implements  PhotoService{
    @Autowired
    private PhotoRepository photoRepository;
    @Override
    public Photo createPhoto(Photo photo) {
        photo.setPhotoId(IdGeneratorString.photoIDGenerator());
        return photoRepository.save(photo);
    }
    @Override
    public List<Photo> getAllPhotos() {
        return photoRepository.findAll();
    }
    @Override
    public Photo getPhoto(String photoId) {
        Photo photo = photoRepository.findById(photoId).orElseThrow(()-> new ResourceNotFoundException("Photo not found"));
        return photo;
    }
    @Override
    public List<Photo> getPhotosByUserId(String userId) {
        return photoRepository.findByUserId(userId);
    }

    @Override
    public void deletePhoto(String photoId) {
        Photo photo = this.photoRepository.findById(photoId).orElseThrow(() -> new ResourceNotFoundException("Photo Not found"));
        photoRepository.delete(photo);
    }
}
