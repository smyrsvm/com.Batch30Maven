package day06;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.sql.Driver;
import java.util.concurrent.TimeUnit;
public class C01_Assertions {
    //1) Bir class oluşturun: BestBuyAssertions
    //2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak
    // asagidaki testleri yapin
    //      ○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
    //      ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
    //      ○ logoTest => BestBuy logosunun görüntülendigini test edin
    //      ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin

    //mesajlar test failed oldugundA CIKIYOR
    static WebDriver  driver;
    @BeforeClass //bir kere calistirip bestbuya gitmem yaterli dolayisiyla beforeclass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.bestbuy.com/");
    }
    @Test
    public void urlTest(){
        //○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
        String expectedURL="https://www.bestbuy.com/";
        String actualURL= driver.getCurrentUrl();
        Assert.assertEquals("Istenen URL bulanamadi",expectedURL,actualURL);
        //assert methodlari statik oldugu icin direkt class ismi ile cagirabilirim.
        //Classismi.method ismi
        //statik olmasaydi o classdan obje olusturmam gerkirdi,cagirabilmem icin.

    }

    //titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
    @Test
    public void titleTest(){
        String istenmeyenKelime="Rest";
        String actualTitle=driver.getTitle();
        Assert.assertFalse("istenmeyen kelime title da var", actualTitle.contains(istenmeyenKelime));
        //mesajimi, testimin fail olmasi durum senaryaosuna gore yaziyorum
    }

    // ○ logoTest => BestBuy logosunun görüntülendigini test edin.
    @Test
    public void logoTest(){
        WebElement logo = driver.findElement(By.xpath("(//img[@class= 'logo'])[1]"));
        Assert.assertTrue("Logo gorunmuyor", logo.isDisplayed());
    }

    //○ FrancaisLinkTest => Fransizca linkinin görüntülendiğini test edin
    @Test
    public void fransizcaTesti(){
        WebElement fransizcaLinki=driver.findElement(By.xpath("//button[text()='Français']"));
        Assert.assertTrue("Fransizca linki gorunmuyor",fransizcaLinki.isDisplayed());
    }

    @AfterClass
    public static void tearDown(){

        driver.close();
    }
}