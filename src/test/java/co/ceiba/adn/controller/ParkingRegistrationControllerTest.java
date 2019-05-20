package co.ceiba.adn.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import co.ceiba.adn.AdnCeibaParkingApplication;
import co.ceiba.adn.domain.exception.VehicleRegistrationException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AdnCeibaParkingApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.properties")
public class ParkingRegistrationControllerTest {
	
	  private MockMvc mockMvc;
	  
	  @Autowired
	  private WebApplicationContext context;
	  
	  @Before
	  public void setUp() {
		  mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	  }
	  
	  @Test
	  public void register() { 	 
		  try {			  
			  this.mockMvc.perform(post("/checkin")
					  .characterEncoding("utf-8")
					  .content("{\"domainVehiclePlate\":\"BBBBBB\",\"domainStatus\":0,\"domainValue\":0,\"domainVehicleType\":{\"domainType\":\"CARRO\",\"domainCubicCapacity\":0}}")
					  .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)).andExpect(status().isOk());
		  }catch(Exception ex) {
			  throw new VehicleRegistrationException("Error en la prueba", ex);
		  }		  
	  }
}
