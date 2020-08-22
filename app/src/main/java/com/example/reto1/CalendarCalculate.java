package com.example.reto1;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;


public class CalendarCalculate extends AppCompatActivity {

    private Button btnSelectDate;
    private TextView txtDate;
    private Calendar calendar;
    private DatePickerDialog datePickerDialog;
    private Button btnCalculateAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        initComponents();

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    public void initComponents(){
        btnSelectDate = findViewById(R.id.btnSelectDate);
        txtDate = findViewById(R.id.txtDate);
        btnCalculateAge=findViewById(R.id.btnCalculateAge);
    }

    public void selectDate(View view) {
        btnSelectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar = Calendar.getInstance();
                int birthDay = calendar.get(Calendar.DAY_OF_MONTH);
                int birthMonth = calendar.get(Calendar.MONTH);
                int birthYear = calendar.get(Calendar.YEAR);

                datePickerDialog = new DatePickerDialog(CalendarCalculate.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        txtDate.setText(dayOfMonth + "-" + (month+1) +"-" + year);
                    }
                }, birthYear, birthMonth, birthDay);
                datePickerDialog.getDatePicker().setMaxDate(calendar.getTimeInMillis());
                datePickerDialog.show();
            }
        });
    }

    public void calculateAge(View view) {

        btnCalculateAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar = Calendar.getInstance();
                int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
                int currentMonth = calendar.get(Calendar.MONTH);
                int currentYear = calendar.get(Calendar.YEAR);

                if(txtDate.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), R.string.textoToast, Toast.LENGTH_SHORT).show();
                }else{
                    String birthDate = txtDate.getText().toString();
                    String[] birthDateArray = birthDate.split("-");

                    int age = currentYear - Integer.parseInt(birthDateArray[2]);

                    if(Integer.parseInt(birthDateArray[1]) < currentMonth){
                        age--;
                    }
                    if(Integer.parseInt(birthDateArray[0]) < currentDay){
                        age++;
                    }

                    Toast.makeText(getApplicationContext(), "Su edad es: " + age + " años", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }


}