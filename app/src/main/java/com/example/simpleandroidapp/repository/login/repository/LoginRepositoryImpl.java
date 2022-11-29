package com.example.simpleandroidapp.repository.login.repository;

import static android.content.ContentValues.TAG;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.simpleandroidapp.model.User;
import com.example.simpleandroidapp.repository.FirestoreCallback;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Map;

public class LoginRepositoryImpl implements LoginRepository{
    private static LoginRepositoryImpl instance;
    private FirebaseFirestore database;
    private final FirebaseAuth  firebaseAuth;
    private MutableLiveData<User> user;

    private LoginRepositoryImpl() {
        user = new MutableLiveData<>();
        database = FirebaseFirestore.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();
    }

    public static LoginRepositoryImpl getInstance() {
        if (instance == null)
            instance = new LoginRepositoryImpl();
        return instance;
    }

    @Override
    public void login(User user) {
            firebaseAuth.signInWithEmailAndPassword(user.getEmail(), user.getPassword()).addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    Log.d(TAG, "signing in user:success");
                } else {
                    Log.w(TAG, "signing in user:failure", task.getException());
                }
            });
    }

    @Override
    public void registerUser(User user) {
        firebaseAuth.createUserWithEmailAndPassword(user.getEmail(), user.getPassword()).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                // Sign in success, update UI with the signed-in user's information
                Log.d(TAG, "createUserWithEmail:success");
                FirebaseUser registerUser = firebaseAuth.getCurrentUser();
                database.collection("users").add(registerUser)
                        .addOnSuccessListener(documentReference -> Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId()))
                        .addOnFailureListener(e -> Log.w(TAG, "Error adding document", e));
            } else {
                // If sign in fails, display a message to the user.
                Log.w(TAG, "createUserWithEmail:failure", task.getException());
            }
        });
    }

    @Override
    public void getUser(FirestoreCallback<User> callback) {
        database.collection("users").document("Czf7lbuHAKxoKpBk6PgZ").get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                DocumentSnapshot result = task.getResult();
                if (result.exists()) {
                    Log.d(TAG, "DocumentSnapshot data: " + result.getData());
                    Map<String, Object> userData = result.getData();
                    String email = (String) userData.get("email");
                    String password = (String) userData.get("password");

                    User user = new User(email, password);

                    callback.onCallback(user);
                    Log.d(TAG, "Profile" + userData);
                } else {
                    Log.d(TAG, "No such document");
                }
            }
        });
    }

    @Override
    public void logout() {
        FirebaseAuth.AuthStateListener user = (FirebaseAuth.AuthStateListener) firebaseAuth.getCurrentUser();
        firebaseAuth.removeAuthStateListener(user);
    }
}
