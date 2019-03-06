package com.example.elencoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private List<Persona> elenco;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        elenco = new ArrayList<>();
    }


    public void inserisciNome(View view) {

        // Prelevo il nome dalla casella di testo "input"
        String nome = ((EditText) findViewById(R.id.inputNome)).getText().toString();
        String cognome = ((EditText) findViewById(R.id.inputCognome)).getText().toString();
        String anno = ((EditText) findViewById(R.id.inputAnno)).getText().toString();

        // Controllo che le caselle di testo contengano dei valori
        if (nome.isEmpty() || cognome.isEmpty() || anno.isEmpty()) {
            return;
        }

        // Leggo l'anno inserito dalla casella degli anni
        int annoDiNascita;
        try {
            annoDiNascita = Integer.parseInt(anno);
        } catch (NumberFormatException e) {
            Toast.makeText(MainActivity.this, "Inserire un anno di nascita valido", Toast.LENGTH_SHORT).show();
            Log.e("NOMI", "Errore nell'interpretazione dell'anno di nascita");
            ((EditText) findViewById(R.id.inputAnno)).setTextColor(0xffff0000);
            return;
        }

        // Controllo la validità del numero inserito
        if (annoDiNascita <= 0 || annoDiNascita > 2019) {
            return;
        }



        // Aggiungo la persona all'elenco delle persone
        elenco.add(new Persona(nome, cognome, annoDiNascita));

        // Avverto l'utente dell'inserimento avvenuto
        Toast.makeText(MainActivity.this, "Inserito " + nome + " " + cognome, Toast.LENGTH_SHORT).show();

        // Pulisco le caselle di testo per un nuovo inserimento
        ((EditText) findViewById(R.id.inputNome)).setText("");
        ((EditText) findViewById(R.id.inputCognome)).setText("");
        ((EditText) findViewById(R.id.inputAnno)).setText("");
    }

    @Override
    protected void onPause() {
        super.onPause();

        // Metodo più intuitivo
        String res = "";
        for (Persona p : elenco) {
            res += p.getNome() + " " + p.getCognome() + " " + p.getAnnoDiNascita() + ", ";
        }
        
        Log.i("NOMI", res);

        // Metodo più efficiente
        StringBuilder sb = new StringBuilder();
        for (Persona p : elenco) {
            sb.append(p.getNome()).append(" ").append(p.getCognome()).append(" ").append(p.getAnnoDiNascita()).append(", ");
        }
        
        Log.i("NOMI", sb.toString());
    }
}
