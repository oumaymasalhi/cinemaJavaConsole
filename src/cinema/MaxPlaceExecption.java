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
public class MaxPlaceExecption extends Exception{
    public MaxPlaceExecption(int nbrPlace){
        super("le nombre enter est supperier au nombre des places= " +nbrPlace);
    }
}
