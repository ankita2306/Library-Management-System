package com.management.library.controller;

import com.management.library.service.MyBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyBookController {

   @Autowired
   private MyBookService myBookService;

    @DeleteMapping("/deleteMyList/{id}")
    public String deleteMyList(@PathVariable("id") int id) {
        myBookService.deleteById(id);
        return "redirect:/my_books";
    }
}
