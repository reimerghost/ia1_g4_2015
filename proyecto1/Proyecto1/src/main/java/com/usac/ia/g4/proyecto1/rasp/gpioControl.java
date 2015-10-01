/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usac.ia.g4.proyecto1.rasp;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author reimer
 */
public class gpioControl {

    // create gpio controller
    final static GpioController gpio = GpioFactory.getInstance();
    final static ArrayList<GpioPinDigitalOutput> pin = new ArrayList<GpioPinDigitalOutput>();

    public gpioControl(int n) {
        int t = 0;
        for (int i = 0; i <= n; i++) {
            pin.add(i, gpio.provisionDigitalOutputPin(getPin(i), "El_Pin".concat(i + ""), PinState.HIGH));
            pin.get(i).low();
            System.out.println(t);
            t++;
        }
        if (t > 0) {
            System.out.println("Paso por aqui: "+t);
        }
        System.out.println("--> GPIO state should be: OFF");
    }

    private Pin getPin(int i) {
        Pin p = null;
        switch (i) {
            //LOS PINES NORMALES
            case 0:
                return RaspiPin.GPIO_00;
            case 1:
                return RaspiPin.GPIO_01;
            case 2:
                return RaspiPin.GPIO_02;
            case 3:
                return RaspiPin.GPIO_03;
            case 4:
                return RaspiPin.GPIO_04;
            case 5:
                return RaspiPin.GPIO_05;
            case 6:
                return RaspiPin.GPIO_06;
            //LOS OTROS
            case 7:
                return RaspiPin.GPIO_18;
            case 8:
                return RaspiPin.GPIO_17;
            case 9:
                return RaspiPin.GPIO_20;
            case 10:
                return RaspiPin.GPIO_19;
        }
        return p;
    }

    public void encenderPin(int i) {
        System.out.println("ON");
        pin.get(i).high();
    }

    public void apagarPin(int i) {
        System.out.println("OFF");
        pin.get(i).low();
    }

    public void tooglePin(int i) {
        pin.get(i).toggle();
    }
    
    public void apagaTodo(){
        Iterator<GpioPinDigitalOutput> i = pin.iterator();
        while(i.hasNext()){
            i.next().low();
            
        }
    }
    
    public void getPinStatus(){
        Iterator<GpioPinDigitalOutput> i = pin.iterator();
        String s = "Estado actual: ";
        while(i.hasNext()){
            if(i.next().getState().isHigh()){
                s+=1;
            }
            if(i.next().getState().isLow()){
                s+=0;
            }
        }
    }

}
