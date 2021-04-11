package com.canektorralba.examenpractico;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edtUsuario, edtContraseña;
    Button btnAcceder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtUsuario=(EditText)findViewById(R.id.Usuario);
        edtContraseña=(EditText)findViewById(R.id.Contrasenia);
        btnAcceder=(Button)findViewById(R.id.Acceder);
        //boton acceder
        btnAcceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iValidar =new Intent(getApplicationContext(), Main2Activity.class);
                String strUser =edtUsuario.getText().toString();
                String strPassword =edtContraseña.getText().toString();
                iValidar.putExtra("VUser",strUser);
                iValidar.putExtra("VPassword", strPassword);
                startActivity(iValidar);
                overridePendingTransition(R.anim.slide_down, R.anim.slide_up);
            }
        });
    }
}
