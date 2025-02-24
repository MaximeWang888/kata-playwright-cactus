package info.dmerej;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.junit.UsePlaywright;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@UsePlaywright
public class UpdateAddressTest extends Setup {

    @Test
    public void updateAddress(Page page){
        page.navigate("https://c.lsi2.hr.dmerej.info/");
        Helper.createUser(page, "Maxime", "maxime.wang@gmail.com", "13 rue du Bronks", "Paris", "75013", "2002-05-01");

        page.navigate("https://c.lsi2.hr.dmerej.info/");

        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("List employees")).click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Edit")).first().click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Update address")).click();
        page.locator("#id_address_line1").fill("13 rue des tulips");
        page.locator("#id_address_line2").fill("13 rue des lilas");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Update")).click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Home")).click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("List employees")).click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Edit")).click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Update address")).click();
        assertThat(page.locator("#id_address_line1")).hasValue("13 rue des tulips");
        assertThat(page.locator("#id_address_line2")).hasValue("13 rue des lilas");
    }
}
