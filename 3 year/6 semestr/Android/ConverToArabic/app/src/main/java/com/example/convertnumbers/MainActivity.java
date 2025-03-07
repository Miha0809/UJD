package com.example.convertnumbers;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void onClickNumericButton(View view) {
        TextView textViewArabic = findViewById(R.id.ScreenArabic);
        String text = textViewArabic.getText().toString();

        if (view.getId() == R.id.btn_9) {
            text = text + "9";
        } else if (view.getId() == R.id.btn_8) {
            text = text + "8";
        } else if (view.getId() == R.id.btn_7) {
            text = text + "7";
        } else if (view.getId() == R.id.btn_6) {
            text = text + "6";
        } else if (view.getId() == R.id.btn_5) {
            text = text + "5";
        } else if (view.getId() == R.id.btn_4) {
            text = text + "4";
        } else if (view.getId() == R.id.btn_3) {
            text = text + "3";
        } else if (view.getId() == R.id.btn_2) {
            text = text + "2";
        } else if (view.getId() == R.id.btn_1) {
            text = text + "1";
        } else if (view.getId() == R.id.btn_0) {
            text = text + "0";
        } else if (view.getId() == R.id.btn_clear) {
            text = "";
        } else if (view.getId() == R.id.btn_ce && !text.isEmpty()) {
            text = text.substring(0, text.length() - 1);
        }

        textViewArabic.setText(text);
    }
}