package com.werfred.owncmd.messages;

/**
 * Created by diego on 26/02/16.
 */
public class SystemMessage {
    public static final String ACK = "*#*1##";
    public static final String NACK = "*#*0##";
    public static final String OPEN_COMMAND_SESSION = "*99*0##";			// OpenWebNet command to ask for a command session
    public static final String OPEN_EVENT_SESSION = "*99*1##";
    public static final String OPEN_SCENARIO_SESSION = "*99*9##";
}
