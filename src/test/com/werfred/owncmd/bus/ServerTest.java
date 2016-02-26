package com.werfred.owncmd.bus;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by diego on 26/02/16.
 */
public class ServerTest {

    @Test
    public void testSendCommand() throws Exception {
    	System.out.println("Start");
        Server server = new Server("192.168.28.35", 20000);
        server.sendCommand("ciao");
    }
}