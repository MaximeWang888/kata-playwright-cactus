package info.dmerej;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.junit.UsePlaywright;

import org.junit.jupiter.api.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@UsePlaywright
public class AddNewEmployeeTest extends Setup{

    @Test
    void AddNewEmployeeTest(Page page) {
        page.navigate("https://c.lsi2.hr.dmerej.info/");
        Helper.createUser(page, "Maxime", "maxime.wang@gmail.com", "13 rue du bronks", "Paris", "75013", "2002-05-01");
        assertThat(page.locator("tbody")).containsText("Maxime");
        assertThat(page.locator("tbody")).containsText("maxime.wang@gmail.com");
        assertThat(page.locator("tbody")).containsText("no");
    }
}