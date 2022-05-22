package com.example.rest.SocialNetwork;

import org.springframework.http.HttpStatus;

public class NotFoundException extends Throwable {
    public NotFoundException(String person_not_found, String invalid_data, HttpStatus notFound) {
    }
}
