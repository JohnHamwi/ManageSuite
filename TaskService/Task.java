/**
 * Represents a task in the task management system.
 * Each task has a unique ID, a name, and a description.
 */
public class Task {
    // Unique identifier for the task; it's immutable after task creation.
    private final String taskId;
    // Name of the task, subject to validation.
    private String name;
    // Detailed description of the task, subject to validation.
    private String description;

    /**
     * Constructs a new Task instance with specified ID, name, and description.
     * Validates the input parameters to ensure they meet the specified criteria.
     * 
     * @param taskId Unique identifier for the task, cannot be null or longer than 10 characters.
     * @param name Name of the task, cannot be null or longer than 20 characters.
     * @param description Description of the task, cannot be null or longer than 50 characters.
     * @throws IllegalArgumentException If any parameter is invalid.
     */
    public Task(String taskId, String name, String description) {
        // Validate and initialize task ID.
        if (taskId == null || taskId.length() > 10) {
            throw new IllegalArgumentException("Invalid task ID");
        }
        // Validate and initialize name.
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Invalid name");
        }
        // Validate and initialize description.
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid description");
        }
        this.taskId = taskId;
        this.name = name;
        this.description = description;
    }

    /**
     * Returns the task's unique ID.
     * @return The task's ID.
     */
    public String getTaskId() {
        return taskId;
    }

    /**
     * Returns the task's name.
     * @return The name of the task.
     */
    public String getName() {
        return name;
    }

    /**
     * Updates the task's name after validating the new name.
     * @param name The new name for the task, must meet validation criteria.
     * @throws IllegalArgumentException If the new name is invalid.
     */
    public void setName(String name) {
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Invalid name");
        }
        this.name = name;
    }

    /**
     * Returns the task's description.
     * @return The description of the task.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Updates the task's description after validating the new description.
     * @param description The new description for the task, must meet validation criteria.
     * @throws IllegalArgumentException If the new description is invalid.
     */
    public void setDescription(String description) {
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid description");
        }
        this.description = description;
    }
}
