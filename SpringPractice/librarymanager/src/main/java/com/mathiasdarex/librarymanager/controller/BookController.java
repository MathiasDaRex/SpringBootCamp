package com.mathiasdarex.librarymanager.controller;

import com.mathiasdarex.librarymanager.entity.Book;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {

    private List<Book> booksList;

    private Long id = 1L;

    @PostConstruct
    public void loadBooks() {
        booksList = new ArrayList<>();

        booksList.add(new Book(id++, "To Kill a Mockingbird", "Harper Lee", 1960));
        booksList.add(new Book(id++, "1984", "George Orwell", 1949));
        booksList.add(new Book(id++, "Pride and Prejudice", "Jane Austen", 1813));
        booksList.add(new Book(id++, "The Great Gatsby", "F. Scott Fitzgerald", 1925));
        booksList.add(new Book(id++, "One Hundred Years of Solitude", "Gabriel García Márquez", 1967));

    }

    // 1 list books
    @GetMapping("/books")
    public String showBookList(Model theModel) {
        // get books from list
        List<Book> bookList = booksList;
        // add to spring Model
        theModel.addAttribute("books", bookList);
        return "books";
    }

    // 2 show new book form
    @GetMapping("/showNewBookForm")
    public String showFormForNewBook(Model theModel) {
        // create model attribute to bind form data
        Book theBook = new Book();
        theModel.addAttribute("book", theBook);
        return "showBookForm";

    }

    // 3 save new book
    @PostMapping("/saveBook")
    public String saveBook(@ModelAttribute("book") Book theBook){
        theBook.setId(id++);
        booksList.add(theBook);
    return "redirect:/books";
    }


    // 4 show book details

}

