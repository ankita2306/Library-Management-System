package com.management.library.service;

import com.management.library.entity.MyBookList;
import com.management.library.repository.MyBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyBookService {

    @Autowired
    private MyBookRepository myBookRepository;

    public void saveMyBooks(MyBookList book)
    {
        myBookRepository.save(book);
    }
}
