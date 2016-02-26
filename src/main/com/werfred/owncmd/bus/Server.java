package com.werfred.owncmd.bus;

import com.werfred.owncmd.messages.SystemMessage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by diego on 26/02/16.
 */
public class Server {
    private String address;
    private int port;

    public Server(String address, int port) {
        this.address = address;
        this.port = port;
    }

    public boolean sendCommand(String action) throws Exception {
        Socket socket = this.openSocket(this.address, this.port);

        BufferedReader inputStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter outputStream = new PrintWriter(socket.getOutputStream(),true);


        outputStream.write(SystemMessage.OPEN_EVENT_SESSION);
        outputStream.flush();
        return true;

    }

    public boolean readEvent(String action) {
        return false;
    }



    private Socket openSocket(String address, int port) throws Exception {
        InetAddress ip = InetAddress.getByName(address);
        Socket socket = socket = new Socket(ip, port);
        return socket;
    }

}
