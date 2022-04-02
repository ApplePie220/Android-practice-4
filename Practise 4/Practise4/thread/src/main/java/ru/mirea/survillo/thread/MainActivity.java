package ru.mirea.survillo.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText lessonsCountInput;
    private EditText daysCountInput;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lessonsCountInput = (EditText) findViewById(R.id.lesson_count);
        daysCountInput = (EditText) findViewById(R.id.day_count);
        resultTextView = (TextView) findViewById(R.id.resultTextView);

        Button showResultsButton = (Button) findViewById(R.id.show_result);
        showResultsButton.setOnClickListener((view) -> {
            Thread thread = new Thread(() -> {
                double lessonsCount = Double.parseDouble(lessonsCountInput.getText().toString());
                double daysCount = Double.parseDouble(daysCountInput.getText().toString());
                double lessonsPerDay = lessonsCount / daysCount;
                runOnUiThread(() -> resultTextView.setText(String.valueOf(lessonsPerDay)));
            });
            thread.start();
        });
    }
}