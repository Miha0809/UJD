package com.example.convertnumbers;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private TextView arabicText;
    private TextView romanText;

    private static final Pattern ROMAN_PATTERN = Pattern.compile(
            "^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arabicText = findViewById(R.id.ScreenArabic);
        romanText = findViewById(R.id.ScreenRoman);
    }

    public void onClickArabic(View view) {
        String current = romanText.getText().toString();
        int id = view.getId();

        if (id == R.id.btn_ce) {
            if (!current.isEmpty()) {
                current = current.substring(0, current.length() - 1);
            }
        } else {
            String symbol = ((TextView) view).getText().toString();
            String newRoman = current + symbol;

            if (!newRoman.isEmpty() && !ROMAN_PATTERN.matcher(newRoman).matches()) {
                Toast.makeText(this, "Błąd w rzymskim zapisie!", Toast.LENGTH_SHORT).show();
                return;
            }
            current = newRoman;
        }

        romanText.setText(current);

        if (!current.isEmpty()) {
            String result = ConvertNumeric.romanToArabic(current);
            arabicText.setText(result);
        } else {
            arabicText.setText("");
        }
    }

    public void onClickRoman(View view) {
        String current = arabicText.getText().toString();
        int id = view.getId();

        if (id == R.id.btn_clear) {
            current = "";
        } else if (id == R.id.btn_clear) {
            if (!current.isEmpty()) {
                current = current.substring(0, current.length() - 1);
            }
        } else {
            String digit = ((TextView) view).getText().toString();
            current += digit;
        }
        arabicText.setText(current);

        if (!current.isEmpty()) {
            try {
                int number = Integer.parseInt(current);
                String roman = ConvertNumeric.arabicToRoman(number);
                romanText.setText(roman);
            } catch (NumberFormatException e) {
                romanText.setText("Error");
            }
        } else {
            romanText.setText("");
        }
    }
}