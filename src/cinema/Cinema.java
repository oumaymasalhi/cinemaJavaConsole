/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author family
 */
public class Cinema {

    /**
     * @param args the command line arguments
     */

    static int chifreAffaire = 0;
    public static void main(String[] args) {

        Cineme cinema = new Cineme();
        Scanner sc = new Scanner(System.in);
        System.out.println("------------------------------------");
        System.out.println("-----Oummayma && Hassan cinéma------");
        System.out.println("------------------------------------\n\n");

        do {
            int choice = cinema.afficheMenu();

            switch (choice) {
                case 1:
                    System.out.println("\n*************** Menu Salle **************\n");
                    System.out.print("Enter le numero de la salle: ");
                    int numSalle = sc.nextInt();
                    System.out.print("Enter nombre des places : ");
                    int nbrPlace = sc.nextInt();
                    Salle salle = new Salle(numSalle, nbrPlace);
                    cinema.ajouterSalle(salle);
                    System.out.println("*****************************************\n");

                    break; // optional

                case 2:
                    cinema.menumodelFilm();
                    break; // optional
                case 3:
                    System.out.println("\n*************** Menu Seance **************\n");
                    cinema.menuSeance();
                    System.out.println("\n*****************************************\n");

                    
                    break; // optional  
                    
                // You can have any number of case statements.
                case 4:
                    cinema.chifreAffaire();
                    break;
                case 5: {
                    System.exit(0);
                }
                break; // optional 
                default: // Optional
                // Statements
            }
        } while (true);

    }

}
