package com.example.neven.facebookintegrationapp.dagger.components;

import com.example.neven.facebookintegrationapp.activities.MainActivity;
import com.example.neven.facebookintegrationapp.dagger.modules.FacebookModule;
import com.example.neven.facebookintegrationapp.dagger.scopes.ActivityScope;
import dagger.Subcomponent;

/**
 * Created by Neven on 23.5.2017..
 */
@ActivityScope
@Subcomponent(modules = {FacebookModule.class})
public interface FacebookComponent {


    void inject(MainActivity activity);




}
