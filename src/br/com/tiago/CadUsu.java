package br.com.tiago;

import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
// import br.com.tiago.Iniciar;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CadUsu {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	private Iniciar iniciar = new Iniciar();
	String dataFormatada = iniciar.getDataFormatadaSimples();
	String dataFormatadaPorExtenso = iniciar.getDataFormatadaPorExtenso().substring(0, 30);

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C://eclipse-workspace//chromedriver_win32//chromedriver.exe");
		driver = new ChromeDriver();   
		baseUrl = "http://demo.redmine.org/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	/*	@Test
	public void test1Cadastro() throws Exception {
		driver.get(baseUrl);
		driver.findElement(By.linkText("register for an account")).click();
		driver.findElement(By.id("user_login")).clear();
		driver.findElement(By.id("user_login")).sendKeys("s" + dataFormatada);
		driver.findElement(By.id("user_password")).clear();
		driver.findElement(By.id("user_password")).sendKeys("softbox123");
		driver.findElement(By.id("user_password_confirmation")).clear();
		driver.findElement(By.id("user_password_confirmation")).sendKeys("softbox123");
		driver.findElement(By.id("user_firstname")).click();
		driver.findElement(By.id("user_firstname")).clear();
		driver.findElement(By.id("user_firstname")).sendKeys("Selena");
		driver.findElement(By.id("user_lastname")).click();
		driver.findElement(By.id("user_lastname")).clear();
		driver.findElement(By.id("user_lastname")).sendKeys(dataFormatadaPorExtenso);
		driver.findElement(By.id("user_mail")).clear();
		driver.findElement(By.id("user_mail")).sendKeys("s" + dataFormatada + "@test.com");
		driver.findElement(By.id("user_language")).click();
		new Select(driver.findElement(By.id("user_language"))).selectByVisibleText("Portuguese/Brasil (Português/Brasil)");
		driver.findElement(By.name("commit")).click();
		driver.findElement(By.id("flash_notice")).click();
		assertEquals("Sua conta foi ativada. Você pode acessá-la agora.", driver.findElement(By.id("flash_notice")).getText());
		iniciar.insereNoLog("s" + dataFormatada);
		driver.findElement(By.linkText("Sair")).click();
	}*/
	/*	@Test
	public void test2Login() throws Exception {
		driver.get(baseUrl);
		driver.findElement(By.linkText("Entrar")).click();
		driver.findElement(By.id("username")).clear();
		// driver.findElement(By.id("username")).sendKeys("s"+ dataFormatada);
		driver.findElement(By.id("username")).sendKeys("s17022046");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("softbox123");
		driver.findElement(By.name("login")).click();
		//assertEquals("Acessando como: s"+ dataFormatada, driver.findElement(By.id("loggedas")).getText());
		assertEquals("Acessando como: s17022046", driver.findElement(By.id("loggedas")).getText());
	}*/
	/*	@Test
	public void test3CriarProjeto() throws Exception {
		driver.get(baseUrl);
		driver.findElement(By.linkText("Entrar")).click();
		driver.findElement(By.id("username")).clear();
		// driver.findElement(By.id("username")).sendKeys("s"+ dataFormatada);
		driver.findElement(By.id("username")).sendKeys("s17022046");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("softbox123");
		driver.findElement(By.name("login")).click();
	    driver.findElement(By.linkText("Projetos")).click();
	    driver.findElement(By.linkText("Novo projeto")).click();
	    driver.findElement(By.id("project_name")).clear();
	    driver.findElement(By.id("project_name")).sendKeys("Projeto " + dataFormatada);
	    driver.findElement(By.id("project_description")).clear();
	    driver.findElement(By.id("project_description")).sendKeys("Projeto " + dataFormatada);
	    driver.findElement(By.name("project[tracker_ids][]")).click();
	    driver.findElement(By.xpath("(//input[@name='project[tracker_ids][]'])[2]")).click();
	    driver.findElement(By.xpath("(//input[@name='project[tracker_ids][]'])[3]")).click();
	    driver.findElement(By.name("project[tracker_ids][]")).click();
	    driver.findElement(By.name("commit")).click();
	    driver.findElement(By.id("flash_notice")).click();
	    assertEquals("Criado com sucesso.", driver.findElement(By.id("flash_notice")).getText());
	    iniciar.insereNoLog("Projeto " + dataFormatada);
	    driver.findElement(By.linkText("Projetos")).click();
	    driver.findElement(By.linkText("Projeto " + dataFormatada)).click();
	    driver.findElement(By.linkText("Nova tarefa")).click();
	    driver.findElement(By.id("issue_subject")).clear();
	    driver.findElement(By.id("issue_subject")).sendKeys("Tarefa " + dataFormatada);
	    driver.findElement(By.id("issue_description")).click();
	    driver.findElement(By.id("issue_description")).clear();
	    driver.findElement(By.id("issue_description")).sendKeys("Tarefa " + dataFormatada);
	    driver.findElement(By.name("commit")).click();
	}*/

	@Test
	public void test4CriaTarefas() throws Exception {
		driver.get(baseUrl);
		driver.findElement(By.linkText("Entrar")).click();
		driver.findElement(By.id("username")).clear();
		// driver.findElement(By.id("username")).sendKeys("s"+ dataFormatada);
		driver.findElement(By.id("username")).sendKeys("s17022046");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("softbox123");
		driver.findElement(By.name("login")).click();
		driver.findElement(By.linkText("Projetos")).click();
		//driver.findElement(By.linkText("Projeto " + dataFormatada)).click();
		driver.findElement(By.linkText("Projeto 17022143")).click();

		String path = new File(".").getCanonicalPath();
		JSONParser parser = new JSONParser();
		JSONArray a = (JSONArray) parser.parse(new FileReader(path+"\\tarefas.json"));
		for (Object o : a)
		{
			JSONObject jsonObject =  (JSONObject) o;
			String titulo = (String) jsonObject.get("titulo");
			System.out.println(titulo);
			driver.findElement(By.linkText("Nova tarefa")).click();
			driver.findElement(By.id("issue_subject")).clear();
			driver.findElement(By.id("issue_subject")).sendKeys(titulo);
			String descricao = (String) jsonObject.get("descricao");
			System.out.println(descricao);
			driver.findElement(By.id("issue_description")).click();
			driver.findElement(By.id("issue_description")).clear();
			driver.findElement(By.id("issue_description")).sendKeys(descricao);
			driver.findElement(By.name("commit")).click();
		}
	}

