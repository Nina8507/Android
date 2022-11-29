package com.example.simpleandroidapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.simpleandroidapp.model.User;
import com.example.simpleandroidapp.service.user.LoginService;
import com.example.simpleandroidapp.service.user.LoginServiceImpl;
import com.google.firebase.auth.FirebaseAuth;

public class LoginViewModel extends AndroidViewModel {
    private LoginService service;
    private FirebaseAuth firebaseAuth;
    private MutableLiveData<Boolean> showError;
    private MutableLiveData<Boolean> isSigned;

    public LoginViewModel(@NonNull Application application) {
        super(application);
        service = new LoginServiceImpl();
    }

    public void init() {
        firebaseAuth = FirebaseAuth.getInstance();
        showError = new MutableLiveData<>(false);
        isSigned = new MutableLiveData<>(false);
    }

    public void login(User user) {
        if (user.getEmail() != null && user.getPassword() != null && !user.getEmail().isEmpty() && !user.getPassword().isEmpty()) {
            showError.postValue(false);
            service.login(user);
        }
        else {
            showError.postValue(true);
        }
    }

    public MutableLiveData<Boolean> getShowError() {
        return showError;
    }

    public MutableLiveData<Boolean> getIsSigned() {
        return isSigned;
    }

}
