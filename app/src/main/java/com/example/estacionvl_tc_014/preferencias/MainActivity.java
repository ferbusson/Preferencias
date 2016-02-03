package com.example.estacionvl_tc_014.preferencias;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText txt;
    TextView saved;
    Button btn;

    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = (EditText) findViewById(R.id.txt);
        saved = (TextView) findViewById(R.id.saved);
        btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(this);

        preferences = getSharedPreferences("preference", MODE_PRIVATE);
        editor = preferences.edit();

        String datos = preferences.getString("datos","");
        saved.setText(datos);
    }

    @Override
    public void onClick(View v) {
        editor.putString("datos", txt.getText().toString());
        editor.commit();
    }
}
