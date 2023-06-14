package com.library.library_management.service.impl;

import com.library.library_management.exceptions.MemberNotFoundException;
import com.library.library_management.exceptions.PublisherNotFoundException;
import com.library.library_management.model.Address;
import com.library.library_management.model.Member;
import com.library.library_management.model.Publisher;
import com.library.library_management.repository.IPublisherRepository;
import com.library.library_management.service.IPublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PublisherServiceImpl implements IPublisherService {
    @Autowired
    private IPublisherRepository publisherRepository;

    @Override
    public Publisher addPublisher(Publisher publisher, Address address) {
        if (publisher.getAddressList() == null) {
            publisher.setAddressList(new ArrayList<>());
        }
        if (address.getPublisher() == null) {
            address.setPublisher(publisher);
        }

        publisher.getAddressList().add(address);
       return publisherRepository.save(publisher);
    }

    @Override
    public Publisher updatePublisher(Publisher publisher,Address address) {
        Publisher existingPublisher = publisherRepository.findById(publisher.getPublisherId()).orElse(null);
        if (existingPublisher == null) {
            return null;
        }
        existingPublisher.setName(publisher.getName());

        List<Address> addresses = existingPublisher.getAddressList();
        if (!addresses.isEmpty()) {
            Address existingAddress = addresses.get(0);
            existingAddress.setLocation(address.getLocation());
            existingAddress.setPhoneNumber(address.getPhoneNumber());
        }

        return publisherRepository.save(existingPublisher);
    }

    @Override
    public void deletePublisher(Publisher publisher) {
        Publisher existingPublisher = publisherRepository.findById(publisher.getPublisherId()).orElse(null);
        if (existingPublisher == null) {
            new PublisherNotFoundException("Publisher Not Found");
        }
        else{
            publisherRepository.delete(existingPublisher);
        }
    }

    @Override
    public Publisher getById(Long publisher_id) {
        return publisherRepository.findById(publisher_id).orElseThrow(
                () -> new PublisherNotFoundException("Publisher Not Found " + publisher_id)
        );
    }

    @Override
    public List<Publisher> getAll() {
       return publisherRepository.findAll();
    }
}
