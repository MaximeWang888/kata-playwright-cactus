package info.dmerej;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class Helper {
    public static void createUser(Page page, String name, String email, String address, String city, String zipCode, String date){
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Add new employee")).click();
        page.getByPlaceholder("Name").click();
        page.getByPlaceholder("Name").fill(name);
        page.getByPlaceholder("Name").press("Tab");
        page.getByPlaceholder("Email").fill(email);
        page.getByPlaceholder("Email").press("Tab");
        page.locator("#id_address_line1").press("ArrowDown");
        page.locator("#id_address_line1").fill(address);
        page.getByPlaceholder("City").click();
        page.getByPlaceholder("City").fill(city);
        page.getByPlaceholder("City").press("Tab");
        page.getByPlaceholder("Zip code").fill(zipCode);
        page.getByPlaceholder("Hiring date").fill(date);
        page.getByPlaceholder("Job title").click();
        page.getByPlaceholder("Job title").fill("D");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).click();
    }
}
