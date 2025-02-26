package info.dmerej;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.junit.UsePlaywright;
import info.dmerej.models.AddEmployee;
import info.dmerej.models.UpdateAdress;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@UsePlaywright
public class UpdateAddressTest extends Setup {

    @Test
    public void updateAddress(Page page){
        // Given
        AddEmployee addEmployee = new AddEmployee(page);
        addEmployee.navigate();
        addEmployee.createEmployee("Maxime", "maxime.wang@gmail.com", "13 rue du Bronks", "Paris", "75013", "2002-05-01");
        UpdateAdress updateAdress = new UpdateAdress(page);
        String adress1 = "13 rue des tulips";
        String adress2 = "13 rue des lilas";

        // When
        updateAdress.updateAddress(adress1, adress2);

        // Then
        assertThat(page.locator("#id_address_line1")).hasValue(adress1);
        assertThat(page.locator("#id_address_line2")).hasValue(adress2);
    }
}
