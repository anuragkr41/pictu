package com.pictu.photoService.repositories;

import com.pictu.photoService.entities.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, String> {

    // Custom Finder MEthods
    List<Photo> findByCustomerId(String customerId);


}
