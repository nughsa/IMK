package com.example.projekimk.login;

import android.content.Intent;
import android.content.SharedPreferences; // Tambahkan impor ini
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.projekimk.R;
import com.example.projekimk.main.MainActivity;
import com.example.projekimk.register.RegisterActivity;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    MaterialButton btnLogin, btnRegister;
    TextInputEditText inputUser, inputPassword;
    LoginViewModel loginViewModel;
    String strUsername, strPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setInitLayout();
        setInputData();
    }

    private void setInitLayout() {
        inputUser = findViewById(R.id.inputUser);
        inputPassword = findViewById(R.id.inputPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);

        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
    }

    private void setInputData() {
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strUsername = inputUser.getText().toString();
                strPassword = inputPassword.getText().toString();

                if (strUsername.isEmpty() || strPassword.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Ups, Form harus diisi semua!",
                            Toast.LENGTH_LONG).show();
                } else {
                    loginViewModel.getDataUser(strUsername, strPassword).observe(LoginActivity.this,
                            modelDatabases -> {
                                if (modelDatabases.size() != 0) {
                                    // Login berhasil, simpan username
                                    SharedPreferences sharedPreferences = getSharedPreferences("user_prefs", MODE_PRIVATE);
                                    SharedPreferences.Editor editor = sharedPreferences.edit();
                                    editor.putString("username", strUsername);
                                    editor.apply();

                                    // Pindah ke MainActivity
                                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                    startActivity(intent);
                                    finish(); // Mengakhiri LoginActivity
                                }
                            });
                }
            }
        });
    }
}
