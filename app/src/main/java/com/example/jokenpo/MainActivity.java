package com.example.jokenpo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionado_pedra(View view){
        this.opcao_selecionada("Pedra");
    }

    public void selecionado_papel(View view){
        this.opcao_selecionada("Papel");
    }
    public void selecionado_tesoura(View view){
        this.opcao_selecionada("Tesoura");
    }

    public void opcao_selecionada(String opcaoSelecionada){

        ImageView imageResultado = findViewById(R.id.imageResultado);
        TextView textResultado = findViewById(R.id.textresultado);

        int escolha_maquina = new Random().nextInt(3);
        String[] opcoes= {"pedra", "papel", "tespura"};
        String opcoes_maquina = opcoes[escolha_maquina];

        switch (opcoes_maquina) {
            case "pedra":
                imageResultado.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imageResultado.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imageResultado.setImageResource(R.drawable.tesoura);
                break;
        }


        if((opcoes_maquina == "tesoura" && opcaoSelecionada == "papel") ||
           (opcoes_maquina == "papel" && opcaoSelecionada == "pedra") ||
           (opcoes_maquina == "pedra" && opcaoSelecionada == "tesoura"))
        {
            textResultado.setText("A máquina Ganhou ! :(");
        }else if((opcoes_maquina == "tesoura" && opcaoSelecionada == "pedra") ||
                (opcoes_maquina == "papel" && opcaoSelecionada == "tesoura") ||
                (opcoes_maquina == "pedra" && opcaoSelecionada == "papel"))
        {
            textResultado.setText("Parabéns você Ganhou !!! :D");
        }else {
            textResultado.setText("Empate :|");
        }
    }
}