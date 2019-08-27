package com.example.calculadoraimc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private ViewHolder mViewHolder = new ViewHolder();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.editPeso = findViewById(R.id.edit_peso);
        this.mViewHolder.editAltura = findViewById(R.id.edit_altura);
        this.mViewHolder.btnCalcular = findViewById(R.id.button_calculate);
    }

    private class ViewHolder{
        EditText editPeso;
        EditText editAltura;
        Button btnCalcular;
    }
}
