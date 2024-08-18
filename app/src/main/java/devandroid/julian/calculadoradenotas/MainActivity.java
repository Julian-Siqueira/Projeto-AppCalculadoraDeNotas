package devandroid.julian.calculadoradenotas;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText n1,n2,n3,n4,numeroFaltas;
    private Button btnCalcular;
    private TextView textViewAprovado, textViewMedia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        n1 = findViewById(R.id.edit_text_nota1);
        n2 = findViewById(R.id.edit_text_nota2);
        n3 = findViewById(R.id.edit_text_nota3);
        n4 = findViewById(R.id.edit_text_nota4);
        numeroFaltas = findViewById(R.id.edit_text_falta);

        textViewAprovado = findViewById(R.id.text_view_aprovacao);
        btnCalcular = findViewById(R.id.btn_calcular);
        btnCalcular.setOnClickListener(view -> {

            int nota1 = Integer.parseInt(n1.getText().toString());
            int nota2 = Integer.parseInt(n2.getText().toString());
            int nota3 = Integer.parseInt(n3.getText().toString());
            int nota4 = Integer.parseInt(n4.getText().toString());
            int numero_faltas = Integer.parseInt(numeroFaltas.getText().toString());

            int media = (nota1 + nota2 + nota3 + nota4) / 4;

            if(numero_faltas <= 20 && media >= 5){
                textViewAprovado.setText("Aluno foi Aprovado \nMédia final: "+media);
                textViewAprovado.setTextColor(getColor(R.color.green));
            } else if (numero_faltas > 20 ) {
                textViewAprovado.setText("Aluno foi Reprovado por Faltas \nMédia final: "+media);
                textViewAprovado.setTextColor(getColor(R.color.red));
            }else {
                textViewAprovado.setText("Aluno foi Reprovado por Nota \nMédia final: "+media);
                textViewAprovado.setTextColor(getColor(R.color.red));
            }


        });

    }

}