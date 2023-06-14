package com.library.library_management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InternationalizationController {
    @RequestMapping(value= "/i18n", method= RequestMethod.GET)
    public ModelAndView internationalization() {
        System.out.println("Method is called....");

        ModelAndView modelview = new ModelAndView();
        modelview.addObject(
                "welcome_msg",
                "SpringMvcInternationalizationDemo");
        modelview.setViewName("greetings");
        return modelview;
    }

}
