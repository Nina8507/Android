package com.example.simpleandroidapp.service.profile;

import androidx.lifecycle.MutableLiveData;

import com.example.simpleandroidapp.model.User;
import com.example.simpleandroidapp.repository.profile.repository.ProfileRepository;
import com.example.simpleandroidapp.repository.profile.repository.ProfileRepositoryImpl;

public class ProfileServiceImpl implements ProfileService{
    private ProfileRepository repository;
    private MutableLiveData<User> userData;

    public ProfileServiceImpl() {
        repository = ProfileRepositoryImpl.getInstance();
        userData = new MutableLiveData<>();
    }

    @Override
    public MutableLiveData<User> getUser() {
        repository.getUser((user) -> {
            userData.setValue(user);
        });
        return userData;
    }
}
