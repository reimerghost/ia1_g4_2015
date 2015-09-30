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
    final static GpioPinDigitalOutput pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "MyLED", PinState.HIGH);

    public static void encenderPin() {
        // provision gpio pin #01 as an output pin and turn on
        // set shutdown state for this pin
        pin.setShutdownOptions(true, PinState.LOW);
    }

    public void apagarPin() {

    }

}