/*	@Test
	public void test5ValidaTarefa29() throws Exception {
		String path = new File(".").getCanonicalPath();
		JSONParser parser = new JSONParser();
		JSONArray a = (JSONArray) parser.parse(new BufferedReader(new InputStreamReader(new FileInputStream(path+"\\validação_tarefas.json"), "UTF-8")));
		for (Object o : a)
		{
			JSONObject jsonObject =  (JSONObject) o;
			if(((String) jsonObject.get("titulo")).equals("Título da Tarefa29")) {
			String titulo = (String) jsonObject.get("titulo");
			String descricao = (String) jsonObject.get("descricao");
			String tipo = (String) jsonObject.get("tipo");
			String situacao = (String) jsonObject.get("situacao");
			String prioridade = (String) jsonObject.get("prioridade");
			//System.out.println(titulo);
			driver.get(baseUrl);
			driver.findElement(By.linkText("Entrar")).click();
			driver.findElement(By.id("username")).clear();
			// driver.findElement(By.id("username")).sendKeys("s"+ dataFormatada);
			driver.findElement(By.id("username")).sendKeys("s17022046");
			driver.findElement(By.id("password")).clear();
			driver.findElement(By.id("password")).sendKeys("softbox123");
			driver.findElement(By.name("login")).click();
			driver.findElement(By.linkText("Projetos")).click();
			//driver.findElement(By.linkText("Projeto " + dataFormatada)).click();
			driver.findElement(By.linkText("Projeto 17022143")).click();
			driver.findElement(By.linkText("Tarefas")).click();
			driver.findElement(By.linkText("#")).click();
			driver.findElement(By.linkText("2")).click();
			String TarefaNaPosicao29 = driver.findElement(By.linkText("209246")).getText();
			driver.findElement(By.xpath("//tr[@id='issue-209246']/td[8]")).click();
			driver.findElement(By.linkText("209246")).click();
			driver.findElement(By.xpath("//div[@id='content']/h2")).click();
			assertEquals("Bug", driver.findElement(By.xpath("//div[@id='content']/h2")).getText().substring(0, 3));
			driver.findElement(By.xpath("//div[@id='content']/div[2]/table/tbody/tr/td")).click();
			assertEquals("New", driver.findElement(By.xpath("//div[@id='content']/div[2]/table/tbody/tr/td")).getText());
			driver.findElement(By.xpath("//div[@id='content']/div[2]/table/tbody/tr[2]/td")).click();
			assertEquals("Normal", driver.findElement(By.xpath("//div[@id='content']/div[2]/table/tbody/tr[2]/td")).getText());
			driver.findElement(By.xpath("//div[@id='content']/div[2]/div[2]/div/h3")).click();
			assertEquals("Título da Tarefa29", driver.findElement(By.xpath("//div[@id='content']/div[2]/div[2]/div/h3")).getText());			
			}
		}
	}*/	

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	public void leJSon() throws FileNotFoundException, IOException, ParseException {

	}
}

