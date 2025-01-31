package com.mathiasdarex.librarymanager.entity;

// Model létrehozása
// Készíts egy Book osztályt a következő attribútumokkal:
// id (Long)
// title (String)
// author (String)
// publicationYear (Integer)


import jakarta.validation.constraints.*;

public class Book {

    private Long id;

    @Size(min = 1, max = 200, message = "Title length must be between 1 to 200 characters")
    @NotBlank
    private String title;

    @Size(min = 1, max = 100, message = "Authors name length must be between 1 to 100 characters")
    @NotBlank
    private String author;

    @NotNull
    @Min(value = 1800, message = "Year cannot be earlier than 1800")
    @Max(value = 2100, message = "Year cannot be after 2100")
    private Integer publicationYear;

//
//    @NotNull
//    @Min(value = 1, message = "Pages must be at least 1")
//    @Max(value = 100000, message = "Pages must be maximum 100000")
//    private Integer pageCount;

//    @Pattern(regexp = "^(?:ISBN(?:-1[03])?:? )?(?=[0-9X]{10}$|(?=(?:[0-9]+[- ]){3})[- 0-9X]{13}$|97[89][0-9]{10}$|(?=(?:[0-9]+[- ]){4})[- 0-9]{17}$)(?:97[89][- ]?)?[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9X]$",
//            message = "Érvénytelen ISBN formátum")
//    private String isbn;

    public Book() {
    }

    public Book(Long id, String title, String author, Integer publicationYear) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }



    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publicationYear=" + publicationYear +
                '}';
    }
}
