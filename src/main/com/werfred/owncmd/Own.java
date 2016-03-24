package com.werfred.owncmd;

import org.telegram.telegrambots.TelegramApiException;
import org.telegram.telegrambots.TelegramBotsApi;

import com.werfred.owncmd.bot.OwnBot;
import com.werfred.owncmd.bus.Server;

public class Own {
	private static String CMD_SEND_COMMAND = "SEND_COMMAND";

	public static void main(String[] args) throws Exception {
		if (args == null || args.length == 0) {
			printUsage();
		}
		try {
			if (args[0].equalsIgnoreCase(CMD_SEND_COMMAND)){
				sendCommand(args);
			} else {
				System.out.println("No command has been recognized, please check command url.");
				printUsage();
			}
		} catch (Exception e) {
			e.printStackTrace();
			printUsage();
		}
	}
	
	private static void sendCommand(String[] args) throws Exception {
		String address = args[1];
		int port = Integer.parseInt(args[2]);
		String message = args[3];
		Server server = new Server(address, port);
		server.sendCommand(message);
	}
	
	private static void startBot(String[] args) throws Exception {
	     TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
         try {
             telegramBotsApi.registerBot(new OwnBot());

         } catch (TelegramApiException e) {
             e.printStackTrace();
         }
	}
	
	private static void printUsage() {
		System.out.println("");
		System.out.println("USAGE:");
		System.out.println("owncmd.sh <CMD> [VALUES, ..]");
		System.out.println("");
		System.out.println("  Commands (only one)");
		System.out.println("    " + CMD_SEND_COMMAND + " <IP> <PORT> <MESSAGE>");
		System.out.println("");
	}
}
