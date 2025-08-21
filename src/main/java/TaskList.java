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
        taskList.forEach(task -> System.out.println(task.getTitle() + " - " + task.getDescription() + " - " + task.getDueDate()));
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
