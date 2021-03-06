package org.gradle;

public class NotifyPersonService {
	private EmailService emailService;
	
	public NotifyPersonService(EmailService emailService){
		this.emailService = emailService;
	}
	
	public String notify(Person person){
		String message = "Welcome " + person.getName();
		return emailService.sendEmail(message);
	}
}
