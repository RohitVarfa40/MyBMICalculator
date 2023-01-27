package com.example.test;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText edtWeight, edtHeightF, edtHeightI;
        Button btnCalculate;
        TextView txtResult;
        LinearLayout llMain;


        edtWeight=findViewById(R.id.edtWeight);
        edtHeightF=findViewById(R.id.edtHeightF);
        edtHeightI=findViewById(R.id.edtHeightI);
        btnCalculate=findViewById(R.id.btnCalculate);
        txtResult=findViewById(R.id.txtResult);
        llMain=findViewById(R.id.llMain);


        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               int wt= Integer.parseInt(edtWeight.getText().toString());
               int htf=Integer.parseInt(edtHeightF.getText().toString());
               int hti=Integer.parseInt(edtHeightI.getText().toString());


               int totalIn=htf*12+hti;
               double totalCm= totalIn*2.53;
               double totalM=totalCm/100;
               double bmi=wt/(totalM*totalM);

               if(bmi>25){
                  txtResult.setText("You are OverWeight");
                  llMain.setBackgroundColor(getResources().getColor(R.color.colorOwt));
               }else if(bmi<18){
                         txtResult.setText("You are UnderWeight");
                         llMain.setBackgroundColor(getResources().getColor(R.color.colorWt));
               }else{
                   txtResult.setText("You are Healthy");
                   llMain.setBackgroundColor(getResources().getColor(R.color.colorHealthy));
               }


            }
        });
    }
}