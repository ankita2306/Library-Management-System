package com.management.library.controller;

import com.management.library.entity.Book;
import com.management.library.entity.MyBookList;
import com.management.library.service.BookService;
import com.management.library.service.MyBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    public BookService bookService;

    @Autowired
    public MyBookService myBookService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/book_register")
    public String bookRegister() {
        return "bookRegister";
    }


    @GetMapping("/available_book")
    public ModelAndView getAllBBook() {
        List<Book> bookList = bookService.getAllBooks();
      /* ModelAndView m=new ModelAndView();
       m.setViewName("bookList");
       m.addObject("Book",bookList);
       return m;*/
        return new ModelAndView("bookList", "book", bookList);
    }

    @PostMapping("/save")
    public String addBook(@ModelAttribute Book b) {
        bookService.save(b);
        return "redirect:/available_book";
    }

    @GetMapping("/my_books")
    public String getMyBooks(Model model) {
        List<MyBookList> list=myBookService.getAllMyBooks();
        model.addAttribute("book",list);
        return "myBooks";
    }

    @RequestMapping("/myList/{id}")
    public String getMyList(@PathVariable("id") int id) {
        Book book = bookService.getBookById(id);
        MyBookList myBookList=new MyBookList(book.getId(),book.getName(),book.getAuthor(),book.getPrice());
        myBookService.saveMyBooks(myBookList);
        return "redirect:/my_books";
    }

    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") int id,Model model) {
        Book b=bookService.getBookById(id);
        model.addAttribute("book",b);
        return "bookEdit";
    }
    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id")int id) {
        bookService.deleteById(id);
        return "redirect:/available_books";
    }}
