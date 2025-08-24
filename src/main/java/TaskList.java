import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class TaskList<T extends Task> implements Iterable<T>{
    private List<T> tasks = new ArrayList<T>();

    public void addTask(T task) {
        tasks.add(task);
    }
    public List<T> filterTasksKeywordOrDescription(String keyword, String description) {
       return tasks.stream()
                .filter(task -> task.getDescription().contains(description) || task.getTitle().contains(keyword))
                .toList();
    }
    public List<T> sortTasksByDueDate() {
       return tasks.stream()
                .filter(task -> task.getDueDate() != null)
                .sorted(Comparator.comparing(Task::getDueDate).reversed())
                .toList();
    }
    public List<T> getTasksDueToday() {
       return tasks.stream()
                .filter(task -> task.getDueDate() != null)
                .filter(task -> task.getDueDate().equals(LocalDate.now()))
                .toList();
    }
    public List<T> getTasksOverdue() {
        LocalDate today = LocalDate.now();
       return tasks.stream()
                .filter(task -> task.getDueDate() != null)
                .filter(task -> task.getDueDate().isBefore(today))
                .toList();
    }
    public void printTasks(List<T> taskList) {
        taskList.forEach(System.out::println); //Calls toString() on each Task. It knows if the object is a Task or GardenTask, thus knows which toString() to call.
    }

    @Override
    public Iterator<T> iterator() {
        return tasks.iterator();
    }
}
