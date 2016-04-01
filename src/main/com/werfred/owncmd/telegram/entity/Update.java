package com.werfred.owncmd.telegram.entity;

public class Update {
	
	private int update_id;
	private Message from;
	private InlineQuery inline_query;
	private ChosenInlineResult chosen_inline_result;
	
	public Update() {
		
	}
	
	public int getUpdateID() {
		return update_id;
	}

	public Message getFrom() {
		return from;
	}

	public InlineQuery getInlineQuery() {
		return inline_query;
	}

	public ChosenInlineResult getChosenInlineResult() {
		return chosen_inline_result;
	}
	
	

}
