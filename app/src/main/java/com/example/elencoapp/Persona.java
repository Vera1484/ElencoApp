package com.example.elencoapp;

public class Persona implements Comparable<Persona>{

    private String nome;
    private String cognome;
    private int annoDiNascita;

    public Persona(String nome, String cognome, int annoDiNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.annoDiNascita = annoDiNascita;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public int getAnnoDiNascita() {
        return annoDiNascita;
    }

    @Override
    public int compareTo(Persona o) {
        return this.nome.compareTo(o.nome);
    }
}
