package taskmanagerapp;

import taskmanagerdb.TaskManagerDAO;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TaskManager {
    static TaskManagerDAO dao = new TaskManagerDAO();
    static boolean isRunning=true;
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        while(isRunning){
            System.out.println("⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
            System.out.println("Welcome to Java CLI Task Manager!");
            System.out.println("1:ADD A TASK");
            System.out.println("2:VIEW TASK");
            System.out.println("3:MARK AS DONE");
            System.out.println("4:REMOVE TASK");
            System.out.println("5:EXIT");
            int choice;
            try {
                System.out.print("Select an option(1-5):");
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Enter a valid choice ");
                scanner.nextLine();
                continue;
            }

            switch(choice){
                case 1:
                    addTask();
                    break;
                case 2:
                    dao.viewTasks();
                    break;
                case 3:
                    markTask();
                    break;
                case 4:
                    deleteTask();
                    break;
                case 5:
                    isRunning = false;
                    break;
                default:
                    System.out.println("ENTER A VALID CHOICE!!!");
                    break;
            }
        }
    }
    private static void deleteTask() {
        System.out.print("Enter the id of the task you want to remove:");
        int id = scanner.nextInt();
        scanner.nextLine();
        if(dao.deleteTask(id)){
            System.out.println("Task deleted successfully");
        }else{
            System.out.println("Task not found enter correct id");
        }
    }

    private static void markTask() {
        System.out.print("Enter which number of task to mark: ");
        int id  = scanner.nextInt();
        scanner.nextLine();
        if(dao.setStatus(id)){
            System.out.println("Task marked as complete successfully");
        }else{
            System.out.println("Task already marked as completed");
        }
    }
    private static void addTask() {
        System.out.println("⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
        System.out.print("Enter your task:");
        String title = scanner.nextLine();
        Task task = new Task(title);
        dao.addTask(task);
        System.out.println("TASK ADDED");
    }
}
