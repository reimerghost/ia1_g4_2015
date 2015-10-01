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
//        gpioControl gc = new gpioControl(7);
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
//                        TESTING CHEATCODE
//                    case '1':
//                        gc.tooglePin(2);
//                        break;
//                    case '2':
//                        gc.tooglePin(3);
//                        break;
//                    case '3':
//                        gc.tooglePin(0);
//                        break;
//                    case '4':
//                        gc.tooglePin(1);
//                        break;
                    case 'x':
                        dc.apagaTodo();
                        break;
                    case 'z':
                        dc.getPinStatus();
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
