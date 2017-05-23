package com.example.neven.facebookintegrationapp;

import android.app.Application;
import com.example.neven.facebookintegrationapp.dagger.components.AppComponent;
import com.example.neven.facebookintegrationapp.dagger.components.DaggerAppComponent;


/**
 * Created by Neven on 20.5.2017..
 */
public class MyApplication extends Application {

    private AppComponent appComponent;


    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.create();


    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
