package com.java.implicitintentdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeView();
        onClickListener();

    }

    private void onClickListener() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startNewApp("com.java.cryptographyapplication");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startNewAppParticularActivity("com.java.cryptographyapplication", "com.java.cryptographyapplication.MainActivity");
            }
        });
    }

    private void initializeView() {
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
    }

    /*
        start a new app & open a particular activity
     */
    private void startNewAppParticularActivity(String packageName, String packageWithActivityName) {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.setComponent(new ComponentName(packageName, packageWithActivityName));
        startActivity(intent);
    }

    /*
        start a new app
     */
    void startNewApp(String packageName) {
        Intent intent = getPackageManager().getLaunchIntentForPackage(packageName);
        if (intent != null) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }

    }

}


// --------------------------------------Another App Manifest file (Changes Required)--------------------------------



//    <?xml version="1.0" encoding="utf-8"?>
//<manifest xmlns:android="http://schemas.android.com/apk/res/android"
//        package="com.java.cryptographyapplication">
//
//<application
//        android:allowBackup="true"
//                android:icon="@mipmap/ic_launcher"
//                android:label="@string/app_name"
//                android:roundIcon="@mipmap/ic_launcher_round"
//                android:supportsRtl="true"
//                android:theme="@style/AppTheme">
//<activity android:name=".FirstActivity">
//<intent-filter>
//<action android:name="android.intent.action.MAIN" />
//
//<category android:name="android.intent.category.LAUNCHER" />
//</intent-filter>
//</activity>
//
//<activity android:name=".MainActivity"
//        android:exported="true"
//        >
//<intent-filter>
//<category android:name="android.intent.action.VIEW" />
//<category android:name="android.intent.category.DEFAULT" />
//<category android:name="android.intent.category.BROWSABLE" />
//</intent-filter>
//</activity>
//
//</application>
//
//</manifest>
