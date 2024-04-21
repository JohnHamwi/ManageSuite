import java.util.Date;

/**
 * Represents an appointment with a unique ID, scheduled date, and description.
 */
public class Appointment {
    // Immutable unique identifier for the appointment.
    private final String appointmentId;
    // Date and time when the appointment is scheduled. Can be updated with future dates.
    private Date appointmentDate;
    // A brief description of the appointment. Limited to 50 characters.
    private String description;

    /**
     * Constructs an Appointment object with specified ID, date, and description.
     * Validates inputs to ensure they meet the requirements: non-null, within length limits, and for dates, not in the past.
     * 
     * @param appointmentId Unique identifier for the appointment, must be non-null and not longer than 10 characters.
     * @param appointmentDate Scheduled date and time for the appointment, must be in the future and non-null.
     * @param description Brief description of the appointment, must be non-null and not longer than 50 characters.
     * @throws IllegalArgumentException If any parameter is invalid according to the validation rules.
     */
    public Appointment(String appointmentId, Date appointmentDate, String description) {
        // Validate and set the appointment ID
        if (appointmentId == null || appointmentId.length() > 10) {
            throw new IllegalArgumentException("Invalid appointment ID");
        }
        
        // Validate and set the appointment date
        if (appointmentDate == null || appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Appointment date must be in the future");
        }
        
        // Validate and set the description
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Description cannot be longer than 50 characters");
        }
        
        this.appointmentId = appointmentId;
        this.appointmentDate = appointmentDate;
        this.description = description;
    }

    /**
     * Gets the appointment's unique ID.
     * @return The unique ID of the appointment.
     */
    public String getAppointmentId() {
        return appointmentId;
    }

    /**
     * Gets the scheduled date and time of the appointment.
     * @return The appointment date.
     */
    public Date getAppointmentDate() {
        return appointmentDate;
    }

    /**
     * Gets the description of the appointment.
     * @return The description of the appointment.
     */
    public String getDescription() {
        return description;
    }
}
