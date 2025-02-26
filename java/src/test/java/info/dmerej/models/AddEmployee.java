package info.dmerej.models;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class AddEmployee {
    private Page page;
    
    public AddEmployee(Page page){
        this.page = page;
    }

    public void createEmployee(String name, String email, String address, String city, String zipCode, String date){
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

    public void navigate() {
        page.navigate("https://c.lsi2.hr.dmerej.info/add_employee");
    }
}
