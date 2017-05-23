package com.example.neven.facebookintegrationapp.presenters;

import android.content.Context;
import com.facebook.login.LoginResult;

/**
 * Created by Neven on 23.5.2017..
 */
public interface FacebookPresenter {

    void setupFacebook();
    void onSuccess(String logTag, LoginResult loginResult);
    void onCancel(String logTag);
    void onError(String logTag);


}
