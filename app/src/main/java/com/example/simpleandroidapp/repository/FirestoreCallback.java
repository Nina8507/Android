package com.example.simpleandroidapp.repository;

public interface FirestoreCallback<T> {
    void onCallback(T callbackType);
}
