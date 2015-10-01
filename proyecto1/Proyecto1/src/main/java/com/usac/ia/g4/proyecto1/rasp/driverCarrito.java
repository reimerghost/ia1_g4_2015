/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usac.ia.g4.proyecto1.rasp;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author reimer
 */
public class driverCarrito {

    gpioControl gc;

    public driverCarrito() {
        gc = new gpioControl();
    }

    public void Adelante() {
        try {
            gc.encenderPin();
            Thread.sleep(5000);
            gc.apagarPin();
            System.out.println("GO GO Adelante");
        } catch (InterruptedException ex) {
            Logger.getLogger(driverCarrito.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Atras() {
        System.out.println("Atras");
    }

    public void giraIzquierda() {
        System.out.println("90g a las Izquierda");
    }

    public void giraDerecha() {
        System.out.println("90g a la Derecha");
    }

}
