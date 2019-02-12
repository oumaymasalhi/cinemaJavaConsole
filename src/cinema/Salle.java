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
    private int nbrPlace=0;



    public int getNbrPlace() {
        return nbrPlace;
    }
   

    public Salle(int numSalle, int nbrPlace) {
        this.numSalle = numSalle;
        this.nbrPlace = nbrPlace;
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

    @Override
    public String toString() {
        return "Salle{" + "numSalle=" + numSalle + ", nbrPlace=" + nbrPlace;
    }

  
    public void ajouterSeance(Seance seance) {

    }

}
