package com.github.lorenzosmc.projectmanager.model.project;

public class Message {
	private String text;
	private Message replyTo;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Message getReplyTo() {
		return replyTo;
	}

	public void setReplyTo(Message replyTo) {
		this.replyTo = replyTo;
	}

}
