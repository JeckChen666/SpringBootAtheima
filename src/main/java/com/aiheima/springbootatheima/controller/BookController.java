package com.aiheima.springbootatheima.controller;

import com.aiheima.springbootatheima.controller.utils.R;
import com.aiheima.springbootatheima.entity.Book;
import com.aiheima.springbootatheima.service.IBookSevice;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private IBookSevice bookSevice;

    @GetMapping
    public R getAll() {
        return new R(true,bookSevice.list());
    }

    @PostMapping
    public R save(@RequestBody Book book) {
        return new R(bookSevice.save(book));
    }

    @PutMapping
    public R update(@RequestBody Book book) {
        return new R(bookSevice.updateById(book));
    }

    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id) {
        return new R(bookSevice.removeById(id));
    }

    @GetMapping("{id}")
    public R getByIddd(@PathVariable Integer id) {
        return new R(true,bookSevice.getById(id));
    }

    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize,Book book) {
        System.out.println("========>"+book);
        IPage<Book> page = bookSevice.getPage(currentPage,pageSize,book);
        if (currentPage>page.getPages()){
            page = bookSevice.getPage((int)page.getPages(),pageSize,book);
        }
        return new R(true,page);
    }
}
