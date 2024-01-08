package investorBaseTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class InvestorBaseTest {
	
	WebDriver driver;
	
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		long startTime = System.currentTimeMillis();
		driver.get("https://www.investorbase.io/");
		long endTime = System.currentTimeMillis();
		// Calculate and print the page load time
        long pageLoadTime = endTime - startTime;
        System.out.println("Page Load Time: " + pageLoadTime + " milliseconds");
	}
	
	public void verifyHomepageElements() throws InterruptedException {
		//LOGO
		WebElement logoElement = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/a[1]/img"));
		if(logoElement.isDisplayed()) {
			System.out.println("Logo is displayed correctly");
		}
		else {
			System.out.println("Logo is not displayed correctly");
		}
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/a[1]/img")).click();
		Thread.sleep(1000);

		//NAVIGATION BAR LINKS
		WebElement navbar = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/nav/div"));
		java.util.List<WebElement> navLinks = navbar.findElements(By.tagName("a"));
		if(navLinks.isEmpty()) {
			System.out.println("No Navigation Links Found");
		}
		else {
			System.out.println("Navigation Links Found");
		}
		//1.)Features
		driver.findElement(By.xpath("//*[@id=\"w-dropdown-toggle-0\"]/div[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"w-dropdown-list-0\"]/a[1]")).click();
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"w-dropdown-toggle-0\"]/div[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"w-dropdown-list-0\"]/a[2]")).click();
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"w-dropdown-toggle-0\"]/div[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"w-dropdown-list-0\"]/a[3]")).click();
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"w-dropdown-toggle-0\"]/div[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"w-dropdown-list-0\"]/a[4]")).click();
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"w-dropdown-toggle-0\"]/div[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"w-dropdown-list-0\"]/a[5]")).click();
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(1000);
		
		//2.)Pricing
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/nav/div/a[1]/div")).click();
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(1000);
		
		//3.)Company
		driver.findElement(By.xpath("//*[@id=\"w-dropdown-toggle-1\"]/div[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"w-dropdown-list-1\"]/a[1]")).click();
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"w-dropdown-list-1\"]/a[2]")).click();
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"w-dropdown-list-1\"]/a[3]")).click();
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"w-dropdown-list-1\"]/a[4]")).click();
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"w-dropdown-list-1\"]/a[5]")).click();
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(1000);
		
		//4.)LOG-IN
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/nav/div/a[2]/button")).click();
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(1000);
		
		//5.)GET ACCESS NOW
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/nav/div/a[3]")).click();
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(1000);
		
		
		//HERO SECTION
		WebElement heroSection = driver.findElement(By.cssSelector(".hero-section"));

        // Check if the Hero section is present
        if (heroSection.isDisplayed()) {
            System.out.println("Hero section is displayed.");
        } else {
            System.out.println("Hero section is not displayed.");
        }
        
        //FEATURED CONTENT SECTION
        java.util.List<WebElement> featuredSections = driver.findElements(By.cssSelector(".featured-section"));

        // Check if Featured content sections are present
        if (!featuredSections.isEmpty()) {
            System.out.println("Featured content sections are present.");

            // Iterate through each Featured content section
            for (int i = 0; i < featuredSections.size(); i++) {
                WebElement featuredSection = featuredSections.get(i);

                // Check if the Featured content section is displayed
                if (featuredSection.isDisplayed()) {
                    System.out.println("Featured content section " + (i + 1) + " is displayed.");

                    // Check for specific elements within the Featured content section
                    WebElement title = featuredSection.findElement(By.cssSelector(".title"));
                    WebElement description = featuredSection.findElement(By.cssSelector(".description"));
                    WebElement learnMoreButton = featuredSection.findElement(By.cssSelector(".learn-more-button"));

                    // Check if the title is displayed
                    if (title.isDisplayed()) {
                        System.out.println("Title is displayed: " + title.getText());
                    } else {
                        System.out.println("Title is not displayed in section " + (i + 1) + ".");
                    }

                    // Check if the description is displayed
                    if (description.isDisplayed()) {
                        System.out.println("Description is displayed: " + description.getText());
                    } else {
                        System.out.println("Description is not displayed in section " + (i + 1) + ".");
                    }

                    // Check if the Learn More button is displayed
                    if (learnMoreButton.isDisplayed()) {
                        System.out.println("Learn More button is displayed in section " + (i + 1) + ".");
                        // Add logic to click the button and verify the expected behavior if needed
                    } else {
                        System.out.println("Learn More button is not displayed in section " + (i + 1) + ".");
                    }

                } else {
                    System.out.println("Featured content section " + (i + 1) + " is not displayed.");
                }
            }
        } else {
            System.out.println("No Featured content sections found.");
        }
        
        //SOCIAL MEDIA LINKS
        driver.findElement(By.xpath("/html/body/div[2]/div[5]/div[1]/div[1]/div[1]/div[2]/a[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[2]/div[5]/div[1]/div[1]/div[1]/div[2]/a[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[2]/div[5]/div[1]/div[1]/div[1]/div[2]/a[3]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[2]/div[5]/div[1]/div[1]/div[1]/div[2]/a[4]")).click();
        Thread.sleep(1000);
        System.out.println("Social media Links working properly");
        String mainWindowHandle = driver.getWindowHandle();
        driver.switchTo().window(mainWindowHandle);
        
        //Footer ELements
        WebElement footer = driver.findElement(By.xpath("/html/body/div[2]/div[5]/div[1]"));
        if(footer.isDisplayed()) {
        	System.out.println("Footer information is displayed correctly");
        	driver.findElement(By.xpath("/html/body/div[2]/div[5]/div[1]/div[1]/div[2]/div[1]/a[1]")).click();
        	Thread.sleep(3000);
        	driver.navigate().back();
        	Thread.sleep(1000);
        	driver.findElement(By.xpath("/html/body/div[2]/div[5]/div[1]/div[1]/div[2]/div[1]/a[2]")).click();
        	Thread.sleep(3000);
        	driver.navigate().back();
        	Thread.sleep(1000);
        	driver.findElement(By.xpath("/html/body/div[2]/div[5]/div[1]/div[1]/div[2]/div[1]/a[3]")).click();
        	Thread.sleep(3000);
        	driver.navigate().back();
        	Thread.sleep(1000);
        	driver.findElement(By.xpath("/html/body/div[2]/div[5]/div[1]/div[1]/div[2]/div[1]/a[4]")).click();
        	Thread.sleep(3000);
        	driver.navigate().back();
        	Thread.sleep(1000);
        	driver.findElement(By.xpath("/html/body/div[2]/div[5]/div[1]/div[1]/div[2]/div[1]/a[5]")).click();
        	Thread.sleep(3000);
        	driver.navigate().back();
        	Thread.sleep(1000);
        	driver.findElement(By.xpath("/html/body/div[2]/div[5]/div[1]/div[1]/div[2]/div[2]/a[1]")).click();
        	Thread.sleep(3000);
        	driver.navigate().back();
        	Thread.sleep(1000);
        	driver.findElement(By.xpath("/html/body/div[2]/div[5]/div[1]/div[1]/div[2]/div[2]/a[2]")).click();
        	Thread.sleep(3000);
        	driver.navigate().back();
        	Thread.sleep(1000);
        	driver.findElement(By.xpath("/html/body/div[2]/div[5]/div[1]/div[1]/div[2]/div[2]/a[3]")).click();
        	Thread.sleep(3000);
        	driver.navigate().back();
        	Thread.sleep(1000);
        	driver.findElement(By.xpath("/html/body/div[2]/div[5]/div[1]/div[1]/div[2]/div[2]/a[4]")).click();
        	Thread.sleep(3000);
        	driver.navigate().back();
        	Thread.sleep(1000);
        	driver.findElement(By.xpath("/html/body/div[2]/div[5]/div[1]/div[1]/div[2]/div[2]/a[5]")).click();
        	Thread.sleep(3000);
        	driver.navigate().back();
        	Thread.sleep(1000);
        	driver.findElement(By.xpath("/html/body/div[2]/div[5]/div[1]/div[2]/div[2]/a[1]")).click();
        	Thread.sleep(3000);
        	driver.navigate().back();
        	Thread.sleep(1000);
        	driver.findElement(By.xpath("/html/body/div[2]/div[5]/div[1]/div[2]/div[2]/a[2]")).click();
        	Thread.sleep(3000);
        	driver.navigate().back();
        	Thread.sleep(1000);
        	driver.findElement(By.xpath("/html/body/div[2]/div[5]/div[1]/div[2]/div[2]/a[3]")).click();
        	Thread.sleep(3000);
        	driver.navigate().back();
        	Thread.sleep(1000);
        	
        }
        else {
        	System.out.println("Footer information not displayed");
        }
	}
	
	public void verifyUserInteractions() throws InterruptedException {
		//LOG IN
		driver.findElement(By.className("user-log-in-log-out-3")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("wf-log-in-email")).sendKeys("abc@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"wf-log-in-password\"]")).sendKeys("abcdefgh");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"login-form\"]/form/div[3]/input")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("log-out-btn")).click();
		Thread.sleep(1000);
		System.out.println("Log In Successful");
		
		//Contact Form
		driver.findElement(By.xpath("//*[@id=\"w-dropdown-toggle-1\"]/div[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"w-dropdown-list-1\"]/a[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("Rishabh Patel");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("rishabhpatel3005@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"field\"]")).sendKeys("Greetings Developers");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"wf-form-contact-us\"]/input")).click();
		Thread.sleep(0);
		
		//Other Interactive Elements
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div[2]/div/a/div/svg/g/g[7]/g/path")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[5]")).click();
		Thread.sleep(1000);
		System.out.println("Interactive elements working fine");
	}
	
	public void closeBrowser() {
		driver.close();
		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {
		InvestorBaseTest obj = new InvestorBaseTest();
		obj.launchBrowser();
		obj.verifyHomepageElements();
		obj.verifyUserInteractions();
		obj.closeBrowser();
	}

}
