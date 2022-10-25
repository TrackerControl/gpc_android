package net.kollnig.consent.gpc_android;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

public class ConsentActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        boolean consent = prefs.getBoolean("consent", false);
        getIntent().putExtra("consent", consent);
        setResult(RESULT_OK, getIntent());
        finish();
    }
}