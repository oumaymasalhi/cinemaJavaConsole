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
    public static void main(String[] args) {
     
        Cineme cinema = new Cineme();
        Scanner sc = new Scanner(System.in);
        do{
        int choice = cinema.afficheMenu();

        switch (choice) {
            case 1:
                System.out.println("ajouter salle");
                System.out.println("-------------------------\n");
                System.out.print("Enter le numero de la salle: \n");
                int numSalle = sc.nextInt();
                System.out.println("-------------------------\n");
                System.out.print("Enter nombre des places : \n");
                int nbrPlace = sc.nextInt();
                Salle salle = new Salle(numSalle, nbrPlace);
                cinema.salleList.add(salle);
                break; // optional

            case 2:
                cinema.menumodelFilm();
                break; // optional
            case 3:
                System.out.println("ajouter seance");
                System.out.println("-------------------------\n");
                System.out.print("Enter la date de projection: \n");
                String dateProjection = sc.next();
                System.out.println("-------------------------\n");
                System.out.print("Enter heure de projection : \n");
                String hProjection = sc.next();
                cinema.afficherListFilm();
                System.out.println("enter le numéro du film: ");
                int numFilm = sc.nextInt();
                cinema.afficherListSalle();
                System.out.println("enter le numéro de la salle: ");
                int sall = sc.nextInt();
                System.out.println("voud avez" + cinema.salleList.get(sall).getNbrPlace() + "\n");
                System.out.println("enter le nombre de place de tarif 10DT");
                int nbTarif10 = sc.nextInt();
                cinema.salleList.get(sall).ajouterPlaceNormale(nbTarif10);
                System.out.println("enter le nombre de place de tarif 6DT");
                int nbTarif6 = sc.nextInt();
                cinema.salleList.get(sall).ajouterPlaceReduit(nbTarif6);
                cinema.salleList.get(sall).ajouterPlaceGratuit(cinema.salleList.get(sall).getNbrPlace() - nbTarif6 -nbTarif10);
  
                
                Seance sence = new Seance(dateProjection, hProjection, cinema.filmList.get(numFilm), cinema.salleList.get(sall));
                
                break; // optional  
            // You can have any number of case statements.
                   case 5:
                 {
	                    	System.exit(0);
	                    }
                break; // optional 
            default: // Optional
            // Statements
        }
        }while (true);
        

    }

}
