package com.example.simpleandroidapp.repository.profile.repository;

import com.example.simpleandroidapp.model.User;
import com.example.simpleandroidapp.repository.FirestoreCallback;

public interface ProfileRepository {
    void getUser(FirestoreCallback<User> callback);
}
