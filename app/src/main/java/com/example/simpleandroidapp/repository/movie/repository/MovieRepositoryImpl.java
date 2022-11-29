package com.example.simpleandroidapp.repository.movie.repository;

import static android.content.ContentValues.TAG;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.simpleandroidapp.model.Movie;
import com.example.simpleandroidapp.repository.FirestoreCallback;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

public class MovieRepositoryImpl implements MovieRepository{
    private static MovieRepositoryImpl instance;
    private final FirebaseFirestore database;
    private final MutableLiveData<List<Movie>> list;

    private MovieRepositoryImpl() {
        database = FirebaseFirestore.getInstance();
        list = new MutableLiveData<>();
    }

    public static MovieRepositoryImpl getInstance(){
        if (instance == null)
            instance = new MovieRepositoryImpl();
        return instance;
    }

    @Override
    public void addMovieToFavourite(Movie movie) {
        database.collection("users").document("mP0OjJcYc6X1c5DWpFjM")
                .collection("favouriteMovieList").add(movie)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                    }
                });
    }

    @Override
    public MutableLiveData<List<Movie>> getFavouriteList(FirestoreCallback<List<Movie>> callback) {
        database.collection("users").document("mP0OjJcYc6X1c5DWpFjM")
                .collection("favouriteMovieList").get().addOnCompleteListener(task -> {
                    if(task.isSuccessful()){
                        QuerySnapshot doc = task.getResult();
                        if (doc != null){
                            List<Movie> list = doc.toObjects(Movie.class);
                            callback.onCallback(list);
                        }
                    } else {
                        Log.w(TAG, "Error getting documents.", task.getException());
                    }
                });
        return list;
    }
}