package net.kollnig.gpc_android.test;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.UUID;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_TEST = 10;

    String nonce = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nonce = UUID.randomUUID().toString();
        Intent myIntent = new Intent();
        myIntent.setClassName("net.kollnig.gpc_android", "net.kollnig.gpc_android.ConsentActivity");
        myIntent.putExtra("nonce", nonce);
        startActivityForResult(myIntent, REQUEST_TEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_TEST) {
            if(resultCode == Activity.RESULT_OK) {
                String nonce = data.getStringExtra("nonce");

                if (data.hasExtra("gpc") && this.nonce != null && this.nonce.equals(nonce)) {
                    boolean gpc = data.getBooleanExtra("gpc", false);
                    ((TextView) findViewById(R.id.lbl_hello)).setText(String.format("GPC: %s", gpc));
                }
            }
        }
    }
}