/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package quotes;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {

@Test public void randomQuoteTest(){
    App app = new App();
    String quote = app.randomQuote("src/test/resources/recentquotes.json");
    System.out.println(quote);
    assertTrue(quote !=null);
}

}
