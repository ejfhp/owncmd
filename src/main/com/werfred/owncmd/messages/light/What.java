package com.werfred.owncmd.messages.light;

public enum What {
	
	TURN_OFF ("Turn off", 0),
	TURN_OFF_AT_Y_SPEED ("Turn off at y speed", 0),
	TURN_ON ("Turn on", 1),
	TURN_ON_AT_Y_SPEED ("Turn on at y speed", 1),
	PERCENT20 ("20%", 2),
	PERCENT30 ("30%", 3),
	PERCENT40 ("40%", 4),
	PERCENT50 ("50%", 5),
	PERCENT60 ("60%", 6),
	PERCENT70 ("70%", 7),
	PERCENT80 ("80%", 8),
	PERCENT90 ("90%", 9),
	PERCENT100 ("100%", 10),
	TURN_ON_1_MIN ("Turn on timed 1 min", 11),
	TURN_ON_2_MIN ("Turn on timed 2 min", 12),
	TURN_ON_3_MIN ("Turn on timed 3 min", 13),
	TURN_ON_4_MIN ("Turn on timed 4 min", 14),
	TURN_ON_5_MIN ("Turn on timed 5 min", 15),
	TURN_ON_15_MIN ("Turn on timed 15 min", 16),
	TURN_ON_30_SEC ("Turn on timed 30 sec", 17),
	TURN_ON_0_5_SEC ("Turn on timed 0.5 sec", 18),
	BLINK_ON_0_5_SEC ("Blink on timed 0.5 sec", 20),
	BLINK_ON_1_SEC ("Blink on timed 1 sec", 21),
	BLINK_ON_1_5_SEC ("Blink on timed 1.5 sec", 22),
	BLINK_ON_2_SEC ("Blink on timed 2 sec", 23),
	BLINK_ON_2_5_SEC ("Blink on timed 2.5 sec", 24),
	BLINK_ON_3_SEC ("Blink on timed 3 sec", 25),
	BLINK_ON_3_5_SEC ("Blink on timed 3.5 sec", 26),
	BLINK_ON_4_SEC ("Blink on timed 4 sec", 27),
	BLINK_ON_4_5_SEC ("Blink on timed 4.5 sec", 28),
	BLINK_ON_5_SEC ("Blink on timed 5 sec", 29),
	UP_ONE_LEVEL ("Up one level", 30),
	UP_X_LEVEL_AT_Y_SPEED ("Up one x level at y speed", 30),
	DOWN_ONE_LEVEL ("Down one level", 31),
	DOWN_X_LEVEL_AT_Y_SPEED ("Down one x level at y speed", 31);
	
	
	
	private String name;
	private int what;
    private int speed = -1;
    private int level = -1;
			
	private What (String name, int what) {
		this.name = name;
		this.what = what;
	}

	public String getText() {
		String text = "" + this.what;
		if (level >= 0 ) {
			text = text + "#" + level;
		}
		if (speed >= 0) {
			text = text + "#" + speed;
		}
		return text;
	}
	
	public String getName() {
		return this.name;
	} 
}
	
