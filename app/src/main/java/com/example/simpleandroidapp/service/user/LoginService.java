package com.example.simpleandroidapp.service.user;

import androidx.lifecycle.MutableLiveData;

import com.example.simpleandroidapp.model.User;

public interface LoginService {
    MutableLiveData<User> getUser();
    void registerUser(User user);
    void logout();
    void login(User user);
}
