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
        gc.apagaTodo();
        gc.apagarPin(2);
        gc.encenderPin(3);
        gc.encenderPin(0);
        gc.apagarPin(1);
        System.out.println("GO GO Adelante");
    }

    public void Atras() {
        gc.apagaTodo();
        gc.encenderPin(2);
        gc.apagarPin(3);
        gc.apagarPin(0);
        gc.encenderPin(1);
        System.out.println("Atras");
    }

    public void giraIzquierda() {
        gc.apagaTodo();
        gc.encenderPin(2);
        gc.apagarPin(3);
        gc.encenderPin(0);
        gc.apagarPin(1);
        System.out.println("90g a las Izquierda");
    }

    public void giraDerecha() {
        gc.apagaTodo();
        gc.apagarPin(2);
        gc.encenderPin(3);
        gc.apagarPin(0);
        gc.encenderPin(1);
        System.out.println("90g a la Derecha");
    }

    public void apagaTodo() {
        gc.apagaTodo();
    }

    public void getPinStatus() {
        gc.getPinStatus();
    }

}
