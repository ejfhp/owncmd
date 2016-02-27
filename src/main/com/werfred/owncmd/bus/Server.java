package com.werfred.owncmd.bus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Logger;

import com.werfred.owncmd.messages.SystemMessage;

/**
 * Created by diego on 26/02/16.
 */
public class Server {
	private Logger logger;
	private String address;
	private int port;
	private BufferedReader in;
	private PrintWriter out ;
	private Socket socket;

	public Server(String address, int port) throws Exception {
		this.logger = Logger.getLogger(Server.class.getName());
		this.logger.info("New Server address:" + address + " port:" + port);
		this.address = address;
		this.port = port;
	}

	public boolean sendCommand(String message) throws Exception {
		this.logger.info("sendCommand message:" + message);
		boolean connectionOpened = this.openConnection(this.address, this.port);
		this.sendMessage(SystemMessage.OPEN_COMMAND_SESSION, this.out);
		this.checkACK(this.in);
	    this.sendMessage(message, this.out);
	    boolean messageSent = this.checkACK(this.in);
		this.closeConnection();
		return messageSent;
	}
	
	public String getStatus(String message) throws Exception {
		this.logger.info("sendCommand message:" + message);
		boolean connectionOpened = this.openConnection(this.address, this.port);
		this.sendMessage(SystemMessage.OPEN_COMMAND_SESSION, this.out);
		this.checkACK(this.in);
	    this.sendMessage(message, this.out);
	    String status = this.readMessage(this.in);
	    this.checkACK(this.in);
		this.closeConnection();
		return status;
	}

	private void closeConnection() throws IOException {
		this.logger.info("closeConnection");
		this.in.close();
		this.in = null;
		this.out.close();
		this.out = null;
		this.socket.close();
		this.socket = null;
	}
	
	private boolean openConnection(String ip, int port) throws Exception {
		this.logger.info("openConnection ip:" + ip + " port:" + port);
		this.socket = new Socket(ip, port);
		this.out = new PrintWriter(socket.getOutputStream(), true);
		this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		return this.checkACK(this.in);
	}
	
	private void sendMessage(String message, PrintWriter writer) throws Exception {
		this.logger.info("sendCommand message:" + message);
		writer.write(message);
		writer.flush();
	}
	
	private boolean checkACK(BufferedReader reader) throws IOException {
		this.logger.info("checkACK");
		boolean response = false;
		String message = this.readMessage(reader);
		if (message.equals(SystemMessage.ACK)) {
			response = true;
		}
		return response;
	}

	private String readMessage(BufferedReader reader) throws IOException {
		StringBuffer message = new StringBuffer();
		int charInt = 0;
		char c = ' ';
		boolean foundFirst = false;
		boolean foundSecond = false;
		// Message finish with '##'
		int cycle = 0;
		do {
			cycle ++;
			charInt = reader.read();
			if (charInt == -1) {
				this.logger.info("Premature end of stream.");
				throw new IOException("Premature end of stream from OWN Server.");
			} else {
				c = (char) charInt;
				message.append(c);
				if (c == '#') { // Found first #
					if (foundFirst) {
						foundSecond = true;
					}
					foundFirst = true;
				} else {
					foundFirst = false;
				}
			}
		} while (!foundSecond && cycle < 100);
		String msg = message.toString();
		this.logger.info("readMessage message is: " + msg);
		return msg;
	}

}
