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
public class Seance {

    private String dateProjection;
    private String heureProjection;
    private Film film;
    private Salle salle;
    private double seanceCA = 0;

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

    public void setSeanceCA(double seanceCA) {
        this.seanceCA = seanceCA;
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

    public double getSeanceCA() {
        return seanceCA;
    }

    public Seance(String dateProjection, String heureProjection, Film film, Salle salle) {
        this.dateProjection = dateProjection;
        this.heureProjection = heureProjection;
        this.film = film;
        this.salle = salle;
        System.out.println("Senace a été creer avec succes");
    }

}
