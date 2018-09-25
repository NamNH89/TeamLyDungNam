package Excercise;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class tue_1809 {
//	1. Vào trang http://demo.guru99.com/test/newtours/register.php
//	2. Thực hiện đi�?n đầy đủ thông tin cá nhân, tạo username, password
//	3. Ở đây mn sẽ phải kiểm tra thông tin tên m đã đăng kí bước trước đúng hay chưa.
//		  -  Nếu đúng tìm link sign in ngay ở trang -> click sign in để chuyển qua trang đăng nhập.

	public static void main (String[] args) throws InterruptedException
	{
		
		// Step 1:
		System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String baseUrl = "http://demo.guru99.com/test/newtours/register.php";
		driver.get(baseUrl);
		
		// Step 2: �?ăng ký account & verify data
		sign_up(driver);
		
		// Step 3: Sign in 
		sign_in(driver);
		
	}


private static void sign_in(WebDriver driver) {
	// TODO Auto-generated method stub
	String user_name = "lynguyen3";
	String password = "123456";
	
	WebElement login_btn = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[2]/font/a"));
	login_btn.click();
	
	WebElement user_name_txt = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[1]/td[2]/input"));
	user_name_txt.sendKeys(user_name);
	
	WebElement password_txt = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td[2]/input"));
	password_txt.sendKeys(password);
	
	WebElement submit_btn = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[4]/td/input"));
	submit_btn.click();
	
}


private static void sign_up(WebDriver driver) {
	// �?ăng ký account
//	String first_name = "Ly";
//	String last_name = "Nguyen";
//	String phone = "0935252675";
//	String email = "thanhly.dn@gmail.com";
//	String address = "TRAN CAO VAN";
//	String city = "Da Nang";
	
	
	String user_name = "lynguyen3";
	String password = "123456";
//	WebElement first_name_txt = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td[2]/input"));
//	first_name_txt.sendKeys(first_name);
//	
//	WebElement last_name_txt = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[3]/td[2]/input"));
//	last_name_txt.sendKeys(last_name);
//	
//	WebElement phonenumber_txt = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[4]/td[2]/input"));
//	phonenumber_txt.sendKeys(phone);
//	
//	WebElement emailtextbox = driver.findElement(By.xpath("//*[@id=\"userName\"]"));
//	emailtextbox.sendKeys(email);
//	
//	WebElement address_txt = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[7]/td[2]/input"));
//	address_txt.sendKeys(address);
//	
//	WebElement city_txt = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[8]/td[2]/input"));
//	city_txt.sendKeys(city);
	
	WebElement user_name_txt = driver.findElement(By.id("email"));
	user_name_txt.sendKeys(user_name);
	
	WebElement password_txt = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[14]/td[2]/input"));
	password_txt.sendKeys(password);
	
	WebElement Confirm_password_txt = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[15]/td[2]/input"));
	Confirm_password_txt.sendKeys(password);
	
	WebElement sign_up_btn = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[17]/td/input"));
	sign_up_btn.click();
	
	// Kiem tra sign up thành công
	
	WebElement text = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[3]/font/b"));
	String a = (text.getText());
	
	String message = "Note: Your user name is " + user_name +".";
	System.out.println (message);
	System.out.println (a);
	
	if (a == message )
	{
		System.out.println("Sign up successfully!!!!");
	}
	else {
		System.out.println("Sign up failed!!!!");
	}
	
	
}}
	
