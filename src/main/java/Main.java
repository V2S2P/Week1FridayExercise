import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TaskList<Task> taskList = new TaskList<>();

        LocalDate yesterday = LocalDate.now().minusDays(1);
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plusDays(1);


        Task task = new Task("Buy milk", "Buy 10KG milk", today);
        Task task2 = new Task("Buy groceries", "Milk, bread, eggs", today);
        Task task3 = new Task("Finish report", "Complete the finance report", tomorrow);

        GardenTask gardenTask = new GardenTask("Mow Lawn","The lawn needs mowing", yesterday);
        gardenTask.setGardenLocation("The Lawn");

        taskList.addTask(task);
        taskList.addTask(task2);
        taskList.addTask(task3);
        taskList.addTask(gardenTask);

        System.out.println("Due Today Tasks: ");
        taskList.printTasks(taskList.getTasksDueToday());

        System.out.println("\nOverdue Tasks: ");
        taskList.printTasks(taskList.getTasksOverdue());

        System.out.println("\nSorted Tasks By Due Date");
        taskList.printTasks(taskList.sortTasksByDueDate());

        System.out.println("\nFilter Tasks By Keyword Or Description");
        taskList.printTasks(taskList.filterTasksKeywordOrDescription("Buy", "mowing"));

    }
}
