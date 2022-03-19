package com.aiheima.springbootatheima.service;

import com.aiheima.springbootatheima.entity.Book;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

public interface IBookSevice extends IService<Book> {
    IPage<Book> getPage(int currentPage, int pageSize, Book book);
}
