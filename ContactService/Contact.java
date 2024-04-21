/**
 * The Contact class represents a contact with unique identifier and personal details.
 * It provides methods to update contact details while ensuring they meet specific criteria.
 * 
 * @author John Hamwi
 * @course CS-320
 * @date Mar 21, 2024
 */
public class Contact {

    // Constants for validation criteria
    private static final int CONTACT_PHONENUM_LENGTH = 10;
    private static final byte CONTACT_ID_LENGTH = 10;
    private static final byte CONTACT_FNAME_LENGTH = 10;
    private static final byte CONTACT_LNAME_LENGTH = 10;
    private static final byte CONTACT_ADDRESS_LENGTH = 30;
    // Initial values for default constructor
    private static final String INITIALIZER = "INITIAL";
    private static final String INITIALIZER_NUM = "1235559999";
    
    // Contact information fields
    private String contactId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;

    // Default constructor initializing with default values
    Contact() {
        this(INITIALIZER, INITIALIZER, INITIALIZER, INITIALIZER_NUM, INITIALIZER);
    }

    // Constructors for creating Contact instances with varying initial data
    Contact(String contactId) {
        this(contactId, INITIALIZER, INITIALIZER, INITIALIZER_NUM, INITIALIZER);
    }

    Contact(String contactId, String firstName) {
        this(contactId, firstName, INITIALIZER, INITIALIZER_NUM, INITIALIZER);
    }

    Contact(String contactId, String firstName, String lastName) {
        this(contactId, firstName, lastName, INITIALIZER_NUM, INITIALIZER);
    }

    Contact(String contactId, String firstName, String lastName, String phoneNumber) {
        this(contactId, firstName, lastName, phoneNumber, INITIALIZER);
    }

    // Main constructor that all other constructors call
    Contact(String contactId, String firstName, String lastName, String phoneNumber, String address) {
        updateContactId(contactId);
        updateFirstName(firstName);
        updateLastName(lastName);
        updatePhoneNumber(phoneNumber);
        updateAddress(address);
    }

    // Getters provide read access to contact fields
    public final String getContactId() { return contactId; }
    public final String getFirstName() { return firstName; }
    public final String getLastName() { return lastName; }
    public final String getPhoneNumber() { return phoneNumber; }
    public final String getAddress() { return address; }

    // Update methods apply validation rules before setting fields
    public void updateFirstName(String firstName) {
        if (firstName == null || firstName.length() > CONTACT_FNAME_LENGTH) {
            throw new IllegalArgumentException("First name must be non-null and not exceed " + CONTACT_FNAME_LENGTH + " characters");
        }
        this.firstName = firstName;
    }

    public void updateLastName(String lastName) {
        if (lastName == null || lastName.length() > CONTACT_LNAME_LENGTH) {
            throw new IllegalArgumentException("Last name must be non-null and not exceed " + CONTACT_LNAME_LENGTH + " characters");
        }
        this.lastName = lastName;
    }

    public void updatePhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.length() != CONTACT_PHONENUM_LENGTH || !phoneNumber.matches("[0-9]+")) {
            throw new IllegalArgumentException("Phone number must be non-null, exactly " + CONTACT_PHONENUM_LENGTH + " digits long, and numeric");
        }
        this.phoneNumber = phoneNumber;
    }

    public void updateAddress(String address) {
        if (address == null || address.length() > CONTACT_ADDRESS_LENGTH) {
            throw new IllegalArgumentException("Address must be non-null and not exceed " + CONTACT_ADDRESS_LENGTH + " characters");
        }
        this.address = address;
    }

    // Contact ID is set at creation and cannot be changed, thus no public update method for it
    private void updateContactId(String contactId) {
        if (contactId == null || contactId.length() > CONTACT_ID_LENGTH) {
            throw new IllegalArgumentException("Contact ID must be non-null and not exceed " + CONTACT_ID_LENGTH + " characters");
        }
        this.contactId = contactId;
    }
}
