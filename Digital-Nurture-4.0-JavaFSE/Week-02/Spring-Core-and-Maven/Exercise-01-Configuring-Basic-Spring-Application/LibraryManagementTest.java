package com.library;

import com.library.repository.BookRepository;
import com.library.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import static org.junit.Assert.*;

public class LibraryManagementTest {

    @Test
    public void testSpringContextLoading() {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        assertNotNull("Spring application context should load successfully", context);

        BookRepository repo = (BookRepository) context.getBean("bookRepository");
        assertNotNull("BookRepository bean should be retrieved", repo);
        repo.executeRepositoryMethod();

        BookService service = (BookService) context.getBean("bookService");
        assertNotNull("BookService bean should be retrieved", service);
        service.executeServiceMethod();
    }
}