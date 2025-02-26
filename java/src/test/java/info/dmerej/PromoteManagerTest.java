package info.dmerej;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.junit.UsePlaywright;
import info.dmerej.models.AddEmployee;
import info.dmerej.models.PromoteManager;
import org.junit.jupiter.api.Test;

@UsePlaywright
public class PromoteManagerTest extends Setup {
    @Test
    void PromoteManager(Page page) {
        // Given
        AddEmployee addEmployee = new AddEmployee(page);
        PromoteManager promoteManager = new PromoteManager(page, addEmployee);
        promoteManager.createEmployee("Maxime", "maxime.wang@gmail.com", "13 rue du Bronks", "Paris", "75013", "2002-05-01");

        // When
        promoteManager.navigate();
        promoteManager.promoteAsManager();

        // Then
        // Todo end with assert
    }
}
