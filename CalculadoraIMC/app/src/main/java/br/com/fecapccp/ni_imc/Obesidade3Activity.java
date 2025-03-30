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

public class Obesidade3Activity extends AppCompatActivity {

    private TextView textResultado;
    private Button btnFechar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_obesidade3);

        Log.i("Ciclo de Vida", "Tela Obesidade3: On Create");

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textResultado = findViewById(R.id.textResultado);
        btnFechar2 = findViewById(R.id.btnFechar2);

        //coletando os dados
        Bundle bundle = getIntent().getExtras();

        double peso = bundle.getDouble("peso");
        double altura = bundle.getDouble("altura");
        double imc = bundle.getDouble("imc");

        //mostrando os dados e resultado
        String msgResultado = "Seu peso: " + String.format("%.2f", peso) + " kg" +
                "\n" + "Sua altura: " + String.format("%.2f", altura) + " m" +
                "\n" + "Seu IMC: " + String.format("%.2f", imc) +
                "\n" + "Você está com OBESIDADE GRAU 3. Procure cuidar da saúde!";

        textResultado.setText(msgResultado);

        btnFechar2.setOnClickListener(view -> {
            Intent intentClose = new Intent(this, MainActivity.class);
            startActivity(intentClose);
        });
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.i("Ciclo de Vida", "Tela Obesidade3 - onResume");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.i("Ciclo de Vida", "Tela Obesidade3 - onPause");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i("Ciclo de Vida", "Tela Obesidade3 - onDestroy");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i("Ciclo de Vida", "Tela Obesidade3 - onStop");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.i("Ciclo de Vida", "Tela Obesidade3 - onRestart");
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.i("Ciclo de Vida", "Tela Obesidade3 - onStart");
    }
}