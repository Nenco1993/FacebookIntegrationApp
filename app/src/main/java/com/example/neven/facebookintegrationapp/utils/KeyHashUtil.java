package com.example.neven.facebookintegrationapp.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Base64;
import android.util.Log;

import java.security.MessageDigest;

/**
 * Created by Neven on 22.5.2017..
 */
public class KeyHashUtil {

    private Context context;

    public KeyHashUtil(Context context) {
        this.context = context;
    }

    public void generateKeyHash() {


        try {
            PackageInfo info = context.getPackageManager().getPackageInfo(
                    "com.example.neven.facebookintegrationapp",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (Exception e) {

            e.printStackTrace();

        }
    }




}
