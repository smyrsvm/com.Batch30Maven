package day05;

import org.junit.Test;

public class C01_Notasyon {

    // Javadaki gibi seleniumda da belirli islevleri yapan methodlar olusturabiliriz
    //ancak bu methodlar cagirilmadikca CALISMAZLAR.
    public void ilkTestMethodu() {
        System.out.println("Ilk test methodumuz");
    }

    //JUnit ile notasyon kullanarak siradan methodlari test methoduna donusturebiliriz.
    //Bir test methodu bagimsiz olarak calisabilen test yapmamiza imkan verir
    // @Test notasyonu sayesinde main method mecburiyeti ortadan kalkar

    @Test
    public void notasyonluIlkTestMethodu() {
        System.out.println(" notasyonluIlk test methodumuz");
    }





}
