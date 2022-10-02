package it.academy.java.sprint3.tasca3.n1exercisi1;

import java.io.Serializable;

public class Arbre implements Serializable {
    private String nom;
    private float alcada;
    private float preu;

    public Arbre() {
    }

    public Arbre(String nom, float alcada, float preu) {
        this.nom = nom;
        this.alcada = alcada;
        this.preu = preu;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getAlcada() {
        return alcada;
    }

    public void setAlcada(float alcada) {
        this.alcada = alcada;
    }

    public float getPreu() {
        return preu;
    }

    public void setPreu(float preu) {
        this.preu = preu;
    }

    @Override
    public String toString() {
        return "Arbre{" +
                "nom='" + nom + '\'' +
                ", alcada=" + alcada +
                ", preu=" + preu +
                '}';
    }
}
