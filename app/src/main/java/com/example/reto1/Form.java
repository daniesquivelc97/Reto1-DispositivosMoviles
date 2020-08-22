package com.example.reto1;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class Form extends AppCompatActivity {

    private EditText inputNombre, inputApellido, inputTelefono;
    private TextInputLayout input_layout_nombre, input_layout_apellido, input_layout_telefono;
    private Button buttonEnviar;
    private TextView tituloFormulario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        tituloFormulario = findViewById(R.id.textTitle);
        tituloFormulario.setText(R.string.tituloFormulario);

        inputNombre = (EditText) findViewById(R.id.inputNombre);
        inputApellido = (EditText) findViewById(R.id.inputApellido);
        inputTelefono = (EditText) findViewById(R.id.inputTelefono);

        input_layout_nombre = (TextInputLayout) findViewById(R.id.input_layout_nombre);
        input_layout_apellido = (TextInputLayout) findViewById(R.id.input_layout_apellido);
        input_layout_telefono = (TextInputLayout) findViewById(R.id.input_layout_telefono);

        buttonEnviar = (Button) findViewById(R.id.buttonEnviar);

        buttonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateForm();
                clear();
            }
        });
    }

    private void validateForm() {
        if (!validateEditText(inputNombre, input_layout_nombre, R.string.err_msg_name)){
            return;
        }
        if (!validateEditText(inputApellido, input_layout_apellido, R.string.err_msg_name)){
            return;
        }
        if (!validateEditText(inputTelefono, input_layout_telefono, R.string.err_msg_name)){
            return;
        }
        Toast.makeText(getApplicationContext(), R.string.formSend, Toast.LENGTH_SHORT).show();
    }

    private boolean validateEditText(EditText editText, TextInputLayout textInputLayout, int errorString) {
        if (editText.getText().toString().trim().isEmpty()) {
            textInputLayout.setError(getString(R.string.errorString));
            return false;
        }
        else {
            textInputLayout.setErrorEnabled(false);
        }
        return true;
    }

    private void clear() {
        inputNombre.setText("");
        inputApellido.setText("");
        inputTelefono.setText("");
    }
}