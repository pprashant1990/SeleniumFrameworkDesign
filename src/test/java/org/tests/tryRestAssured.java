package org.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.time.Duration;
import java.util.List;

import static io.restassured.RestAssured.given;

public class tryRestAssured {

    public static void main(String[] args) {
        // TODO Auto-generated method stub


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        Assert.assertEquals("Practice Page", driver.getTitle());
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2000)");

        List<WebElement> link1 = driver.findElements(By.xpath("//div[@id='gf-BIG']/table/tbody/tr/td[1]/ul/li/a"));
/*
        for (int i = 1; i < link1.size(); i++) {
            String links = link1.get(i).getAttribute("href");
            System.out.println(links);
            //String links = "https://rahulshettyacademy.com/brokenlink";
            Response response = RestAssured.given().when().head(links).then().extract().response();
            int statusCode = response.getStatusCode();
            System.out.println(statusCode);
            if (statusCode == 404){
                System.out.println("Found Broken link: " + links);
            } else {
                System.out.println("Fine Links " + links);
            }

        }
*/
        RequestSpecification reqspec = new RequestSpecBuilder().build();
        RequestSpecification reqspec1 = given().spec(reqspec);

        Response response = reqspec1.when().head("https://rahulshettyacademy.com/brokenlink").then().extract().response();
        //int statusCode = response.getStatusCode();
        System.out.println(response.getStatusCode());
        System.out.println(response.getContentType());
        System.out.println(response.getHeaders());
        System.out.println(response.getStatusLine());



        driver.quit();


		/*
		LandingPage landingPage = new LandingPage(driver);
		driver.findElement(By.id("userEmail")).sendKeys("pprashant1990@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("pD@24101990");
		driver.findElement(By.id("login")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

		WebElement prod = products.stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst()
				.orElse(null);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		// ng-animating
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();

		List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean match = cartProducts.stream()
				.anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
		Assert.assertTrue(match);
		driver.findElement(By.cssSelector(".totalRow button")).click();

		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));

		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
		a.moveToElement(driver.findElement(By.cssSelector("a[class*='submit']"))).click().build().perform();

		String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		driver.close();*/

    }

}
