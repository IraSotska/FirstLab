package com.example.svetlana.myapplication;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    final int MENU_RESET_ID=1;
    final int MENU_QUIT_ID=2;


    EditText etnum1;
    EditText etnum2;
    EditText etnum3;
    Button result;
    TextView resultoutput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etnum1=(EditText) findViewById(R.id.etnum1);
        etnum2=(EditText) findViewById(R.id.etnum2);
        etnum3=(EditText) findViewById(R.id.etnum3);

        result=(Button) findViewById(R.id.result);
        resultoutput=(TextView) findViewById(R.id.resultoutput);

        result.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        float num1=0;
        float num2=0;
        float num3=0;
        float res=0;

        num1=Float.parseFloat(etnum1.getText().toString());
        num2=Float.parseFloat(etnum2.getText().toString());
        num3=Float.parseFloat(etnum3.getText().toString());

        Toast toast = Toast.makeText(getApplicationContext(), "Numbers are the same.", Toast.LENGTH_SHORT);
        Toast toast2 = Toast.makeText(getApplicationContext(), "0 is unacceptable.", Toast.LENGTH_SHORT);
        Toast toast3 = Toast.makeText(getApplicationContext(), "2 numbers are the same/", Toast.LENGTH_SHORT);
        if((num1 == num2) &&(num2 == num3)) {
            toast.show();
        }
        if ((num1==0) || (num2==0) || (num3==0)) {
            toast2.show();
        }
        if ((num1==num2)||(num2==num3)||(num1==num3)){
            toast3.show();
        }

        if ((num1 > num3) && (num2 > num3)) {
            res = num1 * num2;
            resultoutput.setText("Result= " + res);
        }

        if ((num3 > num1) && (num2 > num1)) {
            res = num3 * num2;
            resultoutput.setText("Result= " + res);
        }

        if ((num1 > num2) && (num3 > num2)) {
            res = num1 * num3;
            resultoutput.setText("Result= " + res);
        }





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, MENU_RESET_ID,0, "Reset");
        menu.add(0, MENU_QUIT_ID,0, "Quit");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case MENU_RESET_ID:
                etnum1.setText("");
                etnum2.setText("");
                etnum3.setText("");
                result.setText("");
                break;
            case MENU_QUIT_ID:
                finish();
                break;}
        return super.onOptionsItemSelected(item);
    }


}
