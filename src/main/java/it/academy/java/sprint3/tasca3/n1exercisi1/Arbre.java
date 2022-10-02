package it.academy.java.sprint3.tasca3.n1exercisi1;

public class Arbre {
    private String nom;
    private float alçada;
    private float preu;

    public Arbre() {
    }

    public Arbre(String nom, float alçada, float preu) {
        this.nom = nom;
        this.alçada = alçada;
        this.preu = preu;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getAlçada() {
        return alçada;
    }

    public void setAlçada(float alçada) {
        this.alçada = alçada;
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
                ", alçada=" + alçada +
                ", preu=" + preu +
                '}';
    }
}
