import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TaskRepository {

    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/TaskRepository";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1234";


    public TaskRepository() {
    }

    //add task + try cath
    public void addTask(Task task, int employeeId) {
        String sql = "INSERT INTO tasks(description, time_offer, employee_id) VALUES(?, ?, ?)";
        //now try catch
        try (Connection conn = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, task.getDescription());
            pstmt.setInt(2, task.getTimeOffer());
            pstmt.setInt(3, employeeId);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error adding task: " + e.getMessage());
        }
    }
    //updateTask + try cath
    public void updateTask(int taskId, Task updatedTask) {
        String sql = "UPDATE tasks SET description = ?, time_offer = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, updatedTask.getDescription());
            pstmt.setInt(2, updatedTask.getTimeOffer());
            pstmt.setInt(3, taskId);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error updating task: " + e.getMessage());
        }
    }

    //delete task + try cath
    public void deleteTask(int taskId) {
        String sql = "DELETE FROM tasks WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, taskId);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error deleting task: " + e.getMessage());
        }
    }
}