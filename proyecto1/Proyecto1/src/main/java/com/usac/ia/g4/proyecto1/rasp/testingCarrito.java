/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usac.ia.g4.proyecto1.rasp;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author reimer
 */
public class testingCarrito {

    
    public static void main(String[] args) {
        boolean exit = false;
        driverCarrito dc = new driverCarrito();
        while (!exit) {
            try {
                int s = (char) System.in.read();
                switch ((char) s) {
                    case 'w':
                        dc.Adelante();
                        break;
                    case 'a':
                        dc.giraIzquierda();
                        break;
                    case 's':
                        dc.Atras();
                        break;
                    case 'd':
                        dc.giraDerecha();
                        break;
                    default:
                        System.out.println(s);
                        break;

                }
            } catch (IOException ex) {
                Logger.getLogger(testingCarrito.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
