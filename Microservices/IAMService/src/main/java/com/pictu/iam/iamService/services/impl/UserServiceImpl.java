package com.pictu.iam.iamService.services.impl;
import com.pictu.core.exceptions.ResourceNotFoundException;
import com.pictu.core.utilities.IdGeneratorString;
import com.pictu.iam.iamService.entities.Photo;
import com.pictu.iam.iamService.entities.User;
import com.pictu.iam.iamService.externalServices.PhotoService;
import com.pictu.iam.iamService.repositories.UserRepository;
import com.pictu.iam.iamService.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PhotoService photoService;


    //private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(User user) {
        user.setUserId(IdGeneratorString.userIDGenerator());
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    @Override
    public User getSingleUser(String userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + userId));
        //Get Photos of the above user from Photo Service
        //ArrayList<Photo> photosOfUser = restTemplate.getForObject("http://PHOTO-SERVICE/photos/user/"+ user.getUserId(), ArrayList.class);

        //Let us try fetching the photos Of the user using the feign client.

        List<Photo> photos = photoService.getPhotosByUserId(user.getUserId());
        user.setPhotos(photos);
        return user;
    }
}

