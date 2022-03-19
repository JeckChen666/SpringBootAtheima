package com.aiheima.springbootatheima.service.impl;

import com.aiheima.springbootatheima.service.BookService;
import com.aiheima.springbootatheima.service.IBookSevice;
import lombok.experimental.Accessors;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookServiceImplTest {

    @Autowired
    private IBookSevice bookService;

    @Test
    void getById() {
        System.out.println(bookService.getById(3));
    }
}