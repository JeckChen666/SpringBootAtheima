package com.aiheima.springbootatheima.dao;

import com.aiheima.springbootatheima.entity.Book;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sun.source.tree.LambdaExpressionTree;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.PrimitiveIterator;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookDaoTest {
    @Autowired
    private BookDao bookDao;

    @Test
    void testGetById() {
        System.out.println(bookDao.selectById(1));
    }

    @Test
    void testSave() {
        for (int i = 0; i < 100; i++) {
            Book book = new Book();
            book.setType("test"+i);
            book.setName("test"+i);
            book.setDescription("test"+i);
            bookDao.insert(book);
        }
    }

    @Test
    void testGetAll(){
        System.out.println(bookDao.selectList(null));
    }

    @Test
    void testGetPage(){
        IPage page = new Page(2,5);
        bookDao.selectPage(page,null);
        System.out.println(page.getRecords());
    }
    @Test
    void testGetBy(){
        String name="test";
        LambdaQueryWrapper<Book> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(name!=null,Book::getName,name);
        bookDao.selectList(lambdaQueryWrapper);
    }
}