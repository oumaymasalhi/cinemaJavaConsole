/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema;

import java.util.InputMismatchException;

/**
 *
 * @author family
 */
public class IntException extends InputMismatchException{

    public IntException() {
        super("invalid nombre");
    } 
}
