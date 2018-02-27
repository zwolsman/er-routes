package com.s63d.registrationsystem.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView
import java.security.Principal

@Controller
class HomeController {

    @RequestMapping("/")
    fun homeController(principal: Principal) : ModelAndView {
        val x = ModelAndView("index.html")
        x.addObject("test", "1234")

        return x
    }
}