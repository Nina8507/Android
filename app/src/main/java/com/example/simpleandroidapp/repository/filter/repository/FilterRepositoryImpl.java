package com.example.simpleandroidapp.repository.filter.repository;

import static android.content.ContentValues.TAG;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.simpleandroidapp.model.Movie;
import com.example.simpleandroidapp.repository.FirestoreCallback;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

public class FilterRepositoryImpl implements FilterRepository{
    private static FilterRepositoryImpl instance;
    private FirebaseFirestore database;
    private MutableLiveData<List<Movie>> list;

    private FilterRepositoryImpl(){
        list = new MutableLiveData<>();
        database = FirebaseFirestore.getInstance();
    }

    public static FilterRepositoryImpl getInstance() {
        if (instance == null)
            instance = new FilterRepositoryImpl();
        return instance;
    }

    @Override
    public MutableLiveData<List<Movie>> getMovieList(FirestoreCallback<List<Movie>> callback) {
        database.collection("users").document("mP0OjJcYc6X1c5DWpFjM").collection("movies")
                .get().addOnCompleteListener(task -> {
            if(task.isSuccessful()) {
                QuerySnapshot document = task.getResult();
                List<Movie> list = document.toObjects(Movie.class);
                callback.onCallback(list);
            } else {
                Log.w(TAG, "Error getting documents.", task.getException());
            }
        });
        return list;
    }
}
