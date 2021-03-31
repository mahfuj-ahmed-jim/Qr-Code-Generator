package com.example.qrcodegenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

public class GenerateAcitivity extends AppCompatActivity {

    EditText name,email,instituition,facebook;
    Button generate;
    ImageView qrCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_acitivity);

        name = findViewById(R.id.nameEditTextId);
        email = findViewById(R.id.emailEditTextId);
        instituition = findViewById(R.id.institutionEditTextId);
        facebook = findViewById(R.id.facebookEditTextId);
        generate = findViewById(R.id.generteButton);
        qrCode = findViewById(R.id.qrCodeId);

        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = name.getText().toString().trim()+" ;;;;; "+email.getText().toString().trim()+" ;;;;; "
                        +instituition.getText().toString().trim()+" ;;;;; "+facebook.getText().toString().trim();
                QRGEncoder qrgEncoder = new QRGEncoder(text,null, QRGContents.Type.TEXT,1000);
                Bitmap qrBitMap = qrgEncoder.getBitmap();
                qrCode.setImageBitmap(qrBitMap);
            }
        });

    }
}