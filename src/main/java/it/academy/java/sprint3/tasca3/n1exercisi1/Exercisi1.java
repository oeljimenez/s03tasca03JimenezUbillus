package it.academy.java.sprint3.tasca3.n1exercisi1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercisi1 {
    public static void main(String[] args) {
        System.out.println("Tasca 03. Developers Team (Spring3), Nivell 1, Exercisi 1");

        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //save the user input

        while(!salir) {
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
                        Floristeria floristeria = new Floristeria();
                        floristeria.setNom(sn.next());

                        break;
                    case 2:
                        System.out.println("Introdueix l'alçada de l'arbre");
                        String nom = sn.next();

                        System.out.println("Introdueix el preu de l'arbre");
                        break;
                    case 3:

                        System.out.println("Introdueix el color de la Flor");


                        salir = true;

                        break;
                    case 4:
                        System.out.println("Introdueix el tipus de material de la decoració (fusta o plastic)");
                        String  nomRedactor= sn.next();


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
                System.out.println("Introdueix un nombre vàlid");
                sn.next();
            }
        }
    }

}
