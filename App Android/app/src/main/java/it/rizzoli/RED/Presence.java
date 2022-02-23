package it.rizzoli.RED;

public class Presence {
    String data;
    String nome_cognome;
    String presente;
    String assente;
    String ritardo;

    public Presence(String data, String nome_cognome, String presente, String assente, String ritardo) {
        this.data = data;
        this.nome_cognome = nome_cognome;
        this.presente = presente;
        this.assente = assente;
        this.ritardo = ritardo;
    }
}
