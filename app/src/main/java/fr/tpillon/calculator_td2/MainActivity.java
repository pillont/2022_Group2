package fr.tpillon.calculator_td2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button computeButton = findViewById(R.id.compute_button);
        Button previousButton = findViewById(R.id.previous_button);

        computeButton.setOnClickListener(view -> openComputeActivity());
        previousButton.setOnClickListener(view -> openPreviousActivity());
    }

    private void openPreviousActivity() {
    }

    private void openComputeActivity() {
    }
}