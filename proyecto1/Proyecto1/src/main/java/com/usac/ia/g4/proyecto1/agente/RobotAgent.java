/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usac.ia.g4.proyecto1.agente;

import jade.core.AID;
import jade.core.Agent;

/**
 *
 * @author Fernando
 */
public class RobotAgent extends Agent{
    
    String nickname = "HAL9000";
    AID id = new AID(nickname, AID.ISLOCALNAME);
    
    private String targetRobotName;
    private AID[] robotAgents = { new AID("Agente 2", AID.ISLOCALNAME), new AID("Agente 3", AID.ISLOCALNAME)};
    
    public void setup(){
        System.out.println("Hola mundo, el agente"+getLocalName()+" está listo.");
        //Obteniendo parámetros
        Object[] args = getArguments();
        if(args != null && args.length > 0){
            targetRobotName = (String) args[0];
            System.out.println("Intentando contactar a "+targetRobotName);
        }else{
            System.out.println("No se especificó el nombre del robot.");
            doDelete();
        }
    }
    
    protected void takeDown(){
        System.out.println("Robot-Agent "+getAID().getName()+" terminating.");
    }
}
