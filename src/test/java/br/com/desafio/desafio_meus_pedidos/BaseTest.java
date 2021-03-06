package br.com.desafio.desafio_meus_pedidos;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import br.com.desafio.desafio_meus_pedidos.LoginPage;

public class BaseTest {
	protected WebDriver driver;
	private LoginPage loginPage;
	private static final String EMAIL_LOGIN = "faustfelipe@gmail.com";
	private static final String LOGIN_URL = "http://qa.meuspedidos.com.br/login/";
	private static final String PASSWORD_LOGIN = "1234";

	@BeforeTest
	public void setUp() {
		initBrowser();
		initLogin();
	}

	private void initBrowser() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	private void initLogin() {
		loginPage = new LoginPage(driver);
		driver.get(LOGIN_URL);
		loginPage.doLogin(EMAIL_LOGIN, PASSWORD_LOGIN);
	}

	@AfterTest
	public void quitTest() {
		driver.quit();
	}

}
