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
public class Cineme {

    ArrayList<Salle> salleList = new ArrayList<Salle>();
    ArrayList<Film> filmList = new ArrayList<Film>();
    Scanner sc = new Scanner(System.in);

    public void ajouterSalle(Salle salle) {
        if (!salleList.contains(salle)) {
            salleList.add(salle);
        } else {
            System.out.println("la salle est déja existée");
        }
    }

    public void ajouterFilm(Film film) {
        if (!filmList.contains(film)) {
            filmList.add(film);
        } else {
            System.out.println("le film est déja existée");
        }

    }

    /* public boolean rechercheFilm(Film film) {
    filmList.forEach(value -> {
            if(value.getId() == film.getId()){
                retun true;
            }
        });
    
        }*/

    public int afficheMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("------------------------------------");
        System.out.println("Oummayma && Hassan cinéma ");
        System.out.println("----------------voici le menu--------------------\n");
        System.out.println("cliquer sur 1 pour accéder au gestionnaire des salle");
        System.out.println("cliquer sur 2 pour accéder au gestionnaire des film");
        System.out.println("cliquer sur 3 pour accéder au gestionnaire des Seance");
        int a = sc.nextInt();
        return a;
    }

    public void ajouterFilm() {
        System.out.println("creation film");
        System.out.println("-------------------------\n");
        System.out.print("Enter identifiant du film:");
        int idfilm = sc.nextInt();
        System.out.println("-------------------------\n");
        System.out.print("Enter titre du film :");
        String titre = sc.next();
        System.out.println("-----------------------\n");
        System.out.print("Enter année de réalisation du film :");
        String annee = sc.next();
        System.out.println("-------------------------\n");
        System.out.print("Enter description du film :");
        String des = sc.next();
        Film film = new Film(idfilm, titre, annee, des);
        filmList.add(film);
    }

    public void afficherListFilm() {
        System.out.println(filmList.size());
       int j=0;
        while (filmList.size() > j) {
			System.out.println(j + " : " +filmList.get(j).getTitre());
			j++;
		}
    }
    public void afficherListSalle() {
        System.out.println(salleList.size());
       int j=0;
        while (salleList.size() > j) {
			System.out.println(j + " : " +salleList.get(j).getNumSalle());
			j++;
		}
    }

    public void rechercherUnFilm() {
    }

    public void modifierFilm() {
    }

    public void supprimerFilm() {
    }

    public void menumodelFilm() {
        Scanner sc = new Scanner(System.in);
        System.out.println("------------------------------------");
        System.out.println("----------------voici le film--------------------\n");
        System.out.println("cliquer sur 1 pour ajouter le film au cinéma");
        System.out.println("cliquer sur 2 pour supprimer film");
        System.out.println("cliquer sur 3 pour rechercher film ");
        System.out.println("cliquer sur 4 pour afficher film ");
        int filmchoice = sc.nextInt();
        switch (filmchoice) {
            case 1:
                ajouterFilm();
                break;
            case 2:
                supprimerFilm();
                break;
            case 3:
                rechercherUnFilm();
                break;
            case 4:
                afficherListFilm();
                break;
            case 5:
                modifierFilm();
                break;// optional  
            // You can have any number of case statements.

            default:
                break ;// Optional
        }
    }

}
