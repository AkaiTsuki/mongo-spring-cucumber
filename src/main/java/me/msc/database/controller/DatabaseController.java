package me.msc.database.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by jiachiliu on 2/12/15.
 */

@Controller
@RequestMapping("/database")
public class DatabaseController {

    @RequestMapping("")
    public ModelAndView databases() {
        System.out.println("Databases");
        ModelAndView mav = new ModelAndView("database");
        mav.addObject("user", "Admin");
        return mav;
    }


}
