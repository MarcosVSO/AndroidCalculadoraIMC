package com.example.calculadoraimc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{

    private ViewHolder mViewHolder = new ViewHolder();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.editPeso = findViewById(R.id.edit_peso);
        this.mViewHolder.editAltura = findViewById(R.id.edit_altura);
        this.mViewHolder.btnCalcular = findViewById(R.id.button_calculate);

        this.mViewHolder.btnCalcular.setOnClickListener(this);
        this.clearEditTexts();



    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button_calculate){
            String altura = this.mViewHolder.editAltura.getText().toString();
            String peso = this.mViewHolder.editPeso.getText().toString();
            Bundle extras = new Bundle();
            extras.putString("EXTRA_ALTURA",altura);
            extras.putString("EXTRA_PESO",peso);
            Intent intent =  new Intent(this, ResultActivity.class);
            intent.putExtras(extras);
            startActivity(intent);
        }
    }

    private class ViewHolder{
        EditText editPeso;
        EditText editAltura;
        Button btnCalcular;
    }

    private void clearEditTexts(){
        this.mViewHolder.editPeso.setText("");
        this.mViewHolder.editAltura.setText("");
    }
}
