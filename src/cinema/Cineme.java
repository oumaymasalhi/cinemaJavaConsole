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
public class Cineme implements ICinema{

    ArrayList<Salle> salleList = new ArrayList<Salle>();
    ArrayList<Film> filmList = new ArrayList<Film>();
    ArrayList<Seance> seanceList = new ArrayList<Seance>();
    private int ca = 0;
    Scanner sc = new Scanner(System.in);

    public void ajouterSeance(Seance seance) {
        if (!seanceList.contains(seance)) {
            seanceList.add(seance);
            System.out.println("---la seance est ajoutéé avec succées---\n");
        } else {
            System.out.println("vous avez déja ajouté cette seance ");
        }
    }

    public void ajouterSalle(Salle salle) {
        if (!salleList.contains(salle)) {
            salleList.add(salle);
            System.out.println("---la salle est ajoutéé a votre cinéma---\n");
        } else {
            System.out.println("la salle est déja existée");
        }
    }

    public void ajouterFilm(Film film) {
        if (!filmList.contains(film)) {
            filmList.add(film);
            System.out.println("---le film est ajoutéé a votre cinéma---\n");

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
        System.out.println("------------voici le menu Principale-----------");
        System.out.println("cliquer sur 1 pour accéder au gestionnaire des salle");
        System.out.println("cliquer sur 2 pour accéder au gestionnaire des film");
        System.out.println("cliquer sur 3 pour accéder au gestionnaire des Seance");
        System.out.println("cliquer sur 4 pour afficher le chifre d'affaire");
        System.out.println("cliquer sur 5 pour quitter le programme");

        int a = sc.nextInt();
        return a;
    }

    public void chifreAffaire() {
        int j = 0;
        if (seanceList.size() > 0) {
            while (seanceList.size() > j) {
                ca += seanceList.get(j).getCa();
                j++;
            }
            System.out.println("votre chifre d'affaire pour le moment est: " + ca + " DT");
        } else {
            System.out.println("vous n'avez pas encore des seance ! le chifre d'affaire est 0");
        }
    }

    public void ajouterFilm() {
        System.out.println("-- Pour ajouter un film merci de suivre les étapes suivantes: --\n");
        System.out.print("Enter identifiant du film:");
        int idfilm = sc.nextInt();
        System.out.print("Enter titre du film :");
        String titre = sc.next();
        System.out.print("Enter année de réalisation du film :");
        String annee = sc.next();
        System.out.print("Enter description du film :");
        String des = sc.next();
        Film film = new Film(idfilm, titre, annee, des);
        ajouterFilm(film);

    }

    public void afficherListFilm() throws ListVideException {
        if (filmList.size() == 0) {
            throw new ListVideException("la liste des films est vide");
        } else {
            int j = 0;          
                System.out.println("\n------- La liste des films est la suivante: ----\n");
                while (filmList.size() > j) {
                    System.out.print(j + ") ");
                    filmList.get(j).afficher();
                    j++;
                }
           
        }
    }

    public void afficherListSalle() throws ListVideException {
        if (salleList.size() == 0) {
            throw new ListVideException("la liste des salle est vide");
        } else {
            int j = 0;
                while (salleList.size() > j) {
                    System.out.println(j + ") " + salleList.get(j).toString());
                    j++;
                }
          
        }
    }

    public void rechercherUnFilm() {
        if (filmList.size() > 0) {
            System.out.println("------ choisire le critére pour recherche: ------\n");
            System.out.println("cliquer sur 1 pour chercher avec le titre");
            System.out.println("cliquer sur 2 pour chercher avec le identifiant");
            System.out.println("cliquer sur 3 pour chercher avec la date de réalisation");
            System.out.println("cliquer sur 4 pour annuler la recherche");
            System.out.println("cliquer sur any key pour annuler");

            int rechere = sc.nextInt();
            switch (rechere) {
                case 1:
                    try {
                        rechercherUnFilmByTitre();
                    } catch (Existe e) {
                        System.out.println(e);
                    }
                    break;
                case 2:
                    try {
                        rechercherUnFilmById();
                    } catch (Existe e) {
                        System.out.println(e);
                    }
                    break;
                case 3:
                    try {
                        rechercherUnFilmByDate();
                    } catch (Existe e) {
                        System.out.println(e);
                    }
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

    public void rechercherUnFilmByTitre() throws Existe {
        int j = 0;
        System.out.print("entrer le titre du film ");
        String titre = sc.next();
        while (filmList.size() > j) {
            if (!filmList.get(j).getTitre().equals(titre)) {
                throw new Existe("le film que vous avez rechercher n'exite pas");

            } else {
                System.out.print("le filme recherché est le suivant : ");
                filmList.get(j).afficher();

            }
            j++;
        }

    }

    public void rechercherUnFilmById() throws Existe {
        int j = 0;
        System.out.print("entrer le identifiant du film ");
        int id = sc.nextInt();
        while (filmList.size() > j) {
            if (filmList.get(j).getId() != id) {
                throw new Existe("le film que vous avez rechercher n'existe pas");

            } else {
                System.out.print("le filme recherché est le suivant : ");
                filmList.get(j).afficher();

            }

            j++;
        }
    }

    public void rechercherUnFilmByDate() throws Existe {
        int j = 0;
        System.out.print("entrer le identifiant du film ");
        String date = sc.next();
        while (filmList.size() > j) {
            if (!filmList.get(j).getAnneRealisation().equals(date)) {
                throw new Existe("le film que vous avez n'existe pas ");

            } else {
                System.out.print("le filme recherché est le suivant : ");
                filmList.get(j).afficher();
            }

            j++;
        }
    }

    public void modifBy(int j) {
        System.out.println("cliquer sur 1 pour modifier titre ");
        System.out.println("cliquer sur 2 pour modifier année de réalisation ");
        System.out.println("cliquer sur 2 pour modifier la description du film ");
        System.out.println("cliquer autre key pour annuler ");
        System.out.println("cliquer sur any key pour annuler");

        int supC = sc.nextInt();
        switch (supC) {
            case 1:
                System.out.print("enter le nouveau titre ");
                String titre = sc.next();
                filmList.get(j).setTitre(titre);
                System.out.println("le titre du film est modifié avec succés");
                filmList.get(j).afficher();

                break;
            case 2:
                System.out.print("anter la nouvelle date de réalisation ");
                String date = sc.next();
                filmList.get(j).setTitre(date);
                System.out.println("la date du film est modifié avec succés");
                filmList.get(j).afficher();
                break;
            case 3:
                System.out.print("anter la nouvelle description ");
                String desc = sc.next();
                filmList.get(j).setTitre(desc);
                System.out.println("la description du film est modifié avec succés");
                filmList.get(j).afficher();
                break;
            default:
                break;// Optional
        }
    }

    public void modifierFilm() throws Existe, ListVideException {
        if (filmList.size() == 0) {
            throw new ListVideException("list des films est vide");
        } else {
            int j = 0;
            System.out.print("entrer le identifiant du film ");
            int id = sc.nextInt();
            while (filmList.size() > j) {
                if (filmList.get(j).getId() != id) {
                    throw new Existe("le film n'exite pas");

                } else {
                    System.out.println("le filme est existé");
                    modifBy(j);
                }

                j++;
            }
        }
    }

    public void supprimerFilm() throws ListVideException {
        if (filmList.size() == 0) {
            throw new ListVideException("la liste des films est vide");
        } else {
            int j = 0;
            System.out.print("entrer le identifiant du film ");
            int id = sc.nextInt();
            while (filmList.size() > j) {
                if (filmList.get(j).getId() == id) {
                    filmList.remove(j);
                    System.out.println("le film est supprimé avec succée : ");
                    afficherListFilm();
                    return;
                } else {
                    System.out.println("le film n'existe pas");
                }

                j++;
            }
        }
    }

    public void supprimerSeance() throws ListVideException {
        if (seanceList.size() == 0) {
            throw new ListVideException("la liste des seances est vide");
        } else {
            System.out.print("entrer l'index de la seance ");
            int id = sc.nextInt();
            seanceList.remove(id);
            System.out.print("La seance est suprimée avec succées");

        }

    }

    public void supprimerSalle() throws ListVideException {
        if (salleList.size() == 0) {
            throw new ListVideException(" la liste des salles est vide ");
        } else {
            System.out.print("entrer l'index de la salle ");
            int id = sc.nextInt();
            salleList.remove(id);
            System.out.println("La salle est supromée avec succées");
        }

    }

    public void ajouterSalle() {
        System.out.print("Enter le numero de la salle: ");
        int numSalle = sc.nextInt();
        System.out.print("Enter nombre des places : ");
        int nbrPlace = sc.nextInt();
        Salle salle = new Salle(numSalle, nbrPlace);
        ajouterSalle(salle);
    }

    public void menuSalle() {

        System.out.println("cliquer sur 1 pour ajouter une salle");
        System.out.println("cliquer sur 2 pour afficher la liste des salles");
        System.out.println("cliquer sur 3 pour supprime une salle");
        System.out.println("cliquer sur any key pour annuler");
        int seancechoice = sc.nextInt();
        switch (seancechoice) {
            case 1:
                ajouterSalle();
                break;
            case 2:
                try {
                    afficherListSalle();
                } catch (ListVideException e) {
                    System.out.println(e);
                }
                break;
            case 3:
                try {
                    supprimerSalle();
                } catch (ListVideException e) {
                    System.out.println(e);
                }
                break;
            default:
                break;// Optional
        }

    }

    public void menuSeance() {
        Scanner sc = new Scanner(System.in);
        System.out.println("cliquer sur 1 pour ajouter une seance");
        System.out.println("cliquer sur 2 pour afficher la liste des seances");
        System.out.println("cliquer sur 3 pour supprime une seance");
        System.out.println("cliquer sur any key pour annuler");
        int seancechoice = sc.nextInt();
        switch (seancechoice) {
            case 1:
                ajouterSeance();
                break;
            case 2:
                try{
                afficherlistSeance();
                } catch (ListVideException e) {
                    System.out.println(e);
                }
                break;
            case 3:
                try {
                    supprimerSeance();
                } catch (ListVideException e) {
                    System.out.println(e);
                }
                break;
            default:
                break;// Optional
        }

    }

    public void afficherlistSeance() throws ListVideException{
        if(seanceList.size() == 0){
            throw new ListVideException("la liste des seance est vide");
        }else{
        int j = 0;
            while (seanceList.size() > j) {
                System.out.println(j + ") " + seanceList.get(j).toString());
                j++;
            }
        } 
    
    }

    public void ajouterSeance() {
        System.out.print("Enter la date de projection: \n");
        String dateProjection = sc.next();
        System.out.println("-------------------------\n");
        System.out.print("Enter heure de projection : \n");
        String hProjection = sc.next();
      try{
            afficherListFilm();
            System.out.print("enter l'index du film: ");
            int numFilm = sc.nextInt();
            afficherListSalle();
            System.out.println("enter l'index de la salle: ");
            int sall = sc.nextInt();
            System.out.println("voud avez" + salleList.get(sall).getNbrPlace() + " place\n");
            Seance seance = new Seance(dateProjection, hProjection, filmList.get(numFilm), salleList.get(sall));
            System.out.print("enter le nombre de place de tarif 10DT");
            int nbTarif10 = sc.nextInt();
            seance.ajouterPlaceNormale(nbTarif10, salleList.get(sall).getNbrPlace());
            System.out.print("enter le nombre de place de tarif 6DT");
            int nbTarif6 = sc.nextInt();
            seance.ajouterPlaceReduit(nbTarif6, salleList.get(sall).getNbrPlace());
            seance.ajouterPlaceGratuit(salleList.get(sall).getNbrPlace());
            ajouterSeance(seance);
        } catch (ListVideException e) {
                    System.out.println(e);
                }
    }

    public void menumodelFilm() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n*************** Menu Film **************\n");
        System.out.println("cliquer sur 1 pour ajouter le film au cinéma");
        System.out.println("cliquer sur 2 pour supprimer film");
        System.out.println("cliquer sur 3 pour rechercher film ");
        System.out.println("cliquer sur 4 pour afficher la liste des films");
        System.out.println("cliquer sur 5 pour modifier un film");
        System.out.println("cliquer sur any key pour annuler");

        int filmchoice = sc.nextInt();
        switch (filmchoice) {
            case 1:
                ajouterFilm();
                break;
            case 2:
                try {
                    supprimerFilm();
                } catch (ListVideException e) {
                    System.out.println(e);
                }
                break;
            case 3:
                rechercherUnFilm();
                break;
            case 4:

                try {
                    afficherListFilm();
                } catch (ListVideException e) {
                    System.out.println(e);
                }
                break;
            case 5:
                try {
                    modifierFilm();
                } catch (Existe | ListVideException e) {
                    System.out.println(e);
                }

                break;// optional  
            // You can have any number of case statements.
            default:
                break;// Optional
        }
        System.out.println("\n*****************************************\n");

    }

}
