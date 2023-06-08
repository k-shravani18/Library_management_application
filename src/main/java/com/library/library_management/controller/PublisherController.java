package com.library.library_management.controller;

import com.library.library_management.model.Publisher;
import com.library.library_management.service.IPublisherService;
import com.library.library_management.service.impl.PublisherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("publisher")
public class PublisherController {
    @Autowired
    private PublisherServiceImpl publisherService;

    public Publisher addPublisher(Publisher Publisher) {
        return publisherService.addPublisher(Publisher);
    }

    public String updatePublisher(Publisher Publisher) {
        publisherService.updatePublisher(Publisher);
        return null;
    }

    public String deletePublisher(Publisher Publisher) {
        publisherService.deletePublisher(Publisher);
        return null;
    }

    public Publisher getById(Long publisher_id) {
        return publisherService.getById(publisher_id);
    }

    public List<Publisher> getAll() {
        return null;
    }
}
