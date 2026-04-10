package com.example.foliadeiros.UI;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.foliadeiros.R;

public class LogIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_log_in);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button bt_nonCOnta= (Button) findViewById(R.id.bt_nonConta);
        Button bt_acceder= (Button) findViewById(R.id.bt_acceder);

        bt_nonCOnta.setOnClickListener(view -> {
            Intent i_noConta= new Intent(LogIn.this, Rexistro.class);
            startActivity(i_noConta);
            finish();
        });

        bt_acceder.setOnClickListener(view -> {
            Intent i_acceder= new Intent(LogIn.this, Provincias.class);
            startActivity(i_acceder);
            finish();
        });


    }
}