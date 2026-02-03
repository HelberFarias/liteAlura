package com.example.litearula.service;

public interface IConverteDados {
    <T> T parseJson(String json, Class<T> classe);
}
