package info.dmerej.models;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class PromoteManager {
    private Page page;
    private AddEmployee addEmployee;

    public PromoteManager(Page page, AddEmployee addEmployee){
        this.page = page;
        this.addEmployee = addEmployee;
    }

    public void createEmployee(String name, String email, String address, String city, String zipCode, String date){
        addEmployee.navigate();
        addEmployee.createEmployee(name, email, address, city, zipCode, date);
    }

    public void navigate() {
        page.navigate("https://c.lsi2.hr.dmerej.info/employees");
    }

    public void promoteAsManager() {
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Edit")).first().click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Promote as manager")).click();
    }
}
