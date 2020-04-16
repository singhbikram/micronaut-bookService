package microliqui2.domain

import grails.gorm.annotation.Entity

//@Entity
class Book {

    String bookId
    String name
    String author
    String genre

    static constrains = {
        bookId index:'book_idx'
        name nullable: false
        author nullable: false
        genre nullable: true
    }


    @Override
    public String toString() {
        return "Book{" +
                "bookId='" + bookId + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}