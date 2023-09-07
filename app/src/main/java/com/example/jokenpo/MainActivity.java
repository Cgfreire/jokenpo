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
        this.opcao_selecionada("pedra");
    }
    public void selecionado_papel(View view){
        this.opcao_selecionada("papel");
    }
    public void selecionado_tesoura(View view){
        this.opcao_selecionada("tesoura");
    }

    public void opcao_selecionada(String opcaoSelecionada){

        ImageView imageResultadoMaquina = findViewById(R.id.JogadaM);
        ImageView imageResultadoPlayer = findViewById(R.id.JogadaP);
        TextView textResultado = findViewById(R.id.textResultado);

        int escolha_maquina = new Random().nextInt(3);
        String[] opcoes= {"pedra", "papel", "tespura"};
        String opcoes_maquina = opcoes[escolha_maquina];

        switch (opcoes_maquina) {
            case "pedra":
                imageResultadoMaquina.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imageResultadoMaquina.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imageResultadoMaquina.setImageResource(R.drawable.tesoura);
                break;
        }


        switch (opcaoSelecionada) {
            case "pedra":
                imageResultadoPlayer.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imageResultadoPlayer.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imageResultadoPlayer.setImageResource(R.drawable.tesoura);
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