package com.nectarmicrosystems.me.android.activities;

import android.util.Log;
import android.Manifest;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import com.nectarmicrosystems.me.android.utilities.SecurityManager;
import com.nectarmicrosystems.me.android.utilities.PreferencesManager;
import com.nectarmicrosystems.me.android.modules.quotes.QuotesQueryTask;

import java.util.*;

public class SplashActivity extends AppCompatActivity {

    private static final int REQUEST_ID_MULTIPLE_PERMISSIONS = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestPermissions();
        if (isNewDay()) getNewData();
    }

    /*
     * request app permissions
     */
    private void requestPermissions() {
        List<String> permissionsNeeded = new ArrayList<>();

        int internetPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET);

        if (internetPermission != PackageManager.PERMISSION_GRANTED)
            permissionsNeeded.add(Manifest.permission.INTERNET);

        if (Build.VERSION.SDK_INT >= 23) {
            if (!permissionsNeeded.isEmpty()) {
                ActivityCompat.requestPermissions(
                        this,
                        permissionsNeeded.toArray(new String[permissionsNeeded.size()]),
                        REQUEST_ID_MULTIPLE_PERMISSIONS
                );
            }
            else onPermissionsGranted();
        }
        else startNextActivity();
    }

    /*
     * start main activity after permissions are resolved
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        Log.i(getClass().getCanonicalName(), "on request permissions result");

        int internetPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET);

        if (internetPermission != PackageManager.PERMISSION_GRANTED){
            Toast.makeText(this, "Me. needs internet connectivity to function optimally", Toast.LENGTH_LONG).show();
            finish();
        }
        else onPermissionsGranted();
    }

    private void onPermissionsGranted() {
        Log.v(getClass().getCanonicalName(), "Permissions granted");
        startNextActivity();
    }

    /*
     * If the application is password protected, launch the password activity
     * else go straight to the main activity
     */
    private void startNextActivity() {
        SecurityManager securityManager = new SecurityManager(this);
        Class nextActivity = securityManager.checkPasswordProtection() ? PasswordActivity.class : MainActivity.class;
        startActivity(new Intent(this, nextActivity));
        finish();
    }

    private boolean isNewDay() {
        PreferencesManager preferencesManager = new PreferencesManager(this);
        Calendar last = preferencesManager.getLastRunDate();
        Calendar now = Calendar.getInstance();

        boolean sameDay = last.get(Calendar.YEAR) == now.get(Calendar.YEAR) &&
                last.get(Calendar.DAY_OF_YEAR) == now.get(Calendar.DAY_OF_YEAR);

        Log.i(SplashActivity.class.getCanonicalName(), "is new day: " + !sameDay);
        preferencesManager.setLastRunDate(System.currentTimeMillis());

        return !sameDay;
    }

    private void getNewData(){
        getTodaysQuote();
    }

    private void getTodaysQuote(){
        new QuotesQueryTask(this).execute();
    }

}
