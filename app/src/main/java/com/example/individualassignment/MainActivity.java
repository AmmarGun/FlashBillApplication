package com.example.individualassignment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btn;

    private EditText unitsEditText, rebateEditText;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btnabout);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, about.class);
                startActivity(intent);
            }
        });

        unitsEditText = findViewById(R.id.unitsEditText);
        rebateEditText = findViewById(R.id.rebateEditText);
        resultTextView = findViewById(R.id.resultTextView);

        Button buttonCalc = findViewById(R.id.buttonCalc);
        buttonCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (unitsEditText.length() == 0) {
                    unitsEditText.setError("Enter Value");
                } else if (rebateEditText.length() == 0) {
                    rebateEditText.setError("Enter Value of Percentage");
                } else {
                    calculateBill();
                    Toast.makeText(MainActivity.this, "Calculating Bill...", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void calculateBill() {
        double units = Double.parseDouble(unitsEditText.getText().toString());
        double rebatePercentage = Double.parseDouble(rebateEditText.getText().toString());

        double totalCharges = 0;

        if (units <= 200) {
            totalCharges = units * 0.218;
        } else if (units <= 300) {
            totalCharges = (200 * 0.218) + ((units - 200) * 0.334);
        } else if (units <= 600) {
            totalCharges = (200 * 0.218) + (100 * 0.334) + ((units - 300) * 0.516);
        } else if (units > 600) {
            totalCharges = (200 * 0.218) + (100 * 0.334) + (300 * 0.516) + ((units - 600) * 0.546);
        }

        double finalCost = totalCharges - (totalCharges * (rebatePercentage / 100));

        resultTextView.setText(String.format("Final Cost: RM %.2f", finalCost));
    }
}
