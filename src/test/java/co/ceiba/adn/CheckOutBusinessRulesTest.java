package co.ceiba.adn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import co.ceiba.adn.domain.businessrules.CheckOutBusinessRules;
import co.ceiba.adn.domain.exception.VehicleRegistrationException;
import co.ceiba.adn.domain.model.VehicleRegistration;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CheckOutBusinessRulesTest {
	
	@Autowired
	private CheckOutBusinessRules businessRules;
	
	private static String dateFormat = "yyyy-MM-dd HH:mm"; 
	
	@Test(expected = VehicleRegistrationException.class)
	public void ifRegistrationDoesNotExistThenReturnsException() {
		businessRules.checkIfRegistrationExists(0);
	}
	
	@Test
	public void ifRegistrationExistThenReturnsTheRegistrationObject() {
		VehicleRegistration registration = businessRules.checkIfRegistrationExists(1);
		assertNotNull(registration);
		assertEquals(0 , registration.getDomainStatus());
	}
	
	@Test
	public void mustUpdateTheTotalValueToPayForTypeCar() {
		VehicleRegistration registration = new VehicleRegistrationBuilder().setDate("2019-05-16 13:00").carro().build();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
		LocalDateTime dateTime = LocalDateTime.parse("2019-05-16 21:00", formatter);
		businessRules.calculateValueToPay(registration, dateTime);
		assertTrue(registration.getDomainValue() == 8000D);
	}
	
	@Test
	public void mustUpdateTheTotalValueToPayForTypeBike() {
		VehicleRegistration registration = new VehicleRegistrationBuilder().setDate("2019-05-16 13:00").moto().build();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
		LocalDateTime dateTime = LocalDateTime.parse("2019-05-16 21:00", formatter);
		businessRules.calculateValueToPay(registration, dateTime);
		assertTrue(registration.getDomainValue() == 4000D);
	}
	
	@Test
	public void mustUpdateTheTotalValueToPayForTypeCarMoreThanMaxHours() {
		VehicleRegistration registration = new VehicleRegistrationBuilder().setDate("2019-05-16 13:00").carro().build();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
		LocalDateTime dateTime = LocalDateTime.parse("2019-05-17 00:00", formatter);
		businessRules.calculateValueToPay(registration, dateTime);
		assertTrue(registration.getDomainValue() == 8000D);
	}
	
	@Test
	public void mustUpdateTheTotalValueToPayForTypeBikeMoreThanMaxHours() {
		VehicleRegistration registration = new VehicleRegistrationBuilder().setDate("2019-05-16 13:00").moto().build();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
		LocalDateTime dateTime = LocalDateTime.parse("2019-05-17 00:00", formatter);
		businessRules.calculateValueToPay(registration, dateTime);
		assertTrue(registration.getDomainValue() == 4000D);
	}
	
	@Test
	public void mustUpdateTheTotalValueToPayForTypeCarDays() {
		VehicleRegistration registration = new VehicleRegistrationBuilder().setDate("2019-05-16 13:00").carro().build();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
		LocalDateTime dateTime = LocalDateTime.parse("2019-05-17 14:15", formatter);
		businessRules.calculateValueToPay(registration, dateTime);
		assertTrue(registration.getDomainValue() == 9000D);
	}
	
	@Test
	public void mustUpdateZeroForTypeInvalidMoreThanMaxHours() {
		VehicleRegistration registration = new VehicleRegistrationBuilder().setDate("2019-05-16 13:00").conTipoDeVehiculoErrado().build();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
		LocalDateTime dateTime = LocalDateTime.parse("2019-05-17 00:00", formatter);
		businessRules.calculateValueToPay(registration, dateTime);
		assertTrue(registration.getDomainValue() == 0D);
	}
	
	@Test
	public void mustUpdateZeroForTypeInvalidBike() {
		VehicleRegistration registration = new VehicleRegistrationBuilder().setDate("2019-05-16 13:00").conTipoDeVehiculoErrado().build();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
		LocalDateTime dateTime = LocalDateTime.parse("2019-05-16 21:00", formatter);
		businessRules.calculateValueToPay(registration, dateTime);
		assertTrue(registration.getDomainValue() == 0D);
	}	

}
