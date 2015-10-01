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
        gc = new gpioControl(8);
    }

    public void Adelante() {
            gc.encenderPin(1);
            System.out.println("GO GO Adelante");
    }

    public void Atras() {
        gc.apagarPin(1);
        System.out.println("Atras");
    }

    public void giraIzquierda() {
        System.out.println("90g a las Izquierda");
    }

    public void giraDerecha() {
        System.out.println("90g a la Derecha");
    }

}
