/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author viccr
 */
public class Hilo extends Thread{
    private String nombre;
    private Servidor server;
    private Socket socket;
    private DataInputStream entrada;
    private DataOutputStream salida;
    
    
    public Hilo(String nombre, Servidor server, Socket socket) {
        try {
            this.nombre = nombre;
            this.server = server;
            this.socket = socket;
            
            salida = new DataOutputStream(this.socket.getOutputStream());
            salida.flush();
            entrada = new DataInputStream(this.socket.getInputStream());
        } catch (IOException ex) {
            System.out.println("Error en el constructor de la clase hilo");
        }
    }
    
    public void escribir(String nombre, String mensaje){
        if(!nombre.equalsIgnoreCase(this.nombre)){
            try {
                salida.writeUTF(mensaje);
            } catch (IOException ex) {
                ex.printStackTrace();
                System.out.println("Error en el metodo de escbirir clase hilos");
            }
        }
    }
    
    @Override
    public void run(){
        String mensaje = "";
        while(true){
            try {
                mensaje = entrada.readUTF();
                if(!true){
                    cerrar();
                    break;
                }
                server.escribirTodos(nombre,mensaje);
            } catch (IOException ex) {
                System.out.println("Error en el run de la clase hilo");
            }
        }
    }
    public void cerrar(){
        try {
            salida.close();
            entrada.close();
            socket.close();
        } catch (IOException ex) {
            System.out.println("Error en el cerrar de la clase hilo");
        }
    }
    
}
