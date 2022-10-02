package it.academy.java.sprint3.tasca3.n1exercisi1;

public class Flor {
    private String nom;
    private String color;
    private float preu;

    public Flor() {
    }

    public Flor(String nom, String color, float preu) {
        this.nom = nom;
        this.color = color;
        this.preu = preu;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float getPreu() {
        return preu;
    }

    public void setPreu(float preu) {
        this.preu = preu;
    }

    @Override
    public String toString() {
        return "Flor{" +
                "nom='" + nom + '\'' +
                ", color='" + color + '\'' +
                ", preu=" + preu +
                '}';
    }
}
