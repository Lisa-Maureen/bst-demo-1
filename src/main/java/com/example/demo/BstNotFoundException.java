package com.example.demo;

class BstNotFoundException extends RuntimeException {

    BstNotFoundException(String code) {
        super("Es konnte keine Betriebsstelle zum folgenden Code gefunden werden: " + code);
    }
}
