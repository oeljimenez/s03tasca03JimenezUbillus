package it.academy.java.sprint3.tasca3.n1exercisi1;

import java.io.*;
import java.util.*;

public class Exercisi1 {
    public static void main(String[] args) throws IOException {
        System.out.println("Tasca 03. Developers Team (Spring3), Nivell 1, Exercisi 1");

        Scanner sn = new Scanner(System.in);
        sn.useDelimiter("\n");
        boolean sortir = false;
        int opcion; //save the user input

        Floristeria floristeria = new Floristeria();
        List<Arbre> arbres = new ArrayList<>();
        List<Flor> flors = new ArrayList<>();
        List<Decoracio> decoracions = new ArrayList<>();
        Ticket ticket = new Ticket();
        List<Object> items = new ArrayList<>();
        while (!sortir) {
            System.out.println("\n\n1. Crear Floristeria");
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
                        arbreInsertion(arbres, floristeria, sn);
                        break;
                    case 3:
                        florInsertion(flors, floristeria, sn);
                        break;
                    case 4:
                        decoracioInsertion(decoracions, floristeria, sn);
                        break;
                    case 5:
                        printStock(floristeria);
                        break;
                    case 6:
                        System.out.println("Introdueix el nom de l'arbre que vols retirar");
                        floristeria.getArbres().removeIf(x -> x.getNom().equalsIgnoreCase(sn.next()));
                    case 7:
                        System.out.println("Introdueix el nom de la flor que vols retirar");
                        floristeria.getFlors().removeIf(x -> x.getNom().equalsIgnoreCase(sn.next()));
                        break;
                    case 8:
                        System.out.println("Introdueix el nom de la decoracióque vols retirar");
                        floristeria.getDecoracions().removeIf(x -> x.getNom().equalsIgnoreCase(sn.next()));
                        break;
                    case 9:
                        printStockQuantities(floristeria);
                        break;
                    case 10:
                        System.out.println("Printar per pantalla valor total de la floristeria");
                        setStockValue(floristeria);
                        System.out.println(floristeria.getPreuTotalStock());
                        break;
                    case 11:
                        ticketCreation(floristeria, ticket, items, sn);
                        break;
                    case 12:
                        getOldersOrders();
                        break;
                    case 13:
                        System.out.println("Visualitzar el total de diners guanyats amb totes les vendes");
                        amountTotalOrders(items);
                        break;
                    case 14:
                        sortir = true;
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
        createStockFile(floristeria, ticket);
    }

    private static void arbreInsertion(List<Arbre> arbres, Floristeria floristeria, Scanner sn) {
        Arbre arbre = new Arbre();
        System.out.println("Introdueix el nom de l'arbre");
        arbre.setNom(sn.next());
        System.out.println("Introdueix l'alçada de l'arbre");
        arbre.setAlcada(sn.nextFloat());
        System.out.println("Introdueix el preu de l'arbre");
        arbre.setPreu(sn.nextFloat());
        arbres.add(arbre);
        floristeria.setArbres(arbres);
    }

    private static void florInsertion(List<Flor> flors, Floristeria floristeria, Scanner sn) {
        Flor flor = new Flor();
        System.out.println("Introdueix el nom de la flor");
        flor.setNom(sn.next());
        System.out.println("Introdueix el color de la flor");
        flor.setColor(sn.next());
        System.out.println("Introdueix el preu de la flor");
        flor.setPreu(sn.nextFloat());
        flors.add(flor);
        floristeria.setFlors(flors);
    }

    private static void decoracioInsertion(List<Decoracio> decoracions, Floristeria floristeria, Scanner sn) {
        Decoracio decoracio = new Decoracio();
        System.out.println("Introdueix el nom de la decoració");
        decoracio.setNom(sn.next());

        Boolean exit = false;
        while (!exit) {
            System.out.println("Selecciona el tipus de material per a la decoració:\n 1.Fusta \n 2.Plàstic");
            try {
                int selectedOption = sn.nextInt();
                switch (selectedOption) {
                    case 1:
                        decoracio.setTipusMaterial(String.valueOf(TipusMaterial.fusta));
                        exit = true;
                        break;
                    case 2:
                        decoracio.setTipusMaterial(String.valueOf(TipusMaterial.plastic));
                        exit = true;
                        break;
                    default:
                        System.out.println("No és una opció vàlida");
                }

            } catch (InputMismatchException e) {
                System.out.println("Introdueix un nombre vàlid");
                sn.next();
            }
        }

        System.out.println("Introdueix el preu de la decoracio");
        decoracio.setPreu(sn.nextFloat());
        decoracions.add(decoracio);
        floristeria.setDecoracions(decoracions);
    }

    private static void printStock(Floristeria floristeria) {
        if (floristeria.getArbres() != null) {
            System.out.println("Arbres:");
            floristeria.getArbres().forEach(System.out::println);
        }

        if (floristeria.getFlors() != null) {
            System.out.println("Flors:");
            floristeria.getFlors().forEach(System.out::println);
        }

        if (floristeria.getDecoracions() != null) {
            System.out.println("Decoracions:");
            floristeria.getDecoracions().forEach(System.out::println);
        }
    }

    private static void printStockQuantities(Floristeria floristeria) {
        if (floristeria.getArbres() != null) {
            System.out.println("Arbres -->" + floristeria.getArbres().size());
        }
        if (floristeria.getFlors() != null) {
            System.out.println("Flors -->" + floristeria.getFlors().size());
        }
        if (floristeria.getDecoracions() != null) {
            System.out.println("Decoracions -->" + floristeria.getDecoracions().size());
        }
    }

    private static void setStockValue(Floristeria floristeria) {
        Double arbresValue = 0.0;
        Double florsValue = 0.0;
        Double decoracionsValue = 0.0;

        //getting arbres values
        if (floristeria.getArbres() != null) {
            arbresValue = floristeria.getArbres().stream().mapToDouble(Arbre::getPreu).sum();
        }
        //getting flors value
        if (floristeria.getFlors() != null) {
            florsValue = floristeria.getFlors().stream().mapToDouble(Flor::getPreu).sum();
        }
        //getting decoracio value
        if (floristeria.getDecoracions() != null) {
            decoracionsValue = floristeria.getDecoracions().stream().mapToDouble(Decoracio::getPreu).sum();
        }

        floristeria.setPreuTotalStock(arbresValue.floatValue() + florsValue.floatValue() + decoracionsValue.floatValue());
    }

    private static void createStockFile(Floristeria floristeria, Ticket ticket) throws IOException {
        System.out.println("creating txt file");
        BufferedWriter out = new BufferedWriter(new FileWriter("C:/Floristeria/stock.txt"));
        out.write(floristeria.toString());
        out.newLine();
        out.write(ticket.toString());
        out.flush();
    }

    private static void getOldersOrders() throws IOException {
        File file = new File("C:/Floristeria/stock.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String oldOrdres;
        br.readLine();
        oldOrdres = br.readLine();
        System.out.println("Compres antigues-->" + oldOrdres);
        fr.close();
    }

    private static void amountTotalOrders(List<Object> items) throws IOException {
        File file = new File("C:/Floristeria/stock.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        List<String> preus = new ArrayList<>();
        String line;
        br.readLine();
        line = br.readLine();

        String[] splitted = line.split("preu=");
        Float totalOldVendes = 0f;
        for (int i = 1; i < splitted.length; i++) {
            totalOldVendes =  totalOldVendes + Float.parseFloat(splitted[i].substring(0, splitted[i].indexOf("}")));
        }
        fr.close();

        Float totalVendes = 0f;
        for (Object obj : items) {
            if (obj instanceof Arbre) {
                totalVendes = totalVendes + ((Arbre) obj).getPreu();
            }
            if (obj instanceof Flor) {
                totalVendes = totalVendes + ((Flor) obj).getPreu();
            }

            if (obj instanceof Decoracio) {
                totalVendes = totalVendes + ((Decoracio) obj).getPreu();
            }
        }
        Float result = totalVendes+totalOldVendes;
        System.out.println("Total Vendes-->" + result ) ;

    }

    private static void ticketCreation(Floristeria floristeria, Ticket ticket, List<Object> items, Scanner sn) throws IOException {
        Boolean exit = false;

        while (!exit) {
            System.out.println("Seleccionar el objectes que vols comprar \n 1.Arbres \n 2.Flors \n 3.Decoració \n 4.Finalitzar Compra");
            try {
                int selectedOption = sn.nextInt();
                switch (selectedOption) {
                    case 1:
                        if (floristeria.getArbres() != null && !floristeria.getArbres().isEmpty()) {
                            floristeria.getArbres().stream().forEach(System.out::println);
                            System.out.println("Introdueix el nom de l'arbre que vols afegir a la teva compra:");
                            String arbreName = sn.next();
                            Optional optional = floristeria.getArbres().stream().filter(x -> x.getNom().equalsIgnoreCase(arbreName)).findFirst();
                            if (optional.isPresent()) {
                                items.add(optional.get());
                                ticket.setItems(items);
                                System.out.println("Producte afegit correctament");
                            } else {
                                System.out.println("<<::WARNING::>>Arbre no afegit, no está dins de la llista de productes");
                            }
                        } else {
                            System.out.println("La floristeria no té arbres disponibles");
                        }
                        break;
                    case 2:
                        if (floristeria.getFlors() != null && !floristeria.getFlors().isEmpty()) {
                            floristeria.getFlors().stream().forEach(System.out::println);
                            System.out.println("Introdueix el nom de la flor que vols afegir a la teva compra:");
                            String florName = sn.next();
                            Optional optional = floristeria.getFlors().stream().filter(x -> x.getNom().equalsIgnoreCase(florName)).findFirst();
                            if (optional.isPresent()) {
                                items.add(optional.get());
                                ticket.setItems(items);
                                System.out.println("Producte afegit correctament");
                            } else {
                                System.out.println("<<::WARNING::>>Flor no afegida, no está dins de la llista de productes");
                            }
                        } else {
                            System.out.println("La floristeria no té flors disponibles");
                        }
                        break;
                    case 3:
                        if (floristeria.getDecoracions() != null && !floristeria.getDecoracions().isEmpty()) {
                            floristeria.getDecoracions().stream().forEach(System.out::println);
                            System.out.println("Introdueix el nom de la decoració que vols afegir a la teva compra:");
                            String decoracioName = sn.next();
                            Optional optional = floristeria.getDecoracions().stream().filter(x -> x.getNom().equalsIgnoreCase(decoracioName)).findFirst();
                            if (optional.isPresent()) {
                                items.add(optional.get());
                                ticket.setItems(items);
                                System.out.println("Producte afegit correctament");
                            } else {
                                System.out.println("<<::WARNING::>>Decoraciço no afegida, no está dins de la llista de productes");
                            }
                        } else {
                            System.out.println("La floristeria no té decoracions disponibles");
                        }
                        break;
                    case 4:
                        exit = true;
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