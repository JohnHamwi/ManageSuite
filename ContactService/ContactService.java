import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * The ContactService class manages a list of Contact objects. It supports adding new contacts,
 * deleting contacts, and updating contact information.
 */
public class ContactService {

    private List<Contact> contactList = new ArrayList<>();

    /**
     * Generates a unique identifier for a new contact.
     * @return A unique ID string limited to 10 characters.
     */
    private String newUniqueId() {
        return UUID.randomUUID().toString().substring(0, 10);
    }

    /**
     * Adds a new contact with a unique ID to the contact list.
     */
    public void newContact() {
        contactList.add(new Contact(newUniqueId()));
    }

    /**
     * Adds a new contact with a unique ID and first name to the contact list.
     * @param firstname The first name of the new contact.
     */
    public void newContact(String firstname) {
        contactList.add(new Contact(newUniqueId(), firstname));
    }

    /**
     * Adds a new contact with a unique ID, first name, and last name to the contact list.
     * @param firstname The first name of the new contact.
     * @param lastname The last name of the new contact.
     */
    public void newContact(String firstname, String lastname) {
        contactList.add(new Contact(newUniqueId(), firstname, lastname));
    }

    /**
     * Adds a new contact with a unique ID, first name, last name, and phone number to the contact list.
     * @param firstname The first name of the new contact.
     * @param lastname The last name of the new contact.
     * @param phonenumber The phone number of the new contact.
     */
    public void newContact(String firstname, String lastname, String phonenumber) {
        contactList.add(new Contact(newUniqueId(), firstname, lastname, phonenumber));
    }

    /**
     * Adds a new contact with a unique ID, first name, last name, phone number, and address to the contact list.
     * @param firstname The first name of the new contact.
     * @param lastname The last name of the new contact.
     * @param phonenumber The phone number of the new contact.
     * @param address The address of the new contact.
     */
    public void newContact(String firstname, String lastname, String phonenumber, String address) {
        contactList.add(new Contact(newUniqueId(), firstname, lastname, phonenumber, address));
    }

    /**
     * Deletes a contact identified by the unique ID.
     * @param id The unique ID of the contact to be deleted.
     * @throws Exception if the contact cannot be found.
     */
    public void deleteContact(String id) throws Exception {
        Contact toRemove = searchForContact(id);
        if (toRemove != null) {
            contactList.remove(toRemove);
        } else {
            throw new Exception("Contact not found.");
        }
    }

    /**
     * Updates the first name of the contact identified by the unique ID.
     * @param id The unique ID of the contact.
     * @param firstName The new first name to update.
     * @throws Exception if the contact cannot be found.
     */
    public void updateFirstName(String id, String firstName) throws Exception {
        searchForContact(id).updateFirstName(firstName);
    }

    // Similar update methods for lastName, phoneNumber, and address...

    /**
     * Searches for a contact by ID.
     * @param id The unique ID of the contact.
     * @return The contact if found.
     * @throws Exception if the contact cannot be found.
     */
    private Contact searchForContact(String id) throws Exception {
        for (Contact contact : contactList) {
            if (contact.getContactId().equals(id)) {
                return contact;
            }
        }
        throw new Exception("Contact not found.");
    }

}
