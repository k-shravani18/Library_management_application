package com.library.library_management.service.impl;

import com.library.library_management.model.Publisher;
import com.library.library_management.repository.IPublisherRepository;
import com.library.library_management.service.IPublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherServiceImpl implements IPublisherService {
    @Autowired
    private IPublisherRepository publisherRepository;

    @Override
    public Publisher addPublisher(Publisher Publisher) {
        return null;
    }

    @Override
    public String updatePublisher(Publisher Publisher) {
        return null;
    }

    @Override
    public String deletePublisher(Publisher Publisher) {
        return null;
    }

    @Override
    public Publisher getById(Long publisher_id) {
        return null;
    }

    @Override
    public List<Publisher> getAll() {
        return null;
    }
}
