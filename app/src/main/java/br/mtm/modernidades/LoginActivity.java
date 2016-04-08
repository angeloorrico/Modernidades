package br.mtm.modernidades;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_login)
public class LoginActivity extends AppCompatActivity {

    @ViewById
    TextInputLayout tilLogin, tilPass;

    @ViewById
    TextInputEditText etPass, etLogin;

    @AfterViews
    void init(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Click(R.id.bt_login)
    void validarLogin(){
        if (etLogin.getText() == null || etLogin.getText().toString().isEmpty()) {
            tilLogin.setError("Preencha o login");
            return;
        }
        if (etPass.getText() == null || etPass.getText().toString().isEmpty()) {
            tilPass.setError("Preencha a senha");
            return;
        }
        if (etPass.getText().toString().equals("mtm") && etLogin.getText().toString().equals("mtm"))
            fazerLogin();
        else
            tilPass.setError("Login ou senha incorretos");

    }

    void fazerLogin(){
        Intent intent = new Intent(this, MainActivity_.class);
        ActivityCompat.startActivity(this, intent, null);
    }

}
