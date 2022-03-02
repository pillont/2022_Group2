package fr.tpillon.calculator_td2.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

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

        Intent intent = getIntent();
        int first = intent.getIntExtra(FIRST_KEY, 0);
        int second = intent.getIntExtra(SECOND_KEY, 0);
        String operator = intent.getStringExtra(OPERATOR_KEY);

        OperationsService calculator = new OperationsService();
        OperationModel operation = new OperationModel(first, second, operator);

        try {
            double result = calculator.compute(operation);
            // TODO afficher le resultat à l ecran
        } catch (DivideByZeroException e) {
            // TODO : informer l utilisateur
        } catch (OperatorException e) {
            // TODO : informer l utilisateur
        }

        Button button = findViewById(R.id.result_previous_button);
        button.setOnClickListener(view -> goToPreviousActivity());
    }

    private void goToPreviousActivity() {
        finish();
    }
}