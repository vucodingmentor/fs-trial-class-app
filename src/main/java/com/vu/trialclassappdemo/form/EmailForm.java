package com.vu.trialclassappdemo.form;

public class EmailForm {

	private String recipients;
	private String subject;
	private String messages;
	
	public EmailForm(String recipients, String subject, String messages) {
		super();
		this.recipients = recipients;
		this.subject = subject;
		this.messages = messages;
	}

	public EmailForm() {
		super();
	}

	public String getRecipients() {
		return recipients;
	}

	public void setRecipients(String recipients) {
		this.recipients = recipients;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessages() {
		return messages;
	}

	public void setMessages(String messages) {
		this.messages = messages;
	}
	
}
