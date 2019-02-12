/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema;

/**
 *
 * @author family
 */
public class Seance implements Tarif{

    private String dateProjection;
    private String heureProjection;
    private Film film;
    private Salle salle;
    static int nbrPlaceAcheter = 0;
    private int placeGratuit = 0;
    private int placeNormale = 0;
    private int placeReduit = 0;
    private int ca = 0;

    public int getCa() {
        return ca;
    }

    public void setCa(int ca) {
        this.ca = ca;
    }

    public void setDateProjection(String dateProjection) {
        this.dateProjection = dateProjection;
    }

    public void setHeureProjection(String heureProjection) {
        this.heureProjection = heureProjection;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    public String getDateProjection() {
        return dateProjection;
    }

    public String getHeureProjection() {
        return heureProjection;
    }

    public Film getFilm() {
        return film;
    }

    public Salle getSalle() {
        return salle;
    }

    public Seance(String dateProjection, String heureProjection, Film film, Salle salle) {
        this.dateProjection = dateProjection;
        this.heureProjection = heureProjection;
        this.film = film;
        this.salle = salle;
    }

    public void ajouterPlaceNormale(int placeNormale, int nbrPlace) throws MaxPlaceExecption{
        if (placeNormale + placeGratuit + placeReduit <= nbrPlace) {
            this.placeNormale = placeNormale;
            nbrPlaceAcheter += placeNormale;
            ca += Tarif.normale * placeNormale;
        } else {
            throw new MaxPlaceExecption(nbrPlace);
        }
    }

    public void ajouterPlaceGratuit(int nbrPlace) {
            placeGratuit = nbrPlace -(placeNormale+ placeReduit);
    }

    public void ajouterPlaceReduit(int placeReduit, int nbrPlace)throws MaxPlaceExecption {
        if (placeNormale + placeGratuit + placeReduit <= nbrPlace) {
            this.placeReduit = placeReduit;
            nbrPlaceAcheter += placeReduit;
            ca += Tarif.reduit * placeReduit;
     
        } else {
            throw new MaxPlaceExecption(nbrPlace);
        }

    }

    public static void setNbrPlaceAcheter(int nbrPlaceAcheter) {
        nbrPlaceAcheter = nbrPlaceAcheter;
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

}
