/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


/**
 *
 * @author viccr
 */
public class Servidor extends Thread {

    private ServerSocket server;
    private static ArrayList<Hilo> array;
    private int port;
   // private static HashMap<String,ArrayList> hash;
    private Lock lock;
    private Hilo hilo;
    Socket socket;

    public Servidor(int port) {
        try {
            this.port = port;
            array = new ArrayList<>();
           // hash = new HashMap<>();
            //hash.put("Difusion", array);
            lock = new Lock();
        } catch (Exception e) {
            System.out.println("Error en el constructor del servidor");
        }
    }

    @Override
    public void run() {
       while(true){
           conectar();
       }
    }
    public void conectar(){
         int pos = 0;
        //int cont=0; 
        try {
            server = new ServerSocket(8080);
        while (true) {
           System.out.println("Esperando conexion...");
                socket = server.accept();
                System.out.println("conexion exitosa");
                //chatnae = "chat"+cont;
                //cont++;
                //cliente /conect nuevochat nombrechat true si es priviado o grupo 
                hilo = new Hilo("NameChat","Hilo: ", this, socket);
                array.add(hilo);
                //hash.put("Difusion", array);
                hilo.start();
                //System.out.println("Hilo del servidor: "+hilo.toString());
                pos++;
           
            }
        } catch (IOException ex) {
                System.out.println("Error en el run de la clase servidor");
        }
    }
    public void escribirTodos(String nameChat,String nombre, String mensaje) {
        System.out.println("Hola entro al escribir todos");
        try {
            Hilo hilo1;
            lock.lock();
            ArrayList arrayLocal;
            arrayLocal = new ArrayList<>();
            arrayLocal = hilo.hash.get(nameChat);
            System.out.println("el arrayTiene: "+arrayLocal);
           for (int i = 0; i < arrayLocal.size(); i++) {
               hilo1 = (Hilo) arrayLocal.get(i);
               hilo1.escribir(nombre, mensaje); 
           }
            lock.unlock();

        } catch (InterruptedException ex) {
            System.out.println("Error en el escribir Todos de la clase servidor");
        }
    }

    public ArrayList<Hilo> getArray() {
        return array;
    }

    public void setArray(ArrayList<Hilo> array) {
        this.array = array;
    }
    @Override
    public void start(){
        Thread t = new Thread(this);
        t.start();
    }
    public static void main(String[] args) {
        Servidor server = new Servidor(8080);
        server.start();
    }
    
}
