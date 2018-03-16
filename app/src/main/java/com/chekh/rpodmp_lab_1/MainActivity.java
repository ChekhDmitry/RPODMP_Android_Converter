package com.chekh.rpodmp_lab_1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private EditText dollarEditText;
    private TextView euroResultTextView;
    private TextView belRubleResultTextView;
    private TextView rusRubleResultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dollarEditText = findViewById(R.id.dollarEditText);
        euroResultTextView = findViewById(R.id.euroResultTextView);
        belRubleResultTextView = findViewById(R.id.belRubleResultTextView);
        rusRubleResultTextView = findViewById(R.id.rusRubleResultTextView);
    }

    public void onConvertBtnClick(View view){
        NumberFormat formatter = new DecimalFormat("#0.00");
        double dollarCount = 0.0;

        try{
            dollarCount = Double.parseDouble(String.valueOf(dollarEditText.getText()));
        }catch (Exception e){
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Warning!")
                    .setMessage("Invalid input data.")
                    .setCancelable(false)
                    .setNegativeButton("Try again",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });
            AlertDialog alert = builder.create();
            alert.show();
        }

        euroResultTextView.setText(String.valueOf(formatter.format(dollarCount * CurrencyRatio.USA_DOLLAR_TO_EURO.getValue())));
        belRubleResultTextView.setText(String.valueOf(formatter.format(dollarCount * CurrencyRatio.USA_DOLLAR_TO_BEL_RUBLE.getValue())));
        rusRubleResultTextView.setText(String.valueOf(formatter.format(dollarCount * CurrencyRatio.USA_DOLLAR_TO_RUS_RUBLE.getValue())));
        dollarEditText.setText(String.valueOf(dollarCount));
    }
}
