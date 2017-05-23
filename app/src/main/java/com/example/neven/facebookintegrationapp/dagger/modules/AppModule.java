package com.example.neven.facebookintegrationapp.dagger.modules;

import com.facebook.CallbackManager;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

/**
 * Created by Neven on 22.5.2017..
 */
@Module
public class AppModule {

    private CallbackManager callbackManager;

    @Provides
    @Singleton
    CallbackManager provideCallbackManager() {


        return callbackManager = CallbackManager.Factory.create();
    }


}
