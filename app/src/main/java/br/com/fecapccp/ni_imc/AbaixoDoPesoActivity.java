package br.com.fecapccp.ni_imc;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AbaixoDoPesoActivity extends AppCompatActivity {

    private TextView textResultado;
    private Button btnFechar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_abaixo_do_peso);

        Log.i("Ciclo de Vida", "Tela AbaixoDoPeso: On Create");

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textResultado = findViewById(R.id.textResultado);
        btnFechar2 = findViewById(R.id.btnFechar2);

        // pegando os dados da tela de calculo do IMC
        Bundle bundle = getIntent().getExtras();

        double peso = bundle.getDouble("peso");
        double altura = bundle.getDouble("altura");
        double imc = bundle.getDouble("imc");

        // mostrando os dados e resultado na tela
        String msgResultado = "Seu peso: " + String.format("%.2f", peso) + " kg" +
                "\n" + "Sua altura: " + String.format("%.2f", altura) + " m" +
                "\n" + "Seu IMC: " + String.format("%.2f", imc) +
                "\n" + "Você está ABAIXO DO PESO. Cuide da alimentação!";

        textResultado.setText(msgResultado);

        //botão fechar redirecionando o usuario para a tela Main
        btnFechar2.setOnClickListener(view -> {
            Intent intentClose = new Intent(this, MainActivity.class);
            startActivity(intentClose);
        });
    }

    // ciclo de vida
    @Override
    protected void onResume(){
        super.onResume();
        Log.i("Ciclo de Vida", "Tela AbaixoDoPeso - onResume");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.i("Ciclo de Vida", "Tela AbaixoDoPeso - onPause");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i("Ciclo de Vida", "Tela AbaixoDoPeso - onDestroy");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i("Ciclo de Vida", "Tela AbaixoDoPeso - onStop");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.i("Ciclo de Vida", "Tela AbaixoDoPeso - onRestart");
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.i("Ciclo de Vida", "Tela AbaixoDoPeso - onStart");
    }
}