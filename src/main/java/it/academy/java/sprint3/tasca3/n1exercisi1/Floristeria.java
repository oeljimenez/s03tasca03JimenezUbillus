package it.academy.java.sprint3.tasca3.n1exercisi1;

import java.util.List;

public class Floristeria {
    private String nom;
    private List<Arbre> arbres;
    private List<Flor> flors;
    private Decoracio decoracio;
    private float preu;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Arbre> getArbres() {
        return arbres;
    }

    public void setArbres(List<Arbre> arbres) {
        this.arbres = arbres;
    }

    public List<Flor> getFlors() {
        return flors;
    }

    public void setFlors(List<Flor> flors) {
        this.flors = flors;
    }

    public Decoracio getDecoracio() {
        return decoracio;
    }

    public void setDecoracio(Decoracio decoracio) {
        this.decoracio = decoracio;
    }

    public float getPreu() {
        return preu;
    }

    public void setPreu(float preu) {
        this.preu = preu;
    }

    @Override
    public String toString() {
        return "Floristeria{" +
                "nom='" + nom + '\'' +
                ", arbres=" + arbres +
                ", flors=" + flors +
                ", decoracio=" + decoracio +
                ", preu=" + preu +
                '}';
    }
}
