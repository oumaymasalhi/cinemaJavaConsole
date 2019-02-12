/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author family
 */
public class Film {
    private int id;
    private String titre;
    private String anneRealisation;
    private String description;
 
    public Film(int id, String titre, String anneRealisation, String description) {
        this.id = id;
        this.titre = titre;
        this.anneRealisation = anneRealisation;
        this.description = description;

    }
    public void afficher(){
        System.out.println(toString());
     }
  
    public int getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public String getAnneRealisation() {
        return anneRealisation;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Film{" + "id=" + id + ", titre=" + titre + ", anneRealisation=" + anneRealisation + ", description=" + description + '}';
    }
    public void modifierTitre(String titre){
        this.titre = titre;
    }
     public void modifierDescription(String description){
        this.description = description;
    }
      public void modifierAnneRealisation(String anneRealisation){
        this.anneRealisation = anneRealisation;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setAnneRealisation(String anneRealisation) {
        this.anneRealisation = anneRealisation;
    }

    public void setDescription(String description) {
        this.description = description;
    }
      

    
}
