package it.rizzoli.RED;

public class VoteDocente {
    String data;
    String nome_cognome;
    String materia;
    int voto;

    public VoteDocente(String data, String nome_cognome, String materia, int voto) {
        this.data = data;
        this.nome_cognome = nome_cognome;
        this.materia = materia;
        this.voto = voto;
    }
}
