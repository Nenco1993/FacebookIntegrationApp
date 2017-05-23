package com.example.neven.facebookintegrationapp.dagger.modules;

import android.app.Activity;
import android.content.Context;
import com.example.neven.facebookintegrationapp.dagger.scopes.ActivityScope;
import com.example.neven.facebookintegrationapp.presenters.FacebookPresenter;
import com.example.neven.facebookintegrationapp.presenters.FacebookPresenterImpl;
import com.example.neven.facebookintegrationapp.utils.KeyHashUtil;
import com.example.neven.facebookintegrationapp.views.FacebookView;
import dagger.Module;
import dagger.Provides;

import javax.inject.Inject;

/**
 * Created by Neven on 23.5.2017..
 */
@Module
public class FacebookModule {


    private Context context;
    private Activity activity;
    private FacebookView view;

    public FacebookModule(Context context, Activity activity, FacebookView view) {
        this.context = context;
        this.activity = activity;
        this.view = view;
    }

    @Provides
    @ActivityScope
    FacebookPresenter provideFacebookPresenter(FacebookPresenterImpl presenter) {

        return presenter;
    }

    @Provides
    @ActivityScope
    KeyHashUtil provideKeyHashUtil() {

        return new KeyHashUtil(context);


    }

    @Provides
    @ActivityScope
    FacebookView provideFacebookView(){

        return view;


    }


}
