import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for the TaskService class.
 * These tests validate the functionality of adding, deleting, and updating tasks within the service.
 */
public class TaskServiceTest {
    private TaskService service; // Instance of TaskService to be tested

    /**
     * Initializes a new TaskService instance before each test.
     * This method ensures that each test starts with a fresh instance of TaskService.
     */
    @Before
    public void setUp() {
        service = new TaskService();
    }

    /**
     * Tests the addition of a task to the service.
     * Verifies that the task is successfully added by checking the size of the task list.
     */
    @Test
    public void testAddTask() {
        Task task = new Task("1", "Task1", "Description1"); // Create a new task
        service.addTask(task); // Add the task to the service
        assertEquals("Should have 1 task after addition.", 1, service.tasks.size()); // Verify the task was added
    }

    /**
     * Tests the addition of a duplicate task to the service.
     * Expects an IllegalArgumentException to be thrown because the task ID is not unique.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testAddDuplicateTask() {
        Task task = new Task("1", "Task1", "Description1"); // Create a task
        service.addTask(task); // Add the task to the service
        service.addTask(task); // Attempt to add the same task again, should throw exception
    }

    /**
     * Tests the deletion of a task from the service.
     * Verifies that the task list is empty after the task is deleted.
     */
    @Test
    public void testDeleteTask() {
        Task task = new Task("1", "Task1", "Description1"); // Create and add a task
        service.addTask(task);
        service.deleteTask("1"); // Delete the task
        assertTrue("Task list should be empty after deletion.", service.tasks.isEmpty()); // Verify task list is empty
    }

    /**
     * Tests the deletion of a non-existent task from the service.
     * Expects an IllegalArgumentException to be thrown because the task ID does not exist.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testDeleteNonexistent() {
        service.deleteTask("nonexistent"); // Attempt to delete a task that doesn't exist, should throw exception
    }
}
