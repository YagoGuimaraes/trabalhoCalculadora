package br.edu.uniacademia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class DescontoSimples extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desconto_simples);


        Button calcular3 = findViewById(R.id.calcular3);
        calcular3.setOnClickListener(calcularJuros);

    }

    private View.OnClickListener calcularJuros = new View.OnClickListener(){
        @Override
        public void onClick (View v){

            Intent resultado = new Intent(DescontoSimples.this, Resultado.class);

            EditText capital = findViewById(R.id.cCapital2);
            Double valorCapital = Double.parseDouble(capital.getText().toString());
            EditText taxa = findViewById(R.id.tJuro2);
            Double valorTaxa = Double.parseDouble(taxa.getText().toString());


            if (!valorCapital.equals("") && !valorTaxa.equals("") ) {
                Double juros = valorCapital * (valorTaxa / 100);
                Double montante = valorCapital + juros;

                Bundle bundle = new Bundle();
                bundle.putDouble("juros", juros);
                bundle.putDouble("montante", montante);
                resultado.putExtras(bundle);
                startActivity(resultado);
                finish();
            }


        }


    };


}