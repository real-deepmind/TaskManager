import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

//filter tasks and return list of filtered tasks
public class TaskUtils {
    public static  List<Task> filterTasks(List<Task> tasks , Predicate<Task> predicate) {
        List<Task> result = new ArrayList<>();
        for (Task task : tasks) {
            if (predicate.test(task)) {
                result.add(task);
            }
        }
        return result;
    }
    //

    public static List<String> mapTasksToStrings(List<Task> tasks, Function<Task, String> mapper) {
        List<String> result = new ArrayList<>();
        for (Task task : tasks) {
            String mappedItem = mapper.apply(task);
            result.add(mappedItem);
        }
        return result;
    }
    //
    public static void processTasks(List<Task> tasks, Consumer<Task> action) {
        for (Task task : tasks) {
            action.accept(task);
        }
    }
}
