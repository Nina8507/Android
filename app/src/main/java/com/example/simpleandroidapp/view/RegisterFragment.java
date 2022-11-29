package com.example.simpleandroidapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.simpleandroidapp.R;
import com.example.simpleandroidapp.model.User;
import com.example.simpleandroidapp.viewmodel.RegisterUserViewModel;

public class RegisterFragment extends Fragment {
    private EditText email, password, firstName, lastName;
    private ImageView profileUrl;
    private Button register, uploadPic;
    private RegisterUserViewModel viewModel;

    private static final int PICK_IMAGE_REQUEST = 1;

    public RegisterFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        viewModel = new ViewModelProvider(this).get(RegisterUserViewModel.class);
        findViews(view);
        return view;
    }

    private void findViews(View view) {
        //email = view.findViewById(R.id.email);
        //password = view.findViewById(R.id.password);
        //firstName = view.findViewById(R.id.firstName);
        //lastName = view.findViewById(R.id.lastName);
        //register = view.findViewById(R.id.register_button);
        //uploadPic = view.findViewById(R.id.uploadPic_button);
        //profileUrl = view.findViewById(R.id.profile_picture);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        registerData();
        uploadProfilePic();
    }

    private void uploadProfilePic() {
        uploadPic.setOnClickListener((v -> {
            User user = new User();
            choosePicture();
        }));
    }

    private void registerData() {
        register.setOnClickListener((v -> {
            User user = new User();

            user.setEmail(email.getText().toString());
            user.setPassword(password.getText().toString());
            user.setFirstName(firstName.getText().toString());
            user.setLastName(lastName.getText().toString());

            viewModel.registerUser(user);
        }));
    }

    private void choosePicture() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }
}
