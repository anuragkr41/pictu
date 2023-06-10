package com.pictu.customerService.services.impl;

import com.pictu.customerService.services.CustomerService;
import com.pictu.iam.core.exceptions.ResourceNotFoundException;
import com.pictu.iam.core.utilities.IdGeneratorString;
import com.pictu.customerService.entities.Photo;
import com.pictu.customerService.entities.Customer;
import com.pictu.customerService.externalServices.PhotoService;
import com.pictu.customerService.repositories.CustomerRepository;
import com.pictu.customerService.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PhotoService photoService;


    //private Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Override
    public Customer saveCustomer(Customer customer) {
        customer.setCustomerId(IdGeneratorString.customerIDGenerator());
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
    @Override
    public Customer getSingleCustomer(String customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id " + customerId));
        //Get Photos of the above customer from Photo Service
        //ArrayList<Photo> photosOfCustomer = restTemplate.getForObject("http://PHOTO-SERVICE/photos/customer/"+ customer.getCustomerId(), ArrayList.class);

        //Let us try fetching the photos Of the customer using the feign client.

        List<Photo> photos = photoService.getPhotosByCustomerId(customer.getCustomerId());
        customer.setPhotos(photos);
        return customer;
    }
}

