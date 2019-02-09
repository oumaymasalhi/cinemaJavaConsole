/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema;

import java.util.ArrayList;

/**
 *
 * @author family
 */
public class Salle {
    private int numSalle;
    private int nbrPlace;
    static int nbrPlaceAcheter = 0;
    private int placeGratuit = 0;
    private int placeNormale = 0;
    private int placeReduit = 0;

    public static void setNbrPlaceAcheter(int nbrPlaceAcheter) {
        Salle.nbrPlaceAcheter = nbrPlaceAcheter;
    }

    public void setPlaceGratuit(int placeGratuit) {
        this.placeGratuit = placeGratuit;
    }

    public void setPlaceNormale(int placeNormale) {
        this.placeNormale = placeNormale;
    }

    public void setPlaceReduit(int placeReduit) {
        this.placeReduit = placeReduit;
    }

 

    public int getNbrPlace() {
        return nbrPlace;
    }

    public static int getNbrPlaceAcheter() {
        return nbrPlaceAcheter;
    }

    public int getPlaceGratuit() {
        return placeGratuit;
    }

    public int getPlaceNormale() {
        return placeNormale;
    }

    public int getPlaceReduit() {
        return placeReduit;
    }

    

    
   

    public Salle(int numSalle, int nbrPlace) {
        this.numSalle = numSalle;
        this.nbrPlace = nbrPlace;
        System.out.println("-------salle crée avec succées-----\n");
    }

    public int getNumSalle() {
        return numSalle;
    }

    public void setNumSalle(int numSalle) {
        this.numSalle = numSalle;
    }

    public void setNbrPlace(int nbrPlace) {
        this.nbrPlace = nbrPlace;
    }

    public void ajouterPlaceNormale(int placeNormale) {
        if (placeNormale + placeGratuit + placeReduit < nbrPlace) {
            this.placeNormale = placeNormale;
            nbrPlaceAcheter += placeNormale;
        } else {
            System.out.println("il atteint le nombre maximal des place ");
        }
    }

    public void ajouterPlaceGratuit(int placeGratuit) {
        if (placeNormale + placeGratuit + placeReduit < nbrPlace) {
            this.placeGratuit = placeGratuit;
            nbrPlaceAcheter += placeGratuit;
        } else {
            System.out.println("il atteint le nombre maximal des place ");
        }
    }

    public void ajouterPlaceReduit(int placeReduit) {
        if (placeNormale + placeGratuit + placeReduit < nbrPlace) {
            this.placeReduit = placeReduit;
            nbrPlaceAcheter += placeReduit;

        } else {
            System.out.println("il atteint le nombre maximal des place ");
        }

    }

    public void afficherNombreDesPlaceAcheter() {
        System.out.println("le nombre des place réservé pour cette salle est: " + nbrPlaceAcheter);
    }

    public void ajouterSeance(Seance seance) {

    }

}
