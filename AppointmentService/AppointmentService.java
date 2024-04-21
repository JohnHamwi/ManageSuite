import java.util.HashMap;
import java.util.Map;

/**
 * Service class for managing a collection of appointments.
 * Provides functionality to add and delete appointments using a unique ID.
 */
public class AppointmentService {
    // Collection to store appointments, using the appointment ID as the key.
    private Map<String, Appointment> appointments = new HashMap<>();

    /**
     * Adds a new appointment to the collection.
     * Validates the appointment object to ensure it's not null and the ID doesn't already exist in the collection.
     *
     * @param appointment The appointment to be added to the service.
     * @throws IllegalArgumentException if the appointment is null or an appointment with the same ID already exists.
     */
    public void addAppointment(Appointment appointment) {
        // Check if the appointment is null or already exists in the collection
        if (appointment == null || appointments.containsKey(appointment.getAppointmentId())) {
            throw new IllegalArgumentException("Appointment already exists or is null");
        }
        // Add the appointment to the collection
        appointments.put(appointment.getAppointmentId(), appointment);
    }

    /**
     * Deletes an existing appointment from the collection based on the appointment ID.
     * Validates that the appointment exists before attempting to remove it.
     *
     * @param appointmentId The unique ID of the appointment to be deleted.
     * @throws IllegalArgumentException if no appointment with the given ID exists in the collection.
     */
    public void deleteAppointment(String appointmentId) {
        // Check if the appointment does not exist in the collection
        if (!appointments.containsKey(appointmentId)) {
            throw new IllegalArgumentException("Appointment does not exist");
        }
        // Remove the appointment from the collection
        appointments.remove(appointmentId);
    }
}
