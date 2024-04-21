import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests for the ContactService class.
 * These tests ensure that the ContactService correctly manages adding, updating, and deleting contacts.
 */
public class ContactServiceTest {
    private ContactService service;
    private String testContactId; // Stores the ID of a test contact for use in various tests
    private final String firstName = "John";
    private final String lastName = "Doe";
    private final String phoneNumber = "1234567890";
    private final String address = "123 Main St";

    /**
     * Setup method to initialize test environment before each test case.
     * A new instance of ContactService is created, and a default contact is added for testing.
     */
    @Before
    public void setUp() {
        service = new ContactService();
        // Add a contact to the service for testing purposes
        service.newContact(firstName, lastName, phoneNumber, address);
        // Retrieve the unique ID of the newly added contact for use in test cases
        testContactId = service.getContactList().get(0).getContactId();
    }

    /**
     * Test to verify that a new contact can be successfully added to the ContactService.
     */
    @Test
    public void testAddContact() {
        assertEquals("Should have 1 contact in the list after addition.", 1, service.getContactList().size());
    }

    /**
     * Test to verify that a contact can be successfully deleted from the ContactService using its unique ID.
     */
    @Test
    public void testDeleteContact() throws Exception {
        service.deleteContact(testContactId);
        assertTrue("Contact list should be empty after deletion.", service.getContactList().isEmpty());
    }

    /**
     * Test to verify that attempting to delete a contact that doesn't exist throws an exception.
     */
    @Test(expected = Exception.class)
    public void testDeleteNonexistentContact() throws Exception {
        service.deleteContact("nonexistent");
    }

    /**
     * Test to verify that a contact's first name can be successfully updated.
     */
    @Test
    public void testUpdateFirstName() throws Exception {
        String newFirstName = "Jane";
        service.updateFirstName(testContactId, newFirstName);
        assertEquals("Contact's first name should be updated.", newFirstName, service.getContactList().get(0).getFirstName());
    }

    /**
     * Test to verify that attempting to update the first name of a contact that doesn't exist throws an exception.
     */
    @Test(expected = Exception.class)
    public void testUpdateFirstNameNonexistentContact() throws Exception {
        service.updateFirstName("nonexistent", "NewName");
    }

    // Similar tests for lastName, phoneNumber, and address updates...
    
    /**
     * Utility method for tests (if needed) to retrieve a contact by its ID for verification purposes.
     * Note: This method assumes a specific implementation. Adjust according to your actual ContactService class.
     *
     * @param id The unique ID of the contact.
     * @return The found Contact or null if not found.
     */
    private Contact getContactById(String id) {
        return service.getContactList().stream()
                .filter(contact -> contact.getContactId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
