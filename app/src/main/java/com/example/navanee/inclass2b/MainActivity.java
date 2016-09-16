package com.example.navanee.inclass2b;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    RadioGroup rg = null;
    RadioButton rb = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rg = (RadioGroup) findViewById(R.id.rGrp);
        rb = (RadioButton) findViewById(R.id.rbSquare);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rb = (RadioButton)findViewById(checkedId);
            }
        });

        findViewById(R.id.calculate).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        EditText lEdit1 = (EditText) findViewById(R.id.length1);
        EditText lEdit2 = (EditText) findViewById(R.id.length2);
        TextView areaField = (TextView)findViewById(R.id.areaVal);
        int id = rg.getCheckedRadioButtonId();
        if(id == R.id.rbSquare){
            try{
                double area = Double.parseDouble(lEdit1.getText().toString()) * Double.parseDouble(lEdit1.getText().toString());
                areaField.setText(""+area);
                lEdit2.setText("");
            } catch (NumberFormatException e) {
                showToastMessage("Enter valid inputs");
            }
        } else if(id == R.id.rbCircle) {
            try{
                double area = 3.14 * Double.parseDouble(lEdit1.getText().toString()) * Double.parseDouble(lEdit1.getText().toString());
                areaField.setText(""+area);
                lEdit2.setText("");
            } catch (NumberFormatException e) {
                showToastMessage("Enter valid inputs");
            }
        } else if(id == R.id.rbRectangle) {
            try{
                double area = Double.parseDouble(lEdit1.getText().toString()) * Double.parseDouble(lEdit2.getText().toString());
                areaField.setText(""+area);
            } catch (NumberFormatException e) {
                showToastMessage("Enter valid inputs");
            }
        } else if(id == R.id.rbTriangle) {
            try{
                double area = 0.5 * Double.parseDouble(lEdit1.getText().toString()) * Double.parseDouble(lEdit2.getText().toString());
                areaField.setText(""+area);
            } catch (NumberFormatException e) {
                showToastMessage("Enter valid inputs");
            }
        } else  {
            lEdit1.setText("");
            lEdit2.setText("");
            areaField.setText("");
        }
    }

    public void showToastMessage(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }
}
