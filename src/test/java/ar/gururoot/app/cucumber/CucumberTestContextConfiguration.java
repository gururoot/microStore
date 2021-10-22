package ar.gururoot.app.cucumber;

import ar.gururoot.app.MicroStoreApp;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

@CucumberContextConfiguration
@SpringBootTest(classes = MicroStoreApp.class)
@WebAppConfiguration
public class CucumberTestContextConfiguration {}
