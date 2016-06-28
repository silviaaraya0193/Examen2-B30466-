/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Vista.VentanaChat;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author viccr
 */
public class Servidor extends Thread {

    private ServerSocket server;
    private ArrayList<Hilo> array;
    private HashMap<String,ArrayList> hash;
    private Lock lock;
    private Hilo hilo;
    private VentanaChat ventanaC;

    public Servidor(int num) {
        try {
            server = new ServerSocket(num);
            this.ventanaC = ventanaC;
            array = new ArrayList<>();
            hash = new HashMap<>();
            hash.put("Difusion", array);
            lock = new Lock();
        } catch (Exception e) {
            System.out.println("Error en el constructor del servidor");
        }
    }

    @Override
    public void run() {
        int pos = 0;
        while (true) {
            Socket socket;
            try {
                System.out.println("Esperando conexion...");
                socket = server.accept();
                System.out.println("conexion exitosa");
                //cliente /conect nuevochat nombrechat true si es priviado o grupo 
                hilo = new Hilo("Nombre: " + ventanaC.getNombreChat(), this, socket);
                hilo.start();
                pos++;
                array.add(hilo);
            } catch (IOException ex) {
                System.out.println("Error en el run de la clase servidor");
            }
        }
    }

    public void escribirTodos(String nombre, String mensaje) {
        try {
            Hilo hilo1;
            lock.lock();
            for (int i = 0; i < array.size(); i++) {
                hilo1 = array.get(i);
                hilo1.escribir(nombre, mensaje);
            }
            lock.unlock();

        } catch (InterruptedException ex) {
            System.out.println("Error en el escribir Todos de la clase servidor");
        }
    }

    public HashMap<String, ArrayList> getHash() {
        return hash;
    }

    public void setHash(HashMap<String, ArrayList> hash) {
        this.hash = hash;
    }

    public ArrayList<Hilo> getArray() {
        return array;
    }

    public void setArray(ArrayList<Hilo> array) {
        this.array = array;
    }
   
    public static void main(String[] args) {
        Servidor server = new Servidor(6666);
        server.start();
    }
}
