/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Vista.VentanaChat;
import Vista.VentanaPrincipal;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author viccr
 */
public class Cliente implements Runnable{
    private int port;
    private String serverName;
    private Socket socket;
    private DataInputStream entrada;
    private VentanaChat chat;
    private String mensaje;
     CryptSecurity cifrador= new CryptSecurity();
    public Cliente(Socket socket, VentanaChat chat){
        try {
            socket = new Socket(serverName, port);
        } catch (IOException ex) {
            System.out.println("Error en el constructor del cliente");
        }
    }

    public Socket getSocket() {
        return socket;
    }
 
    @Override
    public void run() {
        try {
            entrada = new DataInputStream(socket.getInputStream());
            while(true){
                mensaje = entrada.readUTF();
                cifrador.crypt(mensaje);
                chat.setMensaje(mensaje);
                
            }} catch (IOException ex) {
            System.out.println("error en el run del cliente");
        } catch (Exception ex) {
            System.out.println("");
        }
    }
    public static void main(String[] args) {
        VentanaPrincipal ventana = new VentanaPrincipal();
        ventana.setVisible(true);
    }
}
