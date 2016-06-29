/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Vista.VentanaChat;
import java.io.DataInputStream;
import java.net.Socket;

/**
 *
 * @author viccr
 */
public class HiloChats extends Thread {
    private VentanaChat chat;
    private Socket socket;
    private DataInputStream entrada;
    
    public HiloChats(VentanaChat chat, Socket socket){
        this.chat = chat;
        this.socket = socket; 
    }
    
       @Override
    public void run(){
        String mensaje;
        while(true){
            try {
                entrada = new DataInputStream(socket.getInputStream());
                mensaje = entrada.readUTF();
                
            } catch (Exception e) {
                System.out.println("");
            }
        }
    }
}
