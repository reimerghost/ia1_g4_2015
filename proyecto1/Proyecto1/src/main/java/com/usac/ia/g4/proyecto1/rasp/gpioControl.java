/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usac.ia.g4.proyecto1.rasp;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

/**
 *
 * @author reimer
 */
public class gpioControl {

    // create gpio controller
    final static GpioController gpio = GpioFactory.getInstance();
    final static GpioPinDigitalOutput pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00, "MyLED", PinState.HIGH);

    public gpioControl(){
        pin.low();
        System.out.println("--> GPIO state should be: OFF");
    }
    
    public void encenderPin() {
        // set shutdown state for this pin
        pin.setShutdownOptions(true, PinState.HIGH);
    }

    public void apagarPin() {
        // set shutdown state for this pin
        pin.setShutdownOptions(true, PinState.HIGH);
    }

}
