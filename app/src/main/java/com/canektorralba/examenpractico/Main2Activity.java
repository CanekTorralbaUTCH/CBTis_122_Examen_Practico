package com.canektorralba.examenpractico;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    TextView txvRUsuario, txvRContrasenia;
    Button btnValidar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txvRUsuario=(TextView)findViewById(R.id.ReciboUsuario);
        txvRContrasenia=(TextView)findViewById(R.id.ReciboContrasenia);
        btnValidar=(Button)findViewById(R.id.Validar);

        Intent iValidando =getIntent();
        Bundle extras = iValidando.getExtras();

        if (extras !=null){
            String UserV=(String)extras.get("VUser");
            String PasswordV=(String)extras.get("VPassword");

            txvRUsuario.setText(UserV);
            txvRContrasenia.setText(PasswordV);
        }

        btnValidar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txvRUsuario.getText().toString().equals("TORC011023HCHRZNA0") && txvRContrasenia.getText().toString().equals("0ANZRHCH320110CROT")){
                    Intent MUL =new Intent(getApplicationContext(), Multimedia.class);
                    startActivity(MUL);
                    overridePendingTransition(R.anim.slide_down, R.anim.slide_up);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Usuario y/o Contraseña invalidos", Toast.LENGTH_SHORT).show();
                    Intent volver =new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(volver);
                    finish();
                    overridePendingTransition(R.anim.slide_down, R.anim.slide_up);
                }
            }
        });

    }
}
