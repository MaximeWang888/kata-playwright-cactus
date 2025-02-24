package info.dmerej;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.junit.UsePlaywright;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;

@UsePlaywright
public class ResetManagerTest extends Setup {
    @Test
    void ResetManager(Page page) {
        page.navigate("https://c.lsi2.hr.dmerej.info/");
        Helper.createUser(page, "Maxime", "maxime.wang@gmail.com", "13 rue du bronks", "Paris", "75013", "2002-05-01");
        page.navigate("https://c.lsi2.hr.dmerej.info/");

        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Home")).click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("List employees")).click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Edit")).first().click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Promote as manager")).click();
        // Todo end with assert

    }
}
