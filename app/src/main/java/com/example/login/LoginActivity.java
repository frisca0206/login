package com.example.login;

import android.app.AlertDialog;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText username, password;
    Button btnlogin;
    String keynama, keypass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnlogin = findViewById(R.id.tombollogin);
        btnlogin.setOnClickListener(view -> {
            username = findViewById(R.id.editteksuser);
            password = findViewById(R.id.edittekspassword);
            btnlogin = findViewById(R.id.tombollogin);

            keynama = username.getText().toString();
            keypass = password.getText().toString();

            //username diisi dengan admin dan password dengan admin
            if (keynama.equals("admin") && keypass.equals("280423")) {
                //jika login berhasil
                Toast.makeText(getApplicationContext(),
                        "LOGIN BERHASIL", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                LoginActivity.this.startActivity(intent);
                finish();
            }
            else {
                //jika login gagal
                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                builder.setMessage("Username atau password salah").setNegativeButton
                        ("Ulangi", null).create().show();
                username.setText("");
                password.setText("");
            }
        });
    }
}