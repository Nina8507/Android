package com.example.simpleandroidapp.service.user;

import androidx.lifecycle.MutableLiveData;

import com.example.simpleandroidapp.model.User;
import com.example.simpleandroidapp.repository.login.repository.LoginRepository;
import com.example.simpleandroidapp.repository.login.repository.LoginRepositoryImpl;

public class LoginServiceImpl implements LoginService {
    private LoginRepository repository;
    private MutableLiveData<User> userData;

    public LoginServiceImpl(){
        repository = LoginRepositoryImpl.getInstance();
        userData = new MutableLiveData<>();
    }

    @Override
    public MutableLiveData<User> getUser() {
        repository.getUser((user) -> {
            userData.setValue(user);
        });
        return userData;
    }

    @Override
    public void registerUser(User user) {
        repository.registerUser(user);
    }

    @Override
    public void logout() {
        repository.logout();
    }

    @Override
    public void login(User user) {
        repository.login(user);
    }
}
