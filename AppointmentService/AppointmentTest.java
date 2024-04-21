import org.junit.Test;
import java.util.Date;
import static org.junit.Assert.*;

/**
 * Tests for the Appointment class to ensure it correctly handles creation and validation of appointment objects.
 */
public class AppointmentTest {

    /**
     * Tests successful creation of an appointment object with valid inputs.
     * Verifies that the appointment ID, date, and description are correctly assigned.
     */
    @Test
    public void testAppointmentCreation() {
        // Create a future date for the appointment
        Date futureDate = new Date(System.currentTimeMillis() + 100000); // 100,000 milliseconds into the future
        
        // Create an appointment with a valid ID, future date, and non-empty description
        Appointment appointment = new Appointment("A123", futureDate, "Test Description");
        
        // Verify that the appointment properties match the expected values
        assertEquals("The appointment ID should match the one provided.", "A123", appointment.getAppointmentId());
        assertEquals("The appointment date should be the future date that was set.", futureDate, appointment.getAppointmentDate());
        assertEquals("The appointment description should match the one provided.", "Test Description", appointment.getDescription());
    }

    /**
     * Tests creation of an appointment with a date in the past.
     * Expects an IllegalArgumentException to be thrown due to the invalid date.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testAppointmentInPast() {
        // Attempt to create an appointment with a past date
        new Appointment("A123", new Date(System.currentTimeMillis() - 100000), "Test Description"); // 100,000 milliseconds in the past
    }

    /**
     * Tests creation of an appointment with an invalid (empty) description.
     * Expects an IllegalArgumentException to be thrown due to the invalid description.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidDescription() {
        // Attempt to create an appointment with an empty description
        new Appointment("A123", new Date(System.currentTimeMillis() + 100000), ""); // Future date, but empty description
    }
}
