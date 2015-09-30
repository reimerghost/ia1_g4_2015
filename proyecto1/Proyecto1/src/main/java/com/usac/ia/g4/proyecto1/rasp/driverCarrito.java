/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usac.ia.g4.proyecto1.rasp;

/**
 *
 * @author reimer
 */
public class driverCarrito {

    public void Adelante() {
        System.out.println("GO GO Adelante");
        gpioControl.encenderPin();
    }

    public void Atras() {
        System.out.println("Atras");
    }

    public void giraIzquierda() {
        System.out.println("90° a las Izquierda");
    }

    public void giraDerecha() {
        System.out.println("90° a la Derecha");
    }

}
