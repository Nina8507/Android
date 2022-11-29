package com.example.simpleandroidapp.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.simpleandroidapp.R;
import com.example.simpleandroidapp.model.User;
import com.example.simpleandroidapp.viewmodel.ProfileViewModel;

public class ProfileFragment extends Fragment {
    private ImageView imageView;
    private TextView firstName, lastName, email, contactNo;
    private Button profileImage;
    private ProfileViewModel viewModel;

    public ProfileFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        findViews(view);
        viewModel = new ViewModelProvider(this).get(ProfileViewModel.class);
        viewModel.getUser();
        viewModel.getUserPic();
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (viewModel.getUser() != null) {
            viewModel.getUser().observe(getViewLifecycleOwner(), user -> {
                firstName.setText(user.getFirstName());
                lastName.setText(user.getLastName());
                email.setText(user.getEmail());
                contactNo.setText(user.getPhone());
            });
        }


    }

    private void findViews(View view) {
        //imageView = view.findViewById(R.id.profile_image);
        //firstName = view.findViewById(R.id.profile_first_name);
        //lastName = view.findViewById(R.id.profile_last_name);
        //email = view.findViewById(R.id.profile_email);
        //contactNo = view.findViewById(R.id.profile_phone_no);
        //profileImage = view.findViewById(R.id.profile_image);
    }
}
