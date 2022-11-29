package com.example.simpleandroidapp.service.profile;

import androidx.lifecycle.MutableLiveData;

import com.example.simpleandroidapp.model.User;

public interface ProfileService {
    MutableLiveData<User> getUser();
}
