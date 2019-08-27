package com.example.calculadoraimc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private ViewHolder mViewHolder = new ViewHolder();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        this.mViewHolder.textResultado = findViewById(R.id.text_imc);
        this.mViewHolder.textAbaixo = findViewById(R.id.text_abaixo);
        this.mViewHolder.textNormal = findViewById(R.id.text_normal);
        this.mViewHolder.textSobrepeso = findViewById(R.id.text_sobrepeso);
        this.mViewHolder.textObesidade1 = findViewById(R.id.text_obesidade1);
        this.mViewHolder.textObesidade2 = findViewById(R.id.text_obesidade2);
        this.mViewHolder.textObesidade3 = findViewById(R.id.text_obesidade3);
        calculaIMC();
        diagnosticoIMC(calculaIMC());
    }

    private class ViewHolder{
        TextView textResultado;
        TextView textAbaixo;
        TextView textNormal;
        TextView textSobrepeso;
        TextView textObesidade1;
        TextView textObesidade2;
        TextView textObesidade3;

    }

    private Double calculaIMC(){
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        double altura = Double.parseDouble(extras.getString("EXTRA_ALTURA"));
        double peso = Double.parseDouble(extras.getString("EXTRA_PESO"));
        double imc = peso/(altura*altura);
        this.mViewHolder.textResultado.setText(String.format("%.1f", imc));
        return imc;
    }

    private void diagnosticoIMC(Double imc){
        if (imc < 18.5){
            this.mViewHolder.textAbaixo.setBackgroundResource(R.drawable.ret_resultado);
        }else if (imc >= 18.5 && imc < 24.9 ){
            this.mViewHolder.textNormal.setBackgroundResource(R.drawable.ret_resultado);
        }else if (imc >= 24.9 && imc < 29.9 ){
            this.mViewHolder.textSobrepeso.setBackgroundResource(R.drawable.ret_resultado);
        }else if (imc >= 29.9 && imc < 34.9 ){
            this.mViewHolder.textObesidade1.setBackgroundResource(R.drawable.ret_resultado);
        }else if (imc >= 34.9 && imc < 39.9 ){
            this.mViewHolder.textObesidade2.setBackgroundResource(R.drawable.ret_resultado);
        }else if (imc >= 40 ){
            this.mViewHolder.textObesidade3.setBackgroundResource(R.drawable.ret_resultado);
        }
    }
}
