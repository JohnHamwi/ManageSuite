import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This class contains unit tests for the Task class.
 * It tests the creation of Task objects and validates that the constraints on task properties are enforced.
 */
public class TaskTest {
    
    /**
     * Test the successful creation of a Task object with valid parameters.
     * Validates that the created Task object has the expected name and description.
     */
    @Test
    public void testTaskCreation() {
        // Create a new Task with valid ID, name, and description
        Task task = new Task("1", "Task Name", "Task Description");
        
        // Verify that the Task's name and description match what was passed to the constructor
        assertEquals("Task Name should be correctly set.", "Task Name", task.getName());
        assertEquals("Task Description should be correctly set.", "Task Description", task.getDescription());
    }

    /**
     * Test the creation of a Task object with an invalid task ID (null in this case).
     * Expects an IllegalArgumentException to be thrown due to the invalid ID.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidTaskId() {
        // Attempt to create a Task with a null ID, expecting an exception
        new Task(null, "Task Name", "Task Description");
    }

    /**
     * Test the creation of a Task object with an invalid task name (null in this case).
     * Expects an IllegalArgumentException to be thrown due to the invalid name.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidTaskName() {
        // Attempt to create a Task with a null name, expecting an exception
        new Task("1", null, "Task Description");
    }

    /**
     * Test the creation of a Task object with an invalid task description (null in this case).
     * Expects an IllegalArgumentException to be thrown due to the invalid description.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidTaskDescription() {
        // Attempt to create a Task with a null description, expecting an exception
        new Task("1", "Task Name", null);
    }
}
