package com.pictu.iam.iamService.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Photo {
    private String photoId;
    //private String userId;
    private String name;
    private String location;
    private String about;


}
