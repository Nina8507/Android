package com.example.simpleandroidapp.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;

import com.example.simpleandroidapp.R;
import com.example.simpleandroidapp.model.User;
import com.example.simpleandroidapp.viewmodel.LoginViewModel;
import com.google.android.material.textfield.TextInputEditText;

public class LoginFragment extends Fragment {
    private TextInputEditText email, password, error;
    private Button signInBtn;
    private NavController navController;
    private LoginViewModel viewModel;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        viewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        viewModel.init();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findViews(view);

        viewModel.getShowError().observe(getViewLifecycleOwner(), b -> {
            int visibility = b ? View.VISIBLE : View.INVISIBLE;
            error.setVisibility(visibility);
        });

        viewModel.getIsSigned().observe(getViewLifecycleOwner(), a -> {
            if (a) {
                navController.navigate(R.id.nav_home);
            }
        });
        User user = new User(email.getText().toString(), password.getText().toString());
        signInBtn.setOnClickListener((v) -> viewModel.login(user));
    }

    private void findViews(@NonNull View view) {
        email = view.findViewById(R.id.emailEditSignIn);
        password = view.findViewById(R.id.passwordEditSignIn);
        signInBtn = view.findViewById(R.id.signInBtn);
        error = view.findViewById(R.id.signin_error_message);
    }
}
