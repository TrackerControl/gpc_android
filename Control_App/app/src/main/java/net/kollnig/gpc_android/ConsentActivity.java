package net.kollnig.gpc_android;

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

        final SharedPreferences prefs = getSharedPreferences("gpc_prefs", MODE_PRIVATE);
        boolean gpc = prefs.getBoolean("gpc", false);
        getIntent().putExtra("gpc", gpc);
        setResult(RESULT_OK, getIntent());
        finish();
    }
}