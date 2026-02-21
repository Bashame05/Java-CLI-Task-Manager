package taskmanagerdb;

import taskmanagerapp.STATUS;
import taskmanagerapp.Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TaskManagerDAO {
    public void addTask(Task task){
        String insertQuery = "INSERT INTO tasks(title , status) VALUES(?,?)";
        try(Connection con = DBConnection.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(insertQuery)){
            preparedStatement.setString(1, task.getTask());
            preparedStatement.setString(2,task.getStatus().name());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public boolean setStatus(int id){
        String setStatus = "UPDATE tasks SET status = ? WHERE id = ? AND status != ?";
        try(Connection con = DBConnection.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(setStatus)){
            preparedStatement.setString(1, STATUS.COMPLETED.name());
            preparedStatement.setInt(2,id);
            preparedStatement.setString(3,"COMPLETED");
            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected == 0){
                return false;
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return true;
    }
    public void viewTasks(){
        String viewQuery = "SELECT * FROM tasks;";
        try(Connection con = DBConnection.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(viewQuery)){
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String status = rs.getString("status");
                java.sql.Timestamp created_at = rs.getTimestamp("created_at");
                System.out.println(id+":"+title+" "+status+" "+created_at);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public boolean deleteTask(int id){
        String deleteQuery = "DELETE FROM tasks WHERE id = ?";
        try(Connection con = DBConnection.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(deleteQuery)){
            preparedStatement.setInt(1,id);
            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected == 0 ) {
                return false;
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return true;
    }
}
