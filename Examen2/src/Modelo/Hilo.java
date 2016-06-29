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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author viccr
 */
public class Hilo extends Thread {

    private String nombre;
    private String chat, nombreChat;
    private Servidor server;
    private String nameChat;
    private Socket socket;
    private DataInputStream entrada;
    private DataOutputStream salida;
    HashMap<String, ArrayList> hash;
    private static ArrayList<Hilo> array;
    private String[] lista;
    private String mensaje;
    private CryptSecurity cifrador;

    //hash(string, array<hilos>)
    //socket, array
    public Hilo(String nameChat, String nombre, Servidor server, Socket socket) {
        try {
            this.nombre = nombre;
            this.server = server;
            this.socket = socket;
            this.nameChat = nameChat;
            cifrador = new CryptSecurity();
            mensaje = "";
            hash = new HashMap<>();
            array = new ArrayList<>();
            hash.put("Difusion", array);

            salida = new DataOutputStream(this.socket.getOutputStream());
            salida.flush();
            entrada = new DataInputStream(this.socket.getInputStream());
        } catch (IOException ex) {
            System.out.println("Error en el constructor de la clase hilo");
        }
    }

    public void escribir(String nombre, String mensaje) {
        if (!nombre.equalsIgnoreCase(this.nombre)) {
            try {
                salida.writeUTF(mensaje);
            } catch (IOException ex) {
                ex.printStackTrace();
                System.out.println("Error en el metodo de escbirir clase hilos");
            }
        }
    }

    @Override
    public void run() {
        //guardarHash();
        while (true) {
            try {
                if (!true) {
                    break;
                }
                mensaje = entrada.readUTF();
                mensaje = getMensageOriginal(mensaje);

                lista = mensaje.split(",");

                nombreChat = lista[0];

                mensaje = lista[1];

                controlMensaje(nombreChat, mensaje, lista);

//                 for(int i=1;i<lista.length;i++){
//                     hash.put(nombreChat, array);
//                 }
//                server.escribirTodos(lista[0],this.nombre,mensaje);//quitar el nameChat de parametos de esta clase
//                System.out.println("Despues del escribir todos");
            } catch (IOException ex) {
                System.out.println("Error en el run de la clase hilo");
            }
        }
    }

    //guardarHash(){input data,..... chat = input.readUTF() has = chat.split(,) list[0] = nombreChat 
    //for(recorrer la list (de string) length) hash.put();
    public void guardarHash() {
        try {
            chat = entrada.readUTF();
            lista = chat.split(";");
            lista[0] = nombreChat;
            System.out.println("En el Hilo tiene el nomChat: " + nombreChat);
            for (int i = 1; i < lista.length; i++) {
                hash.put(nombreChat, array);
            }
        } catch (IOException ex) {
            System.out.println("Error en el guardar hash");
        }
    }

    public void cerrar() {
        try {
            salida.close();
            entrada.close();
            socket.close();
        } catch (IOException ex) {
            System.out.println("Error en el cerrar de la clase hilo");
        }
    }

    private String getMensageOriginal(String mensaje) {
        try {

            return cifrador.DeCrypt(mensaje);

        } catch (Exception ex) {
            System.out.println("Error de descifrado");
        }
        return "";
    }

    private void controlMensaje(String chatType, String msj, String[] lista) {
        switch (chatType) {
            case "Difusion":

                for (int i = 1; i < lista.length; i++) {
                    hash.put(chatType, array);
                }
                server.escribirTodos(chatType, this.nombre, msj);//quitar el nameChat de parametos de esta clase
                System.out.println("Despues del escribir todos");

                break;
            case "Grupal":
                /*---------------se recorre el hash------------*/
                if (hash.containsKey(chatType)) {
                    ArrayList<Hilo> aux = hash.get(chatType);
                    for (int index = 0; index < aux.size(); index++) {
                        aux.get(index).escribir(this.nombre, msj);
                    }

                    hash.put(chatType, aux);
                    /* actualizo el hash*/
                }

                break;
            case "Privado":
                /*---------------se recorre el hash------------*/
                if (hash.containsKey(chatType)) {
                    ArrayList<Hilo> aux = hash.get(chatType);
                    for (int index = 0; index < aux.size(); index++) {
                        aux.get(index).escribir(this.nombre, msj);
                    }

                    hash.put(chatType, aux);
                    /* actualizo el hash*/
                }
                break;
        }
    }
}
