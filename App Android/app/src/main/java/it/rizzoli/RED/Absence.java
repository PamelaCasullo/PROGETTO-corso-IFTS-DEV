package it.rizzoli.RED;

public class Absence {
    String data;
    String nome_cognome;
    String presente;
    String assente;
    String ritardo;

    public Absence(String data, String nome_cognome, String presente, String assente, String ritardo) {
        this.data = data;
        this.nome_cognome = nome_cognome;
        this.presente = presente;
        this.assente = assente;
        this.ritardo = ritardo;
    }
}
