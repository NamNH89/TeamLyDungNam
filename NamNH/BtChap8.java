package chapter08;

import java.awt.AWTException;
import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.sun.corba.se.spi.orbutil.fsm.Action;

public class BtChap8 {
	public static void main(String[] args) throws InterruptedException, AWTException {
    	System.setProperty("webdriver.gecko.driver", "lib/geckodriver");
		WebDriver driver = new ChromeDriver();
		String userName = "nguyen.hong.nam@framgia.com.vn";
		String passWord = "abcd1234";
		Thread.sleep(300);
		register(driver, userName,passWord);
		Thread.sleep(5000);
		login(driver, userName,passWord);
		
	}
		
	public static void register(WebDriver driver, String userName, String passWord) throws InterruptedException {
		driver.get("http://demo.guru99.com/test/newtours/register.php");
		WebElement user_name  = driver.findElement(By.name("email"));
		WebElement password = driver.findElement(By.name("password"));
		WebElement confirmPassword = driver.findElement(By.name("confirmPassword"));
		WebElement submit = driver.findElement(By.name("submit"));
		//create object of Action class
		Actions action = new Actions(driver);
		action.sendKeys(user_name, userName).sendKeys(password, passWord).sendKeys(confirmPassword, passWord).click(submit).build().perform();
		Thread.sleep(300);
		
		//select register user
		WebElement yourUser = driver.findElement(By.cssSelector("body > div:nth-child(6) > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(3) > td > p:nth-child(3) > font > b"));
		String user = yourUser.getText();
		String registerUser = "Note: Your user name is " + userName +".";
		System.out.println(user);
		if (user.equals(registerUser)){
			System.out.println("Dang ky thanh cong roi do.");
		} else {
			System.out.println("Lam lai nha.");
		}
		

	}
	public static void login(WebDriver driver, String userName, String passWord) {
		driver.get("http://demo.guru99.com/test/newtours/login.php");
		WebElement user_name  = driver.findElement(By.name("userName"));
		WebElement password = driver.findElement(By.name("password"));
		WebElement submit = driver.findElement(By.name("submit"));
		//create object of Action class
		Actions action = new Actions(driver);
		action.sendKeys(user_name, userName).sendKeys(password, passWord).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).build().perform();
	}

}
