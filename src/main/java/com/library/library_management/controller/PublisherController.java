package com.library.library_management.controller;

import com.library.library_management.exceptions.CategoryNotFoundException;
import com.library.library_management.exceptions.PublisherNotFoundException;
import com.library.library_management.model.Address;
import com.library.library_management.model.Category;
import com.library.library_management.model.Publisher;
import com.library.library_management.service.IPublisherService;
import com.library.library_management.service.impl.PublisherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/publisher")
public class PublisherController {
    @Autowired
    private PublisherServiceImpl publisherService;

    @GetMapping("/publisher_form")
    public String showPublisherForm(Model model) {
        model.addAttribute("publisher", new Publisher());
        model.addAttribute("address", new Address());
        return "createPublisherForm";
    }
    @PostMapping(value = "/add_publisher")
    public String addPublisher(@ModelAttribute("publisher") Publisher publisher,
                               @ModelAttribute("address") Address address, Model model){
        publisher.setName(publisher.getName().toUpperCase());

            publisherService.addPublisher(publisher, address);
            System.out.println("The given details entered into the database....");
            return "redirect:/publisher/success";
        }

    @GetMapping("/success")
    public String showSuccessPage() {
        return "success";
    }
    @GetMapping("/editPublisher")
    public String showEditForm(@RequestParam("publisherId") Long publisherId, Model model) {
        try {
            Publisher publisher =publisherService.getById(publisherId);
            if (publisher == null) {
                throw new PublisherNotFoundException("publisher not found with ID: " + publisherId);
            }

            model.addAttribute("publisher", publisher);
            model.addAttribute("address",publisher.getAddressList().get(0));

            return "editPublisherForm";
        } catch (PublisherNotFoundException e) {
            return handlingPublisherNotFoundException(model);
        }
    }
    @PutMapping("/updatePublisher")
    public String updatePublisher(@ModelAttribute("publisher") Publisher publisher,
                                 @ModelAttribute("address") Address address,
                                 Model model) {
        publisher.setName(publisher.getName().toUpperCase());
        publisherService.updatePublisher(publisher,address);

        return "redirect:/publisher/editSuccess";
    }

    @GetMapping("/editSuccess")
    public String updationSuccess(Model model) {
        String successMessage = "Publisher Updated Successfully";
        model.addAttribute("successMessage", successMessage);
        return "globalSuccessForm";
    }



    @GetMapping("/delete")
    public String showDeleteForm(@RequestParam("publisherId") Long publisherId, Model model) {
        try {
            Publisher publisher = publisherService.getById(publisherId);
            if (publisher == null) {
                throw new PublisherNotFoundException("Publisher not found with ID: " + publisherId);
            }

            model.addAttribute("publisher", publisher);
            model.addAttribute("address",publisher.getAddressList().get(0));

            return "deletePublisherForm";
        } catch (PublisherNotFoundException e) {
            return handlingPublisherNotFoundException(model);
        }
    }


    @DeleteMapping("/deletePublisher")
    public String deletePublisher(@ModelAttribute("publisher") Publisher publisher,
                                 @ModelAttribute("address") Address address,
                                 Model model) {

        publisherService.deletePublisher(publisher);

        return "redirect:/publisher/deleteSuccess";
    }

    @GetMapping("/deleteSuccess")
    public String deleteSuccess(Model model) {
        String successMessage = "Publisher Deleted Successfully";
        model.addAttribute("successMessage", successMessage);
        return "globalSuccessForm";
    }

    @GetMapping("/allPublishers")
    public String getAllPublishers(Model model) {
        List<Publisher> publishers = publisherService.getAll();
        model.addAttribute("publishers", publishers);
        return "getPublishers";
    }
    @ExceptionHandler(PublisherNotFoundException.class)
    private String handlingPublisherNotFoundException(Model model) {
        model.addAttribute("", "PublisherNotFoundException");
        return "publisherNotFoundException";
    }
}
