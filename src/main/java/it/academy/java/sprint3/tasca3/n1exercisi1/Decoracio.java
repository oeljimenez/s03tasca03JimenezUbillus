package it.academy.java.sprint3.tasca3.n1exercisi1;

public class Decoracio {

    private String nom;
    private String tipusMaterial;
    private float preu;

    public Decoracio() {
    }

    public Decoracio(String nom, String tipusMaterial, float preu) {
        this.nom = nom;
        this.tipusMaterial = tipusMaterial;
        this.preu = preu;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTipusMaterial() {
        return tipusMaterial;
    }

    public void setTipusMaterial(String tipusMaterial) {
        this.tipusMaterial = tipusMaterial;
    }

    public float getPreu() {
        return preu;
    }

    public void setPreu(float preu) {
        this.preu = preu;
    }

    @Override
    public String toString() {
        return "Decoracio{" +
                "nom='" + nom + '\'' +
                ", tipusMaterial='" + tipusMaterial + '\'' +
                ", preu=" + preu +
                '}';
    }
}
