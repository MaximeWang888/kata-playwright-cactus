package info.dmerej;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.junit.UsePlaywright;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.BeforeEach;

@UsePlaywright
public class Setup {

    @BeforeEach
    public void beforeEach(Page page) {
        System.out.println("Setup passed and database is reset.");
        page.navigate("https://c.lsi2.hr.dmerej.info/");
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Reset database")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Proceed")).click();
    }
}
