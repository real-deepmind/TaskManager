import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

//filter tasks and return list of filtered tasks
public class TaskUtils {
    public List<Task> filterTasks(List<Task> tasks , Predicate<Task> predicate) {
        List<Task> result = new ArrayList<>();
        for (Task task : tasks) {
            if (predicate.test(task)) {
                result.add(task);
            }
        }
        return result;
    }
}
