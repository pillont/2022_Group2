package fr.tpillon.calculator_td2.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import fr.tpillon.calculator_td2.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button computeButton = findViewById(R.id.compute_button);
        Button previousButton = findViewById(R.id.result_previous_button);

        computeButton.setOnClickListener(view -> openComputeActivity());
        previousButton.setOnClickListener(view -> openPreviousActivity());
    }

    private void openPreviousActivity() {
        Intent intent = new Intent(this, ResultActivity.class);
        startActivity(intent);
    }

    private void openComputeActivity() {
        Intent intent = new Intent(this, ComputeActivity.class);
        startActivity(intent);
    }
}