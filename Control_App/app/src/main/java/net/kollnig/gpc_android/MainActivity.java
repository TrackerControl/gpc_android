package net.kollnig.gpc_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SharedPreferences prefs = getSharedPreferences("gpc_prefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        Switch swControl = findViewById(R.id.swControl);

        boolean gpc = prefs.getBoolean("gpc", false);
        swControl.setChecked(gpc);

        swControl.setOnCheckedChangeListener((buttonView, isChecked) -> {
            editor.putBoolean("gpc", isChecked).apply();
        });
    }
}