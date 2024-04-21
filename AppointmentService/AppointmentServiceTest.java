import org.junit.Before;
import org.junit.Test;
import java.util.Date;
import static org.junit.Assert.*;

/**
 * Unit tests for the AppointmentService class.
 * Validates the addition and deletion of appointments, ensuring proper management of appointments.
 */
public class AppointmentServiceTest {
    private AppointmentService service; // Instance of AppointmentService to be tested
    private Date futureDate; // Future date to be used for creating appointments

    /**
     * Sets up the testing environment before each test.
     * Initializes a new instance of AppointmentService and calculates a future date for appointment creation.
     */
    @Before
    public void setUp() {
        service = new AppointmentService(); // Create a new instance for each test to ensure isolation
        futureDate = new Date(System.currentTimeMillis() + 100000); // Set a future date for valid appointment creation
    }

    /**
     * Tests both adding and deleting an appointment successfully.
     * Verifies that after adding an appointment, the collection size is 1, and after deleting, the collection is empty.
     */
    @Test
    public void testAddDeleteAppointment() {
        // Create and add an appointment to the service
        Appointment appointment = new Appointment("A123", futureDate, "Test Description");
        service.addAppointment(appointment);

        // Ensure the appointment was added
        assertEquals("Service should have 1 appointment after adding.", 1, service.appointments.size());
        
        // Delete the appointment and verify the service is now empty
        service.deleteAppointment("A123");
        assertTrue("Service should be empty after deleting the appointment.", service.appointments.isEmpty());
    }

    /**
     * Tests adding a duplicate appointment to the service.
     * Expects an IllegalArgumentException to be thrown because an appointment with the same ID cannot be added twice.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testAddDuplicateAppointment() {
        // Create and add an appointment to the service
        Appointment appointment = new Appointment("A123", futureDate, "Test Description");
        service.addAppointment(appointment);
        
        // Attempt to add the same appointment again, which should throw an exception due to duplicate ID
        service.addAppointment(appointment);
    }
}
