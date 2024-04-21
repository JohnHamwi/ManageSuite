import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for the Contact class.
 * Tests validate that the Contact class correctly handles both valid and invalid input,
 * ensuring that all constraints on contact information are enforced.
 */
public class ContactTest {
    private Contact contact;
    private final String validContactId = "ID12345678";
    private final String validFirstName = "John";
    private final String validLastName = "Doe";
    private final String validPhone = "1234567890";
    private final String validAddress = "123 Main St";

    /**
     * Sets up a valid contact object before each test.
     * This method initializes the contact object with valid parameters to be used in subsequent tests.
     */
    @Before
    public void setUp() {
        contact = new Contact(validContactId, validFirstName, validLastName, validPhone, validAddress);
    }

    /**
     * Tests successful creation of a contact with valid parameters.
     * Validates that the contact's fields match the expected values provided during initialization.
     */
    @Test
    public void testContactCreationSuccess() {
        assertEquals("Expected contact ID to match.", validContactId, contact.getContactId());
        assertEquals("Expected first name to match.", validFirstName, contact.getFirstName());
        assertEquals("Expected last name to match.", validLastName, contact.getLastName());
        assertEquals("Expected phone number to match.", validPhone, contact.getPhoneNumber());
        assertEquals("Expected address to match.", validAddress, contact.getAddress());
    }

    /**
     * Tests that an IllegalArgumentException is thrown for contact IDs exceeding the maximum length.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidContactIdLength() {
        new Contact("ID1234567890", validFirstName, validLastName, validPhone, validAddress);
    }

    /**
     * Tests that an IllegalArgumentException is thrown for null contact IDs.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testNullContactId() {
        new Contact(null, validFirstName, validLastName, validPhone, validAddress);
    }

    /**
     * Tests that an IllegalArgumentException is thrown for first names exceeding the maximum length.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidFirstNameLength() {
        new Contact(validContactId, "Johnathan", validLastName, validPhone, validAddress);
    }

    /**
     * Tests that an IllegalArgumentException is thrown for null first names.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testNullFirstName() {
        new Contact(validContactId, null, validLastName, validPhone, validAddress);
    }

    /**
     * Tests that an IllegalArgumentException is thrown for last names exceeding the maximum length.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidLastNameLength() {
        new Contact(validContactId, validFirstName, "DoeDoeDoeDoe", validPhone, validAddress);
    }

    /**
     * Tests that an IllegalArgumentException is thrown for null last names.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testNullLastName() {
        new Contact(validContactId, validFirstName, null, validPhone, validAddress);
    }

    /**
     * Tests that an IllegalArgumentException is thrown for phone numbers not matching the required length.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidPhoneLength() {
        new Contact(validContactId, validFirstName, validLastName, "12345678901", validAddress);
    }

    /**
     * Tests that an IllegalArgumentException is thrown for phone numbers containing non-numeric characters.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidPhoneCharacters() {
        new Contact(validContactId, validFirstName, validLastName, "ABCDEFGHIJ", validAddress);
    }

    /**
     * Tests that an IllegalArgumentException is thrown for null phone numbers.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testNullPhone() {
        new Contact(validContactId, validFirstName, validLastName, null, validAddress);
    }

    /**
     * Tests that an IllegalArgumentException is thrown for addresses exceeding the maximum length.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidAddressLength() {
        new Contact(validContactId, validFirstName, validLastName, validPhone, "123 Main Street, Anytown, Anystate, 12345-6789");
    }

    /**
     * Tests that an IllegalArgumentException is thrown for null addresses.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testNullAddress() {
        new Contact(validContactId, validFirstName, validLastName, validPhone, null);
    }
}
