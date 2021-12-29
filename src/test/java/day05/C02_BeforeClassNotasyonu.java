package day05;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class C02_BeforeClassNotasyonu {
    // amazon sayfasina gidip 3 farkli test methodu hazirlayin
    // her method'da farkli aramalar yapalim.
    //Ayni sayfada birden fazla test yapacagim, her methoddan once sayfaya gitmeme gerk yok.
    //before class yapip sayfaya bir kere gitmem yeter.

    //JUnit te test siralamasini ongoremiyoruz.test 1, test2, test3 olmak zorunda degil siralama
    //123, 231, 321 olabilir.

    static WebDriver driver;
    WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));


    @BeforeClass
    public static void setup (){ //JUnit ozelligi olarak before class notasyonlu method  static olmak zorunda.
        //o zaman driveri bu static methodda kullanabilmem icin yukarida static yapmam gerekiyor.
        // Static kulube uye olanlar static icinde kullanilir
        //DIger test methodlarinda problem yok, onlarin static olmasina gerek yok, bunu kullanam icin
        //static her yerde gecerli, static olmayanlar icin

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com");
    }
    @Test
    public void test1(){
        searchBox.clear();
        searchBox.sendKeys("Nutella" + Keys.ENTER);
    }
    @Test
    public void test2(){
        searchBox.clear();
        searchBox.sendKeys("bycicle" + Keys.ENTER);
    }
    @Test
    public void test3(){
        searchBox.clear();
        searchBox.sendKeys("java" + Keys.ENTER);
    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    } //Bu da static olmak zorunda


}
