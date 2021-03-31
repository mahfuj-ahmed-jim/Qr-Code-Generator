package com.example.qrcodegenerator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.google.zxing.Result;

import org.w3c.dom.Text;

public class ScanActivity extends AppCompatActivity {

    TextView name,email,institution,facebook;
    CodeScannerView codeScannerView;
    CodeScanner codeScanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);
        name = findViewById(R.id.nameTextId);
        email = findViewById(R.id.emailTextId);
        institution = findViewById(R.id.InstlTextId);
        facebook = findViewById(R.id.facebookTextId);
        codeScannerView = findViewById(R.id.scannerId);
        codeScanner = new CodeScanner(this,codeScannerView);
        codeScanner.isAutoFocusEnabled();

        codeScanner.setDecodeCallback(new DecodeCallback() {
            @Override
            public void onDecoded(@NonNull Result result) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String resulttext = result.getText();
                        String [] part = resulttext.split(" ;;;;; ");
                        name.setText(part[0]);
                        email.setText(part[1]);
                        institution.setText(part[2]);
                        facebook.setText(part[3]);
                    }
                });
            }
        });

        codeScannerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                codeScanner.startPreview();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        codeScanner.startPreview();
    }
}