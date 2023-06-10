package com.pictu.iam.photoService.repositories;

import com.pictu.iam.photoService.entities.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, String> {

    // Us Finder MEthods
    List<Photo> findByCustomerId(String customerId);


}
