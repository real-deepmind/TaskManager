import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("--- Task Management System Initializing ---");

        TaskRepository repository = new TaskRepository();

        System.out.println("--- adding  New Tasks ---");
        {
            try {
                repository.addTask(new Task("Implement Login Page", 8), 1);
                repository.addTask(new Task("Design Database Schema", 12), 1);
                repository.addTask(new Task("Write Unit Tests", 6), 2);
                System.out.println("3 tasks added successfully to the database");
            } catch (InvalidTaskException e) {
                System.err.println("Error add tasks " + e.getMessage());
            }
        }

        System.out.println("--- updating and deleting Tasks ---" );
        {
            try {
                Task updatedTask = new Task("type 500 pages ", 9);
                repository.updateTask(1, updatedTask);
                System.out.println("Task with  been updated successfully");


                repository.deleteTask(3);
                System.out.println("task with ID 3 deleted");
            } catch (InvalidTaskException e) {
                System.err.println("Error for delete and update: " + e.getMessage());
            }
        }

        //lambda
        System.out.println("--- use lamabda form for filter task , mine description of task from objects ,print ---");

        try {
            List<Task> taskList = new ArrayList<>();
            taskList.add(new Task("Review Code", 5));
            taskList.add(new Task("Meet with Client", 2));
            taskList.add(new Task("Refactor old module", 16));


            // filterTasks
            System.out.println("-- Filtering for long tasks more than 7 hours):--");
            List<Task> longTasks = TaskUtils.filterTasks(taskList, task -> task.getTimeOffer() > 7);
            TaskUtils.processTasks(longTasks, System.out::println);

            // mapTasks
            System.out.println("mine tasks ");
            List<String> descriptions = TaskUtils.mapTasksToStrings(taskList, Task::getDescription);
            System.out.println(descriptions);

        } catch (InvalidTaskException e) {
            System.err.println("error: " + e.getMessage());
        }

        System.out.println("** end **");
    }
}