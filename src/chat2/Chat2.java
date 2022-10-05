/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat2;

import java.io.*;

import java.net.*;

/**
 *
 * @author Alumno
 */
public class Chat2 {
    public static void main(String[] args) throws Exception {
        
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        DatagramSocket clienteSocket = new DatagramSocket();
        InetAddress IPAddress = InetAddress.getByName("192.168.21.159");
        
        byte[] sendData = new byte[1024];
        
        byte[] receiveData = new byte[1024];
        while(true){
        String sentence = inFromUser.readLine();
        sendData = sentence.getBytes();
        DatagramPacket sendPacket = new DatagramPacket (sendData,sendData.length,IPAddress,9876);
        clienteSocket.send(sendPacket);
        DatagramPacket receivePacket = new DatagramPacket(receiveData,receiveData.length);
        clienteSocket.receive(receivePacket);
        String modifiedSentence = new String(receivePacket.getData());
        System.out.println("FROM SERVER:"+ modifiedSentence);
        
        }

        
    }
    
}
