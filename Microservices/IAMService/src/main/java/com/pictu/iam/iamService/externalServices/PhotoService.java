package com.pictu.iam.iamService.externalServices;

import com.pictu.iam.iamService.entities.Photo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name = "PHOTO-SERVICE")
public interface PhotoService {
    @GetMapping("/photos/{photoId}")
    Photo getPhoto(@PathVariable String photoId);
    @GetMapping("/photos/user/{userId}")
    List<Photo> getPhotosByUserId(@PathVariable String userId);

    //POST
    @PostMapping("/photos")
    public Photo createPhoto(Photo photo);


    @DeleteMapping("/photos/{photoId}")
    public void deletePhoto(@PathVariable String photoId);

}
