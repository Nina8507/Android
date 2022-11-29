package com.example.simpleandroidapp.repository.profile.repository;

import static android.content.ContentValues.TAG;

import android.net.Uri;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.simpleandroidapp.model.User;
import com.example.simpleandroidapp.repository.FirestoreCallback;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Map;

public class ProfileRepositoryImpl implements ProfileRepository{
    private static ProfileRepositoryImpl instance;
    private FirebaseFirestore database;
    private MutableLiveData<User> user;

    private ProfileRepositoryImpl() {
        user = new MutableLiveData<>();
        database = FirebaseFirestore.getInstance();
    }

    public static ProfileRepositoryImpl getInstance() {
        if (instance == null)
            instance = new ProfileRepositoryImpl();
        return instance;
    }

    @Override
    public void getUser(FirestoreCallback<User> callback) {
        FirebaseUser getInfo = FirebaseAuth.getInstance().getCurrentUser();
        /*if (getInfo != null) {
            String name = getInfo.getDisplayName();
            String email = getInfo.getEmail();
            Uri photoUrl = getInfo.getPhotoUrl();*/

        database.collection("users").document("Czf7lbuHAKxoKpBk6PgZ").get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                DocumentSnapshot result = task.getResult();
                if (result.exists()) {
                    Log.d(TAG, "DocumentSnapshot data: " + result.getData());
                    Map<String, Object> accountData = result.getData();
                    String firstName = (String) accountData.get("name");
                    String email = (String) accountData.get("email");
                    String phone = (String) accountData.get("phone");
                    String lastName = (String) accountData.get("surname");

                    User user = new User(firstName, lastName, email, phone);

                    callback.onCallback(user);
                    Log.d(TAG, "Profile" + accountData);
                } else {
                    Log.d(TAG, "No such document");
                }
            }
        });
    }
}
