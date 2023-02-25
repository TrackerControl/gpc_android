package net.kollnig.gpc_android.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import java.util.UUID;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_TEST = 10;
    private static final String EXTRA_REQUEST_CODE = "net.kollnig.gpc_android.test.REQUEST_CODE";

    String nonce = null;
    ActivityResultLauncher<Intent> launcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nonce = UUID.randomUUID().toString();
        launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        if (REQUEST_TEST != data.getIntExtra(EXTRA_REQUEST_CODE, 0))
                            return;

                        String nonce = data.getStringExtra("nonce");
                        if (!data.hasExtra("gpc")
                                || this.nonce == null
                                || !this.nonce.equals(nonce))
                            return;

                        boolean gpc = data.getBooleanExtra("gpc", false);
                        ((TextView) findViewById(R.id.lbl_hello)).setText(String.format("GPC: %s", gpc));
                    }
                }
        );

        Intent myIntent = new Intent();
        myIntent.setClassName("net.kollnig.gpc_android", "net.kollnig.gpc_android.ConsentActivity");
        myIntent.putExtra(EXTRA_REQUEST_CODE, REQUEST_TEST);
        myIntent.putExtra("nonce", nonce);
        launcher.launch(myIntent);
    }

}