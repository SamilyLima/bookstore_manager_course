package com.rodrigopeleias.bookstoremanager.utils;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.github.javafaker.Faker;
import com.rodrigopeleias.bookstoremanager.dto.BookDTO;
import com.rodrigopeleias.bookstoremanager.entity.Book;

import static com.fasterxml.jackson.databind.ObjectMapper.*;
import static com.rodrigopeleias.bookstoremanager.utils.AuthorUtils.createFakeAuthor;
import static com.rodrigopeleias.bookstoremanager.utils.AuthorUtils.createFakeAuthorDTO;


public class BookUtils {

    private static final Faker faker = Faker.instance();

    public static BookDTO createFakeBookDTO(){
        return BookDTO.builder()
                .id(faker.number().randomNumber())
                .name(faker.book().title())
                .pages(faker.number().numberBetween(0, 200))
                .chapters(faker.number().numberBetween(1,20))
                .isbn("0-596-52068-9")
                .publisherName(faker.book().publisher())
                .author(createFakeAuthorDTO())
                .build();

    }

    public static Book createFakeBook(){
        return Book.builder()
                .id(faker.number().randomNumber())
                .name(faker.book().title())
                .pages(faker.number().numberBetween(0, 200))
                .chapters(faker.number().numberBetween(1,20))
                .isbn("0-596-52068-9")
                .publisherName(faker.book().publisher())
                .author(createFakeAuthor())
                .build();

    }

    public static String asJsonString(BookDTO bookDTO){
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE, true);
            objectMapper.configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS, false);
            objectMapper.registerModules(new JavaTimeModule());
            
            return objectMapper.writeValueAsString(bookDTO);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
