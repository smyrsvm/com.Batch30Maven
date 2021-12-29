package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Test01 {

    //1-Test01 isimli bir class olusturun
    //2- https://www.amazon.com/ adresine gidin
    //3- Browseri tam sayfa yapin
    //4-Sayfayi "refresh" yapin
    //5- Sayfa basliginin "Amazon" ifadesi icerdigini control edin
    //6-Sayfa basliginin "Amazon.com. Spend less. Smile more." a esit oldugunu control ediniz
    //7- URL in amazon.com icerdigini control edin
    //8-"Nutella" icin arama yapiniz byid "twotabsearchtextbox"
    //9- Kac sonuc bulundugunu yaziniz
    //10-Sayfayi kapatin

    WebDriver driver;


    @Before
    public void setup (){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void test(){

        //3- Browseri tam sayfa yapin----yukarida yapildi

        //4-Sayfayi "refresh" yapin
        driver.navigate().refresh();
        //5- Sayfa basliginin "Amazon" ifadesi icerdigini control edin

        String expectedTitleContent= "Amazon";
        String actualTitleContent=driver.getTitle();
        if (actualTitleContent.contains(expectedTitleContent)){
            System.out.println("Test Passed");

        }else {
            System.out.println("Test FAILED");
        }
    }

    @Test
    public void test2 (){
        //6-Sayfa basliginin "Amazon.com. Spend less. Smile more." a esit oldugunu control ediniz

        String expectedTitle= "Amazon.com. Spend less. Smile more.";
        String actualTitle=driver.getTitle();
        if (actualTitle.contains(expectedTitle)){
            System.out.println("Test Passed");

        }else {
            System.out.println("Test FAILED");
        }
    }

    @Test
    public void test3 (){
        //7- URL in amazon.com icerdigini control edin

        String expectedUrlContent = "amazon.com";
        String actualUrlContent= driver.getCurrentUrl();

        /*if (actualUrlContent.contains(expectedUrlContent)){




        }*/




    }





        //8-"Nutella" icin arama yapiniz byid "twotabsearchtextbox"
        //9- Kac sonuc bulundugunu yaziniz
        //10-Sayfayi kapatin











}
