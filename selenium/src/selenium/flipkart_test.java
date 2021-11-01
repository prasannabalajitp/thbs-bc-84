package selenium;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//comment the above line and uncomment below line to use Chrome
import org.openqa.selenium.chrome.ChromeDriver;


/****************************************FLIPKART SITE TESTING WITH CHORME*************************************************************/


public class flipkart_test {
	 public static void main(String[] args) {
	        // declaration and instantiation of objects/variables
//	    	System.setProperty("webdriver.gecko.driver","C:\\Users\\user118\\Downloads\\geckodriver-v0.30.0-win64\\geckodriver.exe");
//	    	WebDriver driver = new FirefoxDriver();
			//comment the above 2 lines and uncomment below 2 lines to use Chrome
			System.setProperty("webdriver.chrome.driver","C:\\Users\\user118\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
	    	
//	        String baseUrl = "https://www.amazon.in/";
//	        String expectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
//	        String actualTitle = "";
	        
	        String baseUrl = "https://www.flipkart.com/";
	        String expectedTitle = "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
	        String actualTitle = "";
	 
	        // launch Google Chrome and direct it to the Base URL
	        driver.get(baseUrl);
	 
	        // get the actual value of the title
	        actualTitle = driver.getTitle();
	 
	        /*
	         * compare the actual title of the page with the expected one and print
	         * the result as "Passed" or "Failed"
	         */
	        if (actualTitle.contentEquals(expectedTitle)){
	            System.out.println("Test Passed!");
	        } else {
	            System.out.println("Test Failed");
	        }
	       
	        //close Fire fox
	        //driver.close();
	       
	    }


}
