package com.dae.ep3.exception;

public class ClienteNotFoundException extends RuntimeException {
    public ClienteNotFoundException(Integer id) {
        super(String.format("El cliente con id %s no existe.", id));
    }
}
