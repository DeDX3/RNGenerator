package com.example.rngenerator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView tvResult;
    EditText etMin, etMax;
    Button btnGen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = findViewById(R.id.tvResult);
        etMin = findViewById(R.id.etMin);
        etMax = findViewById(R.id.etMax);
        btnGen = findViewById(R.id.btnGen);

        btnGen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strNumMin = etMin.getText().toString();
                String strNumMax = etMax.getText().toString();
                int nMin = 0, nMax = 0;

                if((strNumMin.isEmpty()) || (strNumMax.isEmpty())){
                    etMin.requestFocus();
                    etMin.setError("Cannot be empty!");
                    etMax.setError("Cannot be empty!");
                }
                else{
                    nMin = Integer.parseInt(strNumMin);
                    nMax = Integer.parseInt(strNumMax);
                }

                if(nMin > nMax){
                    etMin.requestFocus();
                    etMin.setError("Enter value less than "+strNumMax);
                }
                else{
                    Random random = new Random();
                    int randomNumber = random.nextInt(nMax + 1 - nMin) + nMin;
                    String result = String.valueOf(randomNumber);
                    tvResult.setText(result);
                }
            }
        });
    }
}
