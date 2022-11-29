package com.example.simpleandroidapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.simpleandroidapp.model.User;
import com.example.simpleandroidapp.service.profile.ProfileService;
import com.example.simpleandroidapp.service.profile.ProfileServiceImpl;

public class ProfileViewModel extends AndroidViewModel {
    private MutableLiveData<User> user;
    private ProfileService service;

    public ProfileViewModel(@NonNull Application application) {
        super(application);
        service = new ProfileServiceImpl();
    }

    public LiveData<User> getUser() {
        return service.getUser();

    }

    public void getUserPic() {
    }
}
