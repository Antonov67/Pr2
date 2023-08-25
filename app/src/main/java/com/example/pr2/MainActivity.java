package com.example.pr2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView title;
    EditText numA, numB;
    Button button;
    Spinner spinner;
    String operand = "+";
    double a, b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = findViewById(R.id.title_text);
        numA = findViewById(R.id.number_a);
        numB = findViewById(R.id.number_b);
        button = findViewById(R.id.button);
        spinner = findViewById(R.id.spinner);

        //заполним спиннер значениями
        String[] operands = {"+", "-", "*", "/"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.spinner_item, operands);
        adapter.setDropDownViewResource(R.layout.spinner_item);
        spinner.setAdapter(adapter);

        //выбор элемента спиннера
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                operand = operands[i];
                //   operand = (String) adapterView.getItemAtPosition(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //вычисление результата и вывод его на экран
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    a = Double.parseDouble(numA.getText().toString());
                    b = Double.parseDouble(numB.getText().toString());
                    //само вычисление
                    if (operand.equals("+")){
                        Toast.makeText(MainActivity.this, "a+b=" + (a + b), Toast.LENGTH_LONG).show();
                        title.setText("операция сложения выполнена");
                    }

                    if (operand.equals("-")){
                        Toast.makeText(MainActivity.this, "a-b=" + (a - b), Toast.LENGTH_LONG).show();
                        title.setText("операция вычитания выполнена");
                    }

                    if (operand.equals("*")){
                        Toast.makeText(MainActivity.this, "a*b=" + (a * b), Toast.LENGTH_LONG).show();
                        title.setText("операция умножения выполнена");
                    }

                    if (operand.equals("/")){
                        if (b != 0){
                            Toast.makeText(MainActivity.this, "a/b=" + (a / b), Toast.LENGTH_LONG).show();
                            title.setText("операция деления выполнена");
                        }else {
                            Toast.makeText(MainActivity.this, "Деление на 0!", Toast.LENGTH_LONG).show();
                        }
                    }

                }catch (Exception e){
                    Toast.makeText(MainActivity.this, "Не удалось вычислить", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("it_region", "start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("it_region", "resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("it_region", "pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("it_region", "stop");
    }
}