package info.dmerej.models;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class UpdateAdress {
    private Page page;

    public UpdateAdress(Page page){
        this.page = page;
    }

    public void updateAddress(String adress1, String adress2) {
        page.navigate("https://c.lsi2.hr.dmerej.info/employees");
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Edit")).first().click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Update address")).click();
        page.locator("#id_address_line1").fill(adress1);
        page.locator("#id_address_line2").fill(adress2);
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Update")).click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Home")).click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("List employees")).click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Edit")).click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Update address")).click();
    }

    public void navigate(String id) {
        page.navigate("https://c.lsi2.hr.dmerej.info/employee/" + id + "/address");
    }
}
