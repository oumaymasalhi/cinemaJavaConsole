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
        System.out.println("------------voici le menu-----------");
        System.out.println("cliquer sur 1 pour accéder au gestionnaire des salle");
        System.out.println("cliquer sur 2 pour accéder au gestionnaire des film");
        System.out.println("cliquer sur 3 pour accéder au gestionnaire des Seance");
        System.out.println("cliquer sur 4 pour quitter le programme");

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
        int j = 0;
        if (filmList.size() > 0) {
            while (filmList.size() > j) {
                System.out.println(j + " )" + filmList.get(j).getTitre());
                j++;
            }
        } else {
            System.out.println("vous n'avez pas encore des films pour cette cinéma! merci d'ajouter un film");
        }
    }

    public void afficherListSalle() {
        int j = 0;
        if (salleList.size() > 0) {
            while (salleList.size() > j) {
                System.out.println(j + " ) numero de la suivante " + salleList.get(j).getNumSalle());
                j++;
            }
        } else {
            System.out.println("vous n'avez pas encore des salles pour cette cinéma! merci d'ajouter une salle");
        }

    }

    public void rechercherUnFilm() {
        if (filmList.size() > 0) {
            System.out.println("cliquer sur 1 pour chercher avec le titre");
            System.out.println("cliquer sur 2 pour chercher avec le identifiant");
            System.out.println("cliquer sur 3 pour chercher avec la date de réalisation");
            System.out.println("cliquer sur 4 pour annuler la recherche");

            int rechere = sc.nextInt();
            switch (rechere) {
                case 1:
                    rechercherUnFilmByTitre();
                    break;
                case 2:
                    rechercherUnFilmById();
                    break;
                case 3:
                    rechercherUnFilmByDate();
                    break;

                case 4:
                    break;// optional  
                // You can have any number of case statements.

                default:
                    break;// Optional
            }
        } else {
            System.out.println("vous n'avez pas encore des films pour cette cinéma! merci d'ajouter un film");
        }
    }

    public void rechercherUnFilmByTitre() {
        int j = 0;
        System.out.println("entrer le titre du film ");
        String titre = sc.next();
        while (filmList.size() > j) {
            if (filmList.get(j).getTitre().equals(titre)) {
                System.out.print("le filme recherché est le suivant : ");
                filmList.get(j).afficher();
                return;
            } else {
                System.out.println("le film n'existe pas");
            }
            j++;
        }

    }

    public void rechercherUnFilmById() {
        int j = 0;
        System.out.println("entrer le identifiant du film ");
        int id = sc.nextInt();
        while (filmList.size() > j) {
            if (filmList.get(j).getId() == id) {
                System.out.print("le filme recherché est le suivant : ");
                filmList.get(j).afficher();
                return;
            } else {
                System.out.println("le film n'existe pas");
            }

            j++;
        }
    }

    public void rechercherUnFilmByDate() {
        int j = 0;
        System.out.println("entrer le identifiant du film ");
        String date = sc.next();
        while (filmList.size() > j) {
            if (filmList.get(j).getAnneRealisation().equals(date)) {
                System.out.print("le filme recherché est le suivant : ");
                filmList.get(j).afficher();
                return;
            } else {
                System.out.println("le film n'existe pas");
            }

            j++;
        }
    }
public void modifBy(int j){
    System.out.println("cliquer sur 1 pour modifier titre ");
    System.out.println("cliquer sur 2 pour modifier année de réalisation ");
    System.out.println("cliquer sur 2 pour modifier la description du film ");
    System.out.println("cliquer autre key pour annuler ");

    int supC = sc.nextInt();
    switch (supC) {
            case 1:
                    System.out.println("anter le nouveau titre ");
                    String titre = sc.next();
                    filmList.get(j).setTitre(titre);
                    
                break;
            case 2:
                System.out.println("anter la nouvelle date de réalisation ");
                    String date = sc.next();
                    filmList.get(j).setTitre(date);
                break;
            case 3:
                System.out.println("anter la nouvelle description ");
                    String desc = sc.next();
                    filmList.get(j).setTitre(desc);
                break;
            default:
                break;// Optional
        }
}
    public void modifierFilm() { 
        int j = 0;
        System.out.println("entrer le identifiant du film ");
        int id = sc.nextInt();
        
        while (filmList.size() > j) {
            if (filmList.get(j).getId() == id) {
                modifBy(j);
                return;
            } else {
                System.out.println("le film n'existe pas");
            }

            j++;
        }
    }

    public void supprimerFilm() {
        int j = 0;
        System.out.println("entrer le identifiant du film ");
        int id = sc.nextInt();
        while (filmList.size() > j) {
            if (filmList.get(j).getId() == id) {
                filmList.remove(j);
                System.out.println("le film est supprimé avec succée : ");
                return;
            } else {
                System.out.println("le film n'existe pas");
            }

            j++;
        }
    }

    public void menumodelFilm() {
        Scanner sc = new Scanner(System.in);
        System.out.println("------------------------------------");
        System.out.println("----------------voici le film--------------------\n");
        System.out.println("cliquer sur 1 pour ajouter le film au cinéma");
        System.out.println("cliquer sur 2 pour supprimer film");
        System.out.println("cliquer sur 3 pour rechercher film ");
        System.out.println("cliquer sur 4 pour afficher la liste des films");
        System.out.println("cliquer sur 5 pour modifier un film");

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
                break;// Optional
        }
    }

}
