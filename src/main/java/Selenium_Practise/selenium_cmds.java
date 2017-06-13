package Selenium_Practise;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by Jyothi on 09/05/2017.
 */
public class selenium_cmds {

    public static WebDriver driver;

    public static void main(String args[]) {
        driver=new FirefoxDriver();
        driver.get("https://www.youtube.com/");
        driver.findElement(By.id("search-btn")).sendKeys("Testing videos");
        driver.findElement(By.id("search-btn")).click();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

        //Accept alert or dismiss alert
        driver.switchTo().alert().accept();
        driver.switchTo().alert().dismiss();

        //Get the text of the alert
        Alert text = driver.switchTo().alert();
        System.out.println(text.getText());

        //select the frame
        //If an element comes under iframe we can't click straight way.
        //So we need to switch the frame by id or class
        driver.switchTo().frame(0);//based on index
        driver.switchTo().frame("tsets"); //based on name
        driver.switchTo().frame(driver.findElement(By.xpath("ffhvb")));

        //Window handling methods
        driver.getWindowHandle(); //gives parent window id
        Set<String> allwindows = driver.getWindowHandles(); //will give all the list of windows opened on UI
        //Return type is set of string because it gives unique names of windows.
        //Return type list gives duplicate names/values

        //how to move from the parent window to childwindow or viceversa
        Iterator<String> allwindow = allwindows.iterator();
        String parentwindow;
        allwindow.next();
        driver.switchTo().window("parentwindow");
        String Childwindow = allwindow.next();
        driver.switchTo().window(Childwindow);
        //which moves from child window to parent window
        driver.switchTo().defaultContent();

        //Implicit and Explicit waits

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //Implicit wait which applicable for the whole page

        //Explicit wait is a Webdriver wait
        WebDriverWait wait = new WebDriverWait(driver, 30);
        Select sel = new Select(driver.findElement(By.xpath("")));
        List<WebElement> elements = sel.getAllSelectedOptions();
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("df")));

        //How to select data from the drop down

        Select sel2 = new Select(driver.findElement(By.xpath("")));
        sel2.selectByIndex(2);
        sel2.selectByValue("g");
        sel2.selectByVisibleText("XYZ");

        List<WebElement> list_elements = sel2.getOptions();

        //Mouse over in selenium
        Actions act = new Actions(driver);
        act.moveToElement(driver.findElement(By.xpath(""))).build().perform();

        //Drag&Drop
        Actions act2 = new Actions(driver);
        act2.dragAndDrop(driver.findElement(By.xpath("")), driver.findElement(By.xpath("")));
        //How to get screenshot in selenium
        //We should casting
        File srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        //FileUtils.copyFile("C:\\Users\\Jyothi\\IdeaProjects\\Selenium_cmds\\src\\main\\java\\Selenium_Practise\\abc.txt","C:\\Users\\Jyothi\\IdeaProjects");
        //FileUtils.copyFile("C:\\Users\\Jyothi\\IdeaProjects\\Selenium_cmds\\src\\main\\java\\Selenium_Practise\\abc",
        //                 new File("C:\\Users\\Jyothi\\IdeaProjects"));


        //How to get coordinate of a window
        driver.manage().window().getPosition().getX();
        driver.manage().window().getPosition().getY();
        //Point is an interface in selenium
        Point position = driver.manage().window().getPosition();
        position.getY();
        position.getY();
        //Navigations
        driver.navigate().forward();
        driver.navigate().back();
        driver.navigate().refresh();

        //How to get URl of the current webpage
        String current_url = driver.getCurrentUrl();
        String title = driver.getTitle();

        //How can u count similar objects present in the UI
        int size = driver.findElements(By.xpath("")).size();

        //How to count 5th element from similar kind of elements
        driver.findElements(By.xpath("")).get(5);

        //Checkbox
        driver.findElement(By.xpath("")).isDisplayed();
        driver.findElement(By.xpath("")).isEnabled();
        driver.findElement(By.xpath("")).isSelected();


    }
}