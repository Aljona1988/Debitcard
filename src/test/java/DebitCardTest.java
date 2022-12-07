import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;


    public class DebitCardTest {
        private WebDriver driver;


        @BeforeAll
        static void setUpAll() {
            System.setProperty("webdriver.chrome.driver", "c:\\users\\nnd_efedki\\IdeaProjects\\Debitcard\\driver\\win\\chromedriver.exe");
        }

        @BeforeEach
        void setUp() {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--no-sandbox");
            options.addArguments("--headless");
            driver = new ChromeDriver(options);
        }

        @AfterEach
        void tearDown() {
            driver.quit();
            driver = null;
        }

        @Test
        public void shouldTestBig() {
            driver.get("http://localhost:9999");
            driver.findElement(By.cssSelector("span[data-test-id=name] input")).sendKeys("Веселова Марина");
            driver.findElement(By.cssSelector("span[data-test-id=phone] input")).sendKeys("+78888888888");
            driver.findElement(By.cssSelector("label[data-test-id=agreement]")).click();
            driver.findElement(By.className("button")).click();
            String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
            String actual = driver.findElement(By.cssSelector("p[data-test-id=order-success]")).getText().trim();
            assertEquals(expected, actual);
        }



        @Test
        public void shouldTestSmall () {
            driver.get("http://localhost:9999");
            driver.findElement(By.cssSelector("span[data-test-id=name] input")).sendKeys("веселова марина");
            driver.findElement(By.cssSelector("span[data-test-id=phone] input")).sendKeys("+78888888888");
            driver.findElement(By.cssSelector("label[data-test-id=agreement]")).click();
            driver.findElement(By.className("button")).click();
            String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
            String actual = driver.findElement(By.cssSelector("p[data-test-id=order-success]")).getText().trim();
            assertEquals(expected, actual);
        }

        @Test
        public void shouldTestTwoNames () {
            driver.get("http://localhost:9999");
            driver.findElement(By.cssSelector("span[data-test-id=name] input")).sendKeys("Марина-Кристина Веселова");
            driver.findElement(By.cssSelector("span[data-test-id=phone] input")).sendKeys("+78888888888");
            driver.findElement(By.cssSelector("label[data-test-id=agreement]")).click();
            driver.findElement(By.className("button")).click();
            String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
            String actual = driver.findElement(By.cssSelector("p[data-test-id=order-success]")).getText().trim();
            assertEquals(expected, actual);
        }
    }

