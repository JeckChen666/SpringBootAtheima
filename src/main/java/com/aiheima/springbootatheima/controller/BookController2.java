package com.aiheima.springbootatheima.controller;

import com.aiheima.springbootatheima.entity.Book;
import com.aiheima.springbootatheima.service.IBookSevice;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
@RequestMapping("/books")
public class BookController2 {
    @Autowired
    private IBookSevice bookSevice;
    @GetMapping
    public List<Book> getAll(){
        return bookSevice.list();
    }
    @PostMapping
    public Boolean save(@RequestBody Book book){
        return bookSevice.save(book);
    }
    @PutMapping
    public Boolean update(@RequestBody Book book){
        return bookSevice.updateById(book);
    }
    @DeleteMapping("{id}")
    public Boolean delete(@PathVariable Integer id){
        return bookSevice.removeById(id);
    }
    @GetMapping("{id}")
    public Book getByIddd(@PathVariable Integer id){
        return bookSevice.getById(id);
    }
    @GetMapping("{currentPage}/{pageSize}")
    public IPage<Book> getPage(@PathVariable int currentPage,@PathVariable int pageSize,Book book){
        return bookSevice.getPage(currentPage,pageSize, book);
    }
}
