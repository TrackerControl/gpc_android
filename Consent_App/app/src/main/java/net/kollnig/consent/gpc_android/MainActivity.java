package net.kollnig.consent.gpc_android;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.CompoundButton;
import android.widget.Switch;

import java.util.UUID;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        Switch swConsent = findViewById(R.id.swConsent);

        boolean consent = prefs.getBoolean("consent", false);
        swConsent.setChecked(consent);

        swConsent.setOnCheckedChangeListener((buttonView, isChecked) -> {
            prefs.edit().putBoolean("consent", isChecked).apply();
        });
    }
}