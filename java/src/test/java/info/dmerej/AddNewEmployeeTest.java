package info.dmerej;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.junit.UsePlaywright;
import com.microsoft.playwright.options.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@UsePlaywright
public class AddNewEmployeeTest extends Setup{

    @Test
    void AddNewEmployeeTest(Page page) {
        page.navigate("https://c.lsi2.hr.dmerej.info/");
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Reset database")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Proceed")).click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Add new employee")).click();
        page.getByPlaceholder("Name").click();
        page.getByPlaceholder("Name").fill("Maxime");
        page.getByPlaceholder("Name").press("Tab");
        page.getByPlaceholder("Email").fill("maxime.wang@efrei.net");
        page.getByPlaceholder("Email").press("Tab");
        page.locator("#id_address_line1").press("ArrowDown");
        page.locator("#id_address_line1").fill("13 rue de Chinatown");
        page.getByPlaceholder("City").click();
        page.getByPlaceholder("City").fill("Paris");
        page.getByPlaceholder("City").press("Tab");
        page.getByPlaceholder("Zip code").fill("75013");
        page.getByPlaceholder("Hiring date").fill("2002-05-01");
        page.getByPlaceholder("Job title").click();
        page.getByPlaceholder("Job title").fill("D");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
        assertThat(page.locator("tbody")).containsText("Maxime");
        assertThat(page.locator("tbody")).containsText("maxime.wang@efrei.net");
        assertThat(page.locator("tbody")).containsText("no");
    }
}