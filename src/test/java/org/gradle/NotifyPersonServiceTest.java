package org.gradle;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import junit.framework.Assert;

public class NotifyPersonServiceTest {
	private NotifyPersonService notifyPersonService;
	private EmailService emailService;
	
	@Before
	public void setUp(){
		emailService = new EmailService();
		notifyPersonService = new NotifyPersonService(emailService);
	}
	
	@Test
	public void notifyTest(){
		Person person = new PersonTestDataBuilder().build();
		
		String message = notifyPersonService.notify(person);
		
		assertNotNull(message);
	}
	
	@Test
	public void notifyTestMock(){
		emailService = Mockito.mock(EmailService.class);
		Mockito.when(emailService.sendEmail(Mockito.anyString())).thenReturn("Hola Mundo");
		notifyPersonService = new NotifyPersonService(emailService);
		
		Person person = new PersonTestDataBuilder().build();
		
		String message = notifyPersonService.notify(person);
		
		assertEquals(message, "Hola Mundo");
	}
}
