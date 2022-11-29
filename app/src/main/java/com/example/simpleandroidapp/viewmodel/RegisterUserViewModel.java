package com.example.simpleandroidapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.simpleandroidapp.model.User;
import com.example.simpleandroidapp.service.user.LoginService;
import com.example.simpleandroidapp.service.user.LoginServiceImpl;

public class RegisterUserViewModel extends AndroidViewModel {
    private final LoginService service;
    public RegisterUserViewModel(@NonNull Application application) {
        super(application);
        service = new LoginServiceImpl();
    }

    public void registerUser(User user) {
        service.registerUser(user);
    }
}
