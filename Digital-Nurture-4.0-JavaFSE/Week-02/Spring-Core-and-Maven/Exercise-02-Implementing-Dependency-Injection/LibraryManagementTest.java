package com.library;

import com.library.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import static org.junit.Assert.*;

public class LibraryManagementTest {

    @Test
    public void testDependencyInjection() {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        assertNotNull("Spring application context should load successfully", context);

        BookService service = (BookService) context.getBean("bookService");
        assertNotNull("BookService bean should be retrieved", service);

        assertNotNull("BookRepository dependency should be injected", service.getBookRepository());

        service.executeServiceMethod();
    }
}