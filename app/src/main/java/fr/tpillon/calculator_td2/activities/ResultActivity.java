package fr.tpillon.calculator_td2.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import fr.tpillon.calculator_td2.R;
import fr.tpillon.calculator_td2.models.OperationModel;
import fr.tpillon.calculator_td2.models.exceptions.DivideByZeroException;
import fr.tpillon.calculator_td2.models.exceptions.OperatorException;
import fr.tpillon.calculator_td2.services.OperationsService;

public class ResultActivity extends AppCompatActivity {
    public final static String FIRST_KEY = "FIRST";
    public final static String SECOND_KEY = "SECOND";
    public final static String OPERATOR_KEY= "OPERATOR";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView lastResultTV = findViewById(R.id.last_result_text_view);
        TextView divideByZeroTV = findViewById(R.id.divide_by_zero_text_view);
        TextView invalidOperatorTV = findViewById(R.id.invalid_operator_text_view);


        Intent intent = getIntent();
        int first = intent.getIntExtra(FIRST_KEY, 0);
        int second = intent.getIntExtra(SECOND_KEY, 0);
        String operator = intent.getStringExtra(OPERATOR_KEY);

        OperationsService calculator = new OperationsService();
        OperationModel operation = new OperationModel(first, second, operator);

        Button button = findViewById(R.id.result_previous_button);
        button.setOnClickListener(view -> goToPreviousActivity());

        try {
            double result = calculator.compute(operation);
            String text = getString(R.string.last_result_label, result);
            lastResultTV.setText(text);
            lastResultTV.setVisibility(View.VISIBLE);
        } catch (DivideByZeroException e) {
            divideByZeroTV.setVisibility(View.VISIBLE);
        } catch (OperatorException e) {
            invalidOperatorTV.setVisibility(View.VISIBLE);
        }
    }

    private void goToPreviousActivity() {
        finish();
    }
}