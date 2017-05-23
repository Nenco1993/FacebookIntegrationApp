package com.example.neven.facebookintegrationapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.neven.facebookintegrationapp.MyApplication;
import com.example.neven.facebookintegrationapp.R;
import com.example.neven.facebookintegrationapp.dagger.modules.FacebookModule;
import com.example.neven.facebookintegrationapp.presenters.FacebookPresenter;
import com.example.neven.facebookintegrationapp.views.FacebookView;
import com.facebook.*;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import org.json.JSONException;
import org.json.JSONObject;

import javax.inject.Inject;
import java.util.Arrays;

public class MainActivity extends BaseActivity implements FacebookView {

    @BindView(R.id.bFacebookLogin)
    LoginButton bFacebookLogin;

    @BindString(R.string.fblogin)
    String TAG_FBLOGIN;

    @Inject
    FacebookPresenter presenter;

    @Inject
    CallbackManager callbackManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ((MyApplication) getApplication()).getAppComponent().newFacebookSubComponent(new FacebookModule(this, this, this)).inject(this);
        presenter.setupFacebook();

        bFacebookLogin.setReadPermissions("public_profile");
        bFacebookLogin.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

                presenter.onSuccess(TAG_FBLOGIN, loginResult);


            }

            @Override
            public void onCancel() {

                presenter.onCancel(TAG_FBLOGIN);

            }

            @Override
            public void onError(FacebookException error) {


                presenter.onError(TAG_FBLOGIN);

            }
        });


    }

    @Override
    public void showData(String email, String gender, String birthday) {

        Toast.makeText(this, "your email is: " + email, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "your gender is: " + gender, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "your birthday is: " + birthday, Toast.LENGTH_SHORT).show();


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }


}
