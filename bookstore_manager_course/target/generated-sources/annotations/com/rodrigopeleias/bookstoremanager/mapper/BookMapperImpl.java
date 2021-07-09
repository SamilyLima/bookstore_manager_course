package com.rodrigopeleias.bookstoremanager.mapper;

import com.rodrigopeleias.bookstoremanager.dto.AuthorDTO;
import com.rodrigopeleias.bookstoremanager.dto.BookDTO;
import com.rodrigopeleias.bookstoremanager.entity.Author;
import com.rodrigopeleias.bookstoremanager.entity.Book;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-07-07T10:22:27-0400",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.1 (Oracle Corporation)"
)
public class BookMapperImpl implements BookMapper {

    @Override
    public Book toModel(BookDTO bookDTO) {
        if ( bookDTO == null ) {
            return null;
        }

        Book book = new Book();

        book.setId( bookDTO.getId() );
        book.setName( bookDTO.getName() );
        book.setPages( bookDTO.getPages() );
        book.setChapters( bookDTO.getChapters() );
        book.setIsbn( bookDTO.getIsbn() );
        book.setPublisherName( bookDTO.getPublisherName() );
        book.setAuthor( authorDTOToAuthor( bookDTO.getAuthor() ) );

        return book;
    }

    @Override
    public BookDTO toDTO(Book book) {
        if ( book == null ) {
            return null;
        }

        BookDTO bookDTO = new BookDTO();

        bookDTO.setId( book.getId() );
        bookDTO.setName( book.getName() );
        bookDTO.setPages( book.getPages() );
        bookDTO.setChapters( book.getChapters() );
        bookDTO.setIsbn( book.getIsbn() );
        bookDTO.setPublisherName( book.getPublisherName() );
        bookDTO.setAuthor( authorToAuthorDTO( book.getAuthor() ) );

        return bookDTO;
    }

    protected Author authorDTOToAuthor(AuthorDTO authorDTO) {
        if ( authorDTO == null ) {
            return null;
        }

        Author author = new Author();

        author.setId( authorDTO.getId() );
        author.setName( authorDTO.getName() );
        author.setAge( authorDTO.getAge() );

        return author;
    }

    protected AuthorDTO authorToAuthorDTO(Author author) {
        if ( author == null ) {
            return null;
        }

        AuthorDTO authorDTO = new AuthorDTO();

        authorDTO.setId( author.getId() );
        authorDTO.setName( author.getName() );
        authorDTO.setAge( author.getAge() );

        return authorDTO;
    }
}
