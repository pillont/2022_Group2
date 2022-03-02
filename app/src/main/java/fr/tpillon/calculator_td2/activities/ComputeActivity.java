package fr.tpillon.calculator_td2.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import fr.tpillon.calculator_td2.R;

public class ComputeActivity extends AppCompatActivity {
    private TextView operationTextView;

    private int _first = 0;
    private String _operator =null;
    private int _second = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compute);

         operationTextView = findViewById(R.id.operation_text_view);

         // les boutons nombres
        ArrayList<Button> list = new ArrayList<Button>();
        list.add(findViewById(R.id.button1));
        list.add( findViewById(R.id.button2));
        list.add( findViewById(R.id.button3));
        list.add( findViewById(R.id.button4));
        list.add( findViewById(R.id.button5));
        list.add( findViewById(R.id.button6));
        list.add( findViewById(R.id.button7));
        list.add( findViewById(R.id.button8));
        list.add( findViewById(R.id.button9));
        list.add( findViewById(R.id.button0));

        // les boutons operator
        ArrayList<Button> operatorsList = new ArrayList<Button>();
        operatorsList.add(findViewById(R.id.buttonAdd));
        operatorsList.add( findViewById(R.id.buttonSubtract));
        operatorsList.add( findViewById(R.id.buttonMultiply));
        operatorsList.add( findViewById(R.id.buttonDivide));


        for (Button b : list) {
            b.setOnClickListener(view -> writeNumber(b));
        }


        for (Button b : operatorsList) {
            b.setOnClickListener(view ->writeOperator(b));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater =getMenuInflater();
        inflater.inflate(R.menu.submit_menu, menu);


        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id  = item.getItemId();

        switch (id) {
            case R.id.submit_menu_button:
                Intent intent = new Intent(this, ResultActivity.class);
                intent.putExtra(ResultActivity.FIRST_KEY, this.getFirst());
                intent.putExtra(ResultActivity.SECOND_KEY, this.getSecond());
                intent.putExtra(ResultActivity.OPERATOR_KEY, this.getOperator());

                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void writeNumber(Button b) {
        CharSequence sequence = b.getText();
        String str = sequence.toString();

        if(this.getOperator() == null){
            String resultAsString = Integer.toString(getFirst()) + str;
            int result = Integer.parseInt(resultAsString);
            this.setFirst(result);
        } else {
            String resultAsString = Integer.toString(getSecond()) + str;
            int result = Integer.parseInt(resultAsString);
            this.setSecond(result);
        }
    }

    private void writeOperator(Button b) {
        this.setOperator(b.getText().toString());
    }

    private void updateOperation() {
        // %1$d %2$s %3$d
        // first ope second
        // 1 + 2
        String text = getString(
            // le template
            R.string.operation_template,
            // les variables qui sont injectées
            getFirst(),
            getOperator(),
            getSecond()
        );

        this.operationTextView.setText(text);
    }


    private int getFirst() {
        return _first;
    }

    private void setFirst(int _first) {
        this._first = _first;
        this.updateOperation();
    }

    private int getSecond() {
        return _second;
    }

    private void setSecond(int _second) {
        this._second = _second;
        this.updateOperation();

    }

    private String getOperator() {
        return _operator;
    }

    private void setOperator(String operator) {
        if( operator != "+"
        &&  operator != "-"
        && operator != "*"
        &&  operator != "/") {
            throw new Error("operator invalid");
        }

        this._operator = operator;
        this.updateOperation();
    }
}