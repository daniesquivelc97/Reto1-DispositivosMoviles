package com.example.reto1;

import android.content.Intent;
import android.os.Bundle;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final FloatingActionsMenu menuBotones = findViewById(R.id.grupoFab);

        final FloatingActionButton fab1 = findViewById(R.id.fab1);
        final FloatingActionButton fab2 = findViewById(R.id.fab2);
        final FloatingActionButton fab3 = findViewById(R.id.fab3);

        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Form.class);
                startActivityForResult(intent, 0);
            }
        });

        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Members.class);
                startActivityForResult(intent, 0);
            }
        });

        fab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), CalendarCalculate.class);
                startActivityForResult(intent, 0);
            }
        });
    }

}