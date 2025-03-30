package br.com.fecapccp.ni_imc;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CalculoIMCActivity extends AppCompatActivity {

    private EditText TextPeso;
    private EditText TextAltura;
    private Button btnCalculoIMC;
    private Button btnFechar;
    private Button btnLimpar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        Log.i("Ciclo de Vida", "Tela 2: On Create");

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextPeso = findViewById(R.id.TextPeso);
        TextAltura = findViewById(R.id.TextAltura);
        btnCalculoIMC = findViewById(R.id.btnCalculoIMC);
        btnLimpar = findViewById(R.id.btnlimpar);
        btnFechar = findViewById(R.id.btnFechar);

        // calculando o imc:
        btnCalculoIMC.setOnClickListener(view -> calcularIMC());
        // limpa os campos:
        btnLimpar.setOnClickListener(this::limpar);
        // aciona o botão para fechar para a tela Main
        btnFechar.setOnClickListener(view -> {
            Intent intentClose = new Intent(this, MainActivity.class);
            startActivity(intentClose);
        });
    }

    // metodo para calcular IMC
    private void calcularIMC() {
        String StringPeso = TextPeso.getText().toString().trim();
        String StringAltura = TextAltura.getText().toString().trim();

        // verificando se os campos estão vazios
        if (StringPeso.isEmpty() || StringAltura.isEmpty()) {
            Toast.makeText(this, "Por favor, preencha peso e altura.", Toast.LENGTH_SHORT).show();
            return; // não continua se os campos estiverem vazios
        }

        try {
            // tenta converter a entrada para números
            double peso = Double.parseDouble(StringPeso);
            double altura = Double.parseDouble(StringAltura);

            // verifica se os números são válidos
            if (peso <= 0 || altura <= 0) {
                Toast.makeText(this, "Por favor, insira valores positivos para peso e altura.", Toast.LENGTH_SHORT).show();
                return;
            }

            double imc = peso / (altura * altura);

            Class<?> activityFeedback;

            // definindo a proxima tela com base no resultado do IMC
            if (imc < 18.5) activityFeedback = AbaixoDoPesoActivity.class;
            else if (imc >= 18.5 && imc < 25) activityFeedback = PesoNormalActivity.class;
            else if (imc >= 25 && imc < 30) activityFeedback = SobrepesoActivity.class;
            else if (imc >= 30 && imc < 35) activityFeedback = Obesidade1Activity.class;
            else if (imc >= 35 && imc < 40) activityFeedback = Obesidade2Activity.class;
            else activityFeedback = Obesidade3Activity.class;

            // envia os dados
            Intent intent = new Intent(this, activityFeedback);
            Bundle bundle = new Bundle();
            bundle.putDouble("peso", peso);
            bundle.putDouble("altura", altura);
            bundle.putDouble("imc", imc);
            intent.putExtras(bundle);
            startActivity(intent);
        } catch (NumberFormatException e) {
            // fala para o usuário sobre a entrada inválida (não numérica)
            Toast.makeText(this, "Por favor, insira números válidos para peso e altura.", Toast.LENGTH_SHORT).show();
        }
    }

    // limpa os campos
    public void limpar(View view){
        TextPeso.setText("");
        TextAltura.setText("");
    }

    // ciclo de vida
    @Override
    protected void onResume(){
        super.onResume();
        Log.i("Ciclo de Vida", "Tela 2 - onResume");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.i("Ciclo de Vida", "Tela 2 - onPause");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i("Ciclo de Vida", "Tela 2 - onDestroy");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i("Ciclo de Vida", "Tela 2 - onStop");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.i("Ciclo de Vida", "Tela 2 - onRestart");
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.i("Ciclo de Vida", "Tela 2 - onStart");
    }
}