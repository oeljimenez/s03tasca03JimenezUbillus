package it.academy.java.sprint3.tasca3.n1exercisi1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Exercisi1 {
    public static void main(String[] args) throws IOException {
        System.out.println("Tasca 03. Developers Team (Spring3), Nivell 1, Exercisi 1");

        Scanner sn = new Scanner(System.in);
        sn.useDelimiter("\n");
        boolean salir = false;
        int opcion; //save the user input

        Floristeria floristeria = new Floristeria();
        List<Arbre> arbres = new ArrayList<>();
        List<Flor> flors = new ArrayList<>();
        List<Decoracio> decoracions = new ArrayList<>();
        while (!salir) {
            System.out.println("1. Crear Floristeria");
            System.out.println("2. Afegir Arbre");
            System.out.println("3. Afegir Flor");
            System.out.println("4. Afegir Decoració");
            System.out.println("5. Stock: Imprimeix per pantalla tots els arbres, flors i decoració que té la floristeria");
            System.out.println("6. Retirar arbre");
            System.out.println("7. Retirar flor");
            System.out.println("8. Retirar decoració");
            System.out.println("9. Printar per pantalla stock amb quantitats");
            System.out.println("10. Printar per pantalla valor total de la floristeria");
            System.out.println("11. Crear tickets de compra amb múltiples objectes");
            System.out.println("12. Mostrar una llista de compres antigues");
            System.out.println("13. Visualitzar el total de diners guanyats amb totes les vendes");
            System.out.println("14. Sortir");

            try {
                System.out.println("Selecciona una opció");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("Introdueix el nom de la Floresteria que vols crear");
                        floristeria.setNom(sn.next());
                        break;
                    case 2:
                        Arbre arbre = new Arbre();
                        System.out.println("Introdueix el nom de l'arbre");
                        arbre.setNom(sn.next());
                        System.out.println("Introdueix l'alçada de l'arbre");
                        arbre.setAlçada(sn.nextFloat());
                        System.out.println("Introdueix el preu de l'arbre");
                        arbre.setPreu(sn.nextFloat());
                        arbres.add(arbre);
                        floristeria.setArbres(arbres);
                        break;
                    case 3:
                        Flor flor = new Flor();
                        System.out.println("Introdueix el nom de la flor");
                        flor.setNom(sn.next());
                        System.out.println("Introdueix el color de la flor");
                        flor.setColor(sn.next());
                        System.out.println("Introdueix el preu de la flor");
                        flor.setPreu(sn.nextFloat());
                        flors.add(flor);
                        floristeria.setFlors(flors);
                        break;
                    case 4:
                        Decoracio decoracio = new Decoracio();
                        System.out.println("Introdueix el nom de la decoració");
                        decoracio.setNom(sn.next());
                        System.out.println("Selecciona el tipus de material per a la decoració:\n 1.Fusta \n 2.Plàstic");
                        if (sn.nextInt() == 1) {
                            decoracio.setTipusMaterial(String.valueOf(TipusMaterial.fusta));
                        } else if (sn.nextInt() == 2) {
                            decoracio.setTipusMaterial(String.valueOf(TipusMaterial.plastic));
                        } else {
                            throw new IOException("This is not a valid selection");
                        }
                        System.out.println("Introdueix el preu de la decoracio");
                        decoracio.setPreu(sn.nextFloat());
                        decoracions.add(decoracio);
                        floristeria.setDecoracions(decoracions);
                        break;
                    case 5:
                        System.out.println("Stock");

                        break;
                    case 6:
                        System.out.println("Retirar arbre");

                        break;
                    case 7:
                        System.out.println("Retirar flor");

                        break;
                    case 8:
                        System.out.println("Retirar decoració");
                        break;
                    case 9:
                        System.out.println("Printar per pantalla stock amb quantitats");
                        break;
                    case 10:
                        System.out.println("Printar per pantalla valor total de la floristeria");
                        break;
                    case 11:
                        System.out.println("Crear tickets de compra amb múltiples objectes");
                        break;
                    case 12:
                        System.out.println("Mostrar una llista de compres antigues");
                        break;
                    case 13:
                        System.out.println("Visualitzar el total de diners guanyats amb totes les vendes");
                        break;
                    case 14:
                        salir = true;
                        break;
                    default:
                        System.out.println("No és una opció vàlida");
                }
            } catch (InputMismatchException e) {
                System.out.println("\n<<<::ERROR::>>>Introdueix un nombre vàlid");
                sn.next();
            }
        }
        setStockValue(floristeria);
        createStockFile(floristeria);
    }

    private static void setStockValue (Floristeria floristeria){
        //getting arbres values
        Double arbresValue = floristeria.getArbres().stream().mapToDouble(Arbre::getPreu).sum();

        //getting flors value
        Double florsValue = floristeria.getFlors().stream().mapToDouble(Flor::getPreu).sum();

        //getting decoracio value
        Double decoracionsValue = floristeria.getDecoracions().stream().mapToDouble(Decoracio::getPreu).sum();

        floristeria.setPreuTotalStock(arbresValue.floatValue()+florsValue.floatValue()+decoracionsValue.floatValue());

    }
    private static void createStockFile(Floristeria floristeria) throws IOException {
        BufferedWriter out = new BufferedWriter(new FileWriter("C:/Floristeria/stock.txt"));
        out.write(floristeria.toString());
        out.newLine();
        out.flush();
    }

}
