package fr.tpillon.calculator_td2;

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

public class ComputeActivity extends AppCompatActivity {
    private TextView operationTextView;
    private int first = 0;
    private String operator = null;
    private int second = 0;

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

    private void writeNumber(Button b) {
        writeChar( b);

        CharSequence sequence = b.getText();
        String str = sequence.toString();
        int value = Integer.parseInt(str);

        if(this.operator == null){
            this.first = value;
        } else {
            this.second = value;
        }
    }

    private void writeOperator(Button b) {
        writeChar(b);

        this.operator = b.getText().toString();
    }

    /**
     * fonction appelée quand un bouton est cliqué
     * @param btn : le bouton sur lequel on vient de cliquer
     */
    private void writeChar(Button btn){
       String number =  btn.getText().toString();
       String ancien = this.operationTextView.getText().toString();

       String result = ancien + number;

       this.operationTextView.setText(result);
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
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }



}