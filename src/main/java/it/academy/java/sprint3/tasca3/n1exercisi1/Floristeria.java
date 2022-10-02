package it.academy.java.sprint3.tasca3.n1exercisi1;

import java.io.Serializable;
import java.util.List;

public class Floristeria implements Serializable {
    private String nom;
    private List<Arbre> arbres;
    private List<Flor> flors;
    private List<Decoracio> decoracions;
    private float preuTotalStock;

    public Floristeria() {
    }

    public Floristeria(String nom, List<Arbre> arbres, List<Flor> flors, List<Decoracio> decoracions, float preuTotalStock) {
        this.nom = nom;
        this.arbres = arbres;
        this.flors = flors;
        this.decoracions = decoracions;
        this.preuTotalStock = preuTotalStock;
    }

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

    public List<Decoracio> getDecoracions() {
        return decoracions;
    }

    public void setDecoracions(List<Decoracio> decoracions) {
        this.decoracions = decoracions;
    }

    public float getPreuTotalStock() {
        return preuTotalStock;
    }

    public void setPreuTotalStock(float preuTotalStock) {
        this.preuTotalStock = preuTotalStock;
    }

    @Override
    public String toString() {
        return "Floristeria{" +
                "nom='" + nom + '\'' +
                ", arbres=" + arbres +
                ", flors=" + flors +
                ", decoracions=" + decoracions +
                ", preuTotalStock=" + preuTotalStock +
                '}';
    }
}
