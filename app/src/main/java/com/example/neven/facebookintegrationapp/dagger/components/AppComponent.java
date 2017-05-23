package com.example.neven.facebookintegrationapp.dagger.components;

import com.example.neven.facebookintegrationapp.activities.BaseActivity;
import com.example.neven.facebookintegrationapp.dagger.modules.AppModule;
import com.example.neven.facebookintegrationapp.dagger.modules.FacebookModule;
import dagger.Component;

import javax.inject.Singleton;

/**
 * Created by Neven on 22.5.2017..
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(BaseActivity activity);

    FacebookComponent newFacebookSubComponent(FacebookModule module);

}
