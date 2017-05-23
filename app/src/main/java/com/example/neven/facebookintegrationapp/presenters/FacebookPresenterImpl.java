package com.example.neven.facebookintegrationapp.presenters;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.example.neven.facebookintegrationapp.R;
import com.example.neven.facebookintegrationapp.utils.KeyHashUtil;
import com.example.neven.facebookintegrationapp.views.FacebookView;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import org.json.JSONException;
import org.json.JSONObject;

import javax.inject.Inject;

/**
 * Created by Neven on 23.5.2017..
 */
public class FacebookPresenterImpl implements FacebookPresenter {

    @Inject
    KeyHashUtil util;

    @Inject
    FacebookView view;

    @Inject
    public FacebookPresenterImpl(KeyHashUtil util) {
        this.util = util;
    }

    @Override
    public void setupFacebook() {


        util.generateKeyHash();


    }

    @Override
    public void onSuccess(String logTag, LoginResult loginResult) {

        Log.d(logTag, "success");
        GraphRequest request = GraphRequest.newMeRequest(loginResult.getAccessToken(), (object, response) -> {

            try {

                String email = object.getString("email");
                String gender = object.getString("gender");
                String birthday = object.getString("birthday");
                view.showData(email, gender, birthday);

            } catch (JSONException e) {
                e.printStackTrace();
            }


        });


        Bundle parameters = new Bundle();
        parameters.putString("fields", "email,birthday,gender");
        request.setParameters(parameters);
        request.executeAsync();


    }

    @Override
    public void onCancel(String logTag) {

        Log.d(logTag, "canceled");


    }

    @Override
    public void onError(String logTag) {

        Log.d(logTag, "error");


    }
}
