package fr.tpillon.calculator_td2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        Button button = findViewById(R.id.result_previous_button);
        button.setOnClickListener(view -> goToPreviousActivity());
    }

    private void goToPreviousActivity() {
        finish();
    }
}