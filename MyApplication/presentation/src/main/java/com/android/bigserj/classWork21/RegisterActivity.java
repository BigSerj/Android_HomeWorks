package com.android.bigserj.classWork21;


import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.bigserj.R;
import com.android.bigserj.classWork18.ClassWork18Activity;
import com.tbruyelle.rxpermissions2.RxPermissions;

import io.reactivex.functions.Consumer;


public class RegisterActivity extends AppCompatActivity implements RegisterView {

    private RegisterBasePresenter presenter;

    private ProgressBar progressBar;
    private Button registerButton;

    public static void show(Activity activity) {
        Intent intent = new Intent(activity, RegisterActivity.class);
        activity.startActivity(intent);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        presenter = new RegisterPresenter(this);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        registerButton = (Button) findViewById(R.id.registerButton);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onRegisterButtonClick("userName", "password");

                RxPermissions rxPermissions = new RxPermissions(RegisterActivity.this);
                rxPermissions
                        .request(Manifest.permission.ACCESS_FINE_LOCATION)
                        .subscribe(new Consumer<Boolean>() {
                            @Override
                            public void accept(Boolean aBoolean) {
                                if (aBoolean) {
                                    Toast.makeText(RegisterActivity.this, "TRUE",
                                            Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(RegisterActivity.this, "FALSE",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.onPause();
    }


    @Override
    public void showProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void dismiss() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void goToMainActivity() {
        ClassWork18Activity.show(this);
    }
}
