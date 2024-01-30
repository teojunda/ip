package duke;

import duke.tasks.Task;
import duke.tasks.TodoTask;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskListTest {
    @Test
    public void testAddTask() {
        TaskList taskList = new TaskList();
        Task task = new TodoTask("Sample Task");
        taskList.add(task);
        assertEquals(1, taskList.size());
        assertEquals(task, taskList.get(0));
    }

    @Test
    public void testRemoveTask() {
        TaskList taskList = new TaskList();
        Task task = new TodoTask("Sample Task");
        taskList.add(task);
        assertEquals(1, taskList.size());
        Task removedTask = taskList.remove(0);
        assertEquals(0, taskList.size());
        assertEquals(task, removedTask);
    }

    @Test
    public void testListTasksEmpty() {
        TaskList taskList = new TaskList();
        String result = taskList.listTasks();
        assertEquals("There are no tasks currently :)", result);
    }

    @Test
    public void testListTasksNotEmpty() {
        TaskList taskList = new TaskList();
        Task t1 = new TodoTask("Task 1");
        Task t2 = new TodoTask("Task 2");
        taskList.add(t1);
        taskList.add(t2);
        String result = taskList.listTasks();
        assertEquals("Here are the tasks in your list:\n1. " + t1.toString() +
                "\n2. " + t2.toString() + "\n" + TextTemplate.LINE_BREAK, result);
    }

    @Test
    public void testMarkTask() {
        TaskList taskList = new TaskList();
        Task task = new TodoTask("Sample Task");
        taskList.add(task);
        Task markedTask = taskList.markTask(0);
        assertTrue(markedTask.isDone());
    }
}