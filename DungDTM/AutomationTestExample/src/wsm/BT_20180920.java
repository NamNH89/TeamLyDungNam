package wsm;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BT_20180920 {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String baseUrl = "http://demo.guru99.com/test/newtours/register.php";
		driver.get(baseUrl);
		signUp(driver);
		signIn(driver);

	}

	private static void signIn(WebDriver driver) {
		String userName = "dungmii2";
		String password = "Abc12345";

		WebElement loginBtnElement = driver.findElement(By.xpath(
				"/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[2]/font/a"));
		loginBtnElement.click();

		WebElement userNameElement = driver.findElement(By.xpath(
				"/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[1]/td[2]/input"));
		Actions input = new Actions(driver);
		input.sendKeys(userNameElement, userName).sendKeys(Keys.TAB).build().perform();

		WebElement passwordElement = driver.findElement(By.xpath(
				"/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td[2]/input"));
		Actions input1 = new Actions(driver);
		input1.sendKeys(passwordElement, password).sendKeys(Keys.TAB).build().perform();

		WebElement submitBtnElement = driver.findElement(By.xpath(
				"/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[4]/td/input"));
		submitBtnElement.click();

		System.out.println("Login successfully!");
	}

	private static void signUp(WebDriver driver) {
		String userName = "dungmii2";
		String password = "Abc12345";

		WebElement userNameElement = driver.findElement(By.id("email"));
		Actions input = new Actions(driver);
		input.sendKeys(userNameElement, userName).sendKeys(Keys.TAB).build().perform();

		WebElement passwordElement = driver.findElement(By.xpath(
				"/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[14]/td[2]/input"));
		Actions input1 = new Actions(driver);
		input1.sendKeys(passwordElement, password).sendKeys(Keys.TAB).build().perform();

		WebElement ConfirmPasswordElement = driver.findElement(By.xpath(
				"/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[15]/td[2]/input"));
		Actions input2 = new Actions(driver);
		input2.sendKeys(ConfirmPasswordElement, password).sendKeys(Keys.TAB).build().perform();

		WebElement signUpBtnElement = driver.findElement(By.xpath(
				"/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[17]/td/input"));
		Actions hover = new Actions(driver);
		Actions mouseOver = hover.moveToElement(signUpBtnElement);
		mouseOver.perform();

		signUpBtnElement.click();

		WebElement text = driver.findElement(By.xpath(
				"/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[3]/font/b"));
		String note = (text.getText());

		String message = "Note: Your user name is " + userName + ".";
		System.out.println("Message: " + message);
		System.out.println("Message returned: " + note);

		if (message.equals(note)) {
			System.out.println("Sign up successfully!");
		} else {
			System.out.println("Sign up failed!");
		}
	}

}
