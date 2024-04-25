package com.vitoroliveira.pedra_papel_tesoura;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

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
    }

    public void selectRock(View view) {
        verifyWinner("Pedra");
    }
    public void selectPaper(View view) {
        verifyWinner("Papel");
    }
    public void selectScissors(View view) {
        verifyWinner("Tesoura");
    }

    private String generateRandomChoiceApp() {
        String[] options = {"Pedra", "Papel", "Tesoura"};
        int randomNumber = new Random().nextInt(3);

        ImageView imageApp = findViewById(R.id.img_app);

        String choice = options[randomNumber];
        switch (choice) {
            case "Pedra":
                imageApp.setImageResource(R.drawable.pedra);
                break;
            case "Papel":
                imageApp.setImageResource(R.drawable.papel);
                break;
            case "Tesoura":
                imageApp.setImageResource(R.drawable.tesoura);
                break;
        }

        return choice;
    }

    private void verifyWinner(String userChoice) {
        String appChoice = generateRandomChoiceApp();

        TextView textResult = findViewById(R.id.text_resultado);

        if(
                (appChoice.equals("Pedra") && userChoice.equals("Tesoura")) ||
                        (appChoice.equals("Papel") && userChoice.equals("Pedra")) ||
                        (appChoice.equals("Tesoura") && userChoice.equals("Papel"))
        ) {
            textResult.setText("Você perdeu :(");
        } else if(
                (userChoice.equals("Pedra") && appChoice.equals("Tesoura")) ||
                        (userChoice.equals("Papel") && appChoice.equals("Pedra")) ||
                        (userChoice.equals("Tesoura") && appChoice.equals("Papel"))
        ) {
            textResult.setText("Você ganhou :)");
        } else {
            textResult.setText("Empatamos ;)");
        }
    }
}