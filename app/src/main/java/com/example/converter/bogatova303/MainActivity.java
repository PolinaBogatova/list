package com.example.converter.bogatova303;



import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;

import android.annotation.SuppressLint;
import android.view.View;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox[] chk = new CheckBox[4];  //чекбокс
    EditText[] num = new EditText[4];  //сумма
    EditText[] priceVal = new EditText[4];  //цена
    TextView value;
    RadioButton toast;
    RadioButton wind;

  //  @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chk[0] = findViewById(R.id.cBApple);
        chk[1] = findViewById(R.id.cBStrawberry);
        chk[2] = findViewById(R.id.cBBlueberry);
        chk[3] = findViewById(R.id.cBPotatoes);

        num[0] = findViewById(R.id.textA);
        num[1] = findViewById(R.id.textB);
        num[2] = findViewById(R.id.textC);
        num[3] = findViewById(R.id.textD);

        priceVal[0] = findViewById(R.id.texPriceA);
        priceVal[1] = findViewById(R.id.texPriceB);
        priceVal[2] = findViewById(R.id.texPriceC);
        priceVal[3] = findViewById(R.id.texPriceD);

        value = findViewById(R.id.textView);

        toast = findViewById(R.id.rBattonToast);
        wind = findViewById(R.id.rButtonWind);
    }

    public void clicks(View v)
    {
        double sum = 0, price = 0;
        int i, count;
        for(i = 0; i < 4; i++) {
            if (chk[i].isChecked()) {
                try {
                    price = Double.parseDouble(priceVal[i].getText().toString());
                    count = Integer.parseInt(num[i].getText().toString());
                }
                catch (Exception e) {
                    Toast toast = Toast.makeText(this, "Error!", Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }
                sum += price * count;
            }
        }
        if (wind.isChecked()) {
            AlertDialog.Builder bld = new AlertDialog.Builder(this);
            AlertDialog dlg = bld.create();
            dlg.setIcon(R.drawable.money);
            dlg.setTitle("Result:");
            dlg.setMessage( String.format("Result: %.2f", sum));
            dlg.show();
        }
        if(toast.isChecked()){
            Toast toast = Toast.makeText(this, String.format("Result: %.2f", sum), Toast.LENGTH_SHORT);
            toast.show();
        }

    }
}