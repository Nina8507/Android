package com.example.simpleandroidapp.repository.login.repository;

import com.example.simpleandroidapp.model.User;
import com.example.simpleandroidapp.repository.FirestoreCallback;

public interface LoginRepository {
    void registerUser(User user);
    void getUser(FirestoreCallback<User> callback);
    void logout();
    void login(User user);
}
