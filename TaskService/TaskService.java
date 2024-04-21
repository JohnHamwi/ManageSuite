import java.util.HashMap;
import java.util.Map;

/**
 * TaskService class manages a collection of Task objects.
 * It provides methods to add, delete, and update tasks based on their unique task IDs.
 */
public class TaskService {
    // Map to store tasks, using task ID as the key and the Task object as the value.
    private final Map<String, Task> tasks = new HashMap<>();

    /**
     * Adds a new task to the collection.
     * Validates that the task is not null and does not already exist in the collection.
     * 
     * @param task The task to be added.
     * @throws IllegalArgumentException If the task is null or already exists.
     */
    public void addTask(Task task) {
        if (task == null || tasks.containsKey(task.getTaskId())) {
            throw new IllegalArgumentException("Task already exists or is null");
        }
        tasks.put(task.getTaskId(), task);
    }

    /**
     * Deletes a task from the collection based on the given task ID.
     * Validates that the task exists before attempting to remove it.
     * 
     * @param taskId The unique ID of the task to be deleted.
     * @throws IllegalArgumentException If the task does not exist.
     */
    public void deleteTask(String taskId) {
        if (!tasks.containsKey(taskId)) {
            throw new IllegalArgumentException("Task does not exist");
        }
        tasks.remove(taskId);
    }

    /**
     * Updates the name of an existing task identified by the task ID.
     * Validates that the task exists before updating its name.
     * 
     * @param taskId The unique ID of the task to update.
     * @param name The new name to set for the task.
     * @throws IllegalArgumentException If the task does not exist.
     */
    public void updateTaskName(String taskId, String name) {
        Task task = tasks.get(taskId);
        if (task == null) {
            throw new IllegalArgumentException("Task does not exist");
        }
        task.setName(name);
    }

    /**
     * Updates the description of an existing task identified by the task ID.
     * Validates that the task exists before updating its description.
     * 
     * @param taskId The unique ID of the task to update.
     * @param description The new description to set for the task.
     * @throws IllegalArgumentException If the task does not exist.
     */
    public void updateTaskDescription(String taskId, String description) {
        Task task = tasks.get(taskId);
        if (task == null) {
            throw new IllegalArgumentException("Task does not exist");
        }
        task.setDescription(description);
    }
}
