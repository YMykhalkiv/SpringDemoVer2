package com.example.springdemover2.model.exceptions;

public class CharacterNotFoundException extends Exception {
    public CharacterNotFoundException(String characterNotFound) {
        super(characterNotFound);
    }
}
