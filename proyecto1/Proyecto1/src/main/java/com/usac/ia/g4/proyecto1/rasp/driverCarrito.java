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

    private gpioControl gc;
    private String statusCarrito;
    private int testMode;

    public driverCarrito() {
        gc = new gpioControl(8);
        testMode = 0;
        apagaTodo();
    }

    public driverCarrito(String cheat) {
        if (cheat.toLowerCase().equals("debug")) {
            testMode = 1;
            apagaTodo();
        }
    }

    public void Adelante() {
        if (testMode == 0) {
            gc.apagaTodo();
            gc.apagarPin(2);
            gc.encenderPin(3);
            gc.encenderPin(0);
            gc.apagarPin(1);
        }
        statusCarrito = "ADELANTE";
        System.out.println("GO GO Adelante");
    }

    public void Atras() {
        if (testMode == 0) {
            gc.apagaTodo();
            gc.encenderPin(2);
            gc.apagarPin(3);
            gc.apagarPin(0);
            gc.encenderPin(1);
        }
        statusCarrito = "ATRAS";
        System.out.println("Atras");
    }

    public void giraIzquierda() {
        if (testMode == 0) {
            gc.apagaTodo();
            gc.encenderPin(2);
            gc.apagarPin(3);
            gc.encenderPin(0);
            gc.apagarPin(1);
        }
        statusCarrito = "GIRANDO IZQ";
        System.out.println("90g a las Izquierda");
    }

    public void giraDerecha() {
        if (testMode == 0) {
            gc.apagaTodo();
            gc.apagarPin(2);
            gc.encenderPin(3);
            gc.apagarPin(0);
            gc.encenderPin(1);
        }
        statusCarrito = "GIRANDO DER";
        System.out.println("90g a la Derecha");
    }

    public void apagaTodo() {
        if (testMode == 0) {
            gc.apagaTodo();
        }        
        statusCarrito = "APAGADO";
        System.out.println("APAGA TODO");
    }

    public void getPinStatus() {
        if (testMode == 0) {
            gc.getPinStatus();
        }
        
        System.out.println("STATUS: "+statusCarrito);
    }

}
