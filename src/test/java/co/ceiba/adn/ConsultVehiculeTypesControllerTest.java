package co.ceiba.adn;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.Is.is;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ConsultVehiculeTypesControllerTest {
	
    @LocalServerPort
    private int port;
	
	@Test
	public void debeRetornarLosTyposDeVehiculos() {
        when()
        .get(String.format("http://localhost:%s/types", port))
        .then()
        .statusCode(is(200))
        .body(containsString("CARRO"));
	}

}
