import java.util.ArrayList;
import java.util.Scanner;

public class Todo {
  // task list
  ArrayList<String> tasks = new ArrayList<String>();
  
  // add tasks
  static void addTask(String task, Todo obj){
    obj.tasks.add(task);
  }
  
  // remove tasks
  static void removeTask(int task, Todo obj){
    obj.tasks.remove(task-1);
  }

  // complete tasks
  static void completeTask(int task, Todo obj){
    obj.tasks.set(task-1, "COMPLETE: " + obj.tasks.get(task-1));
  }

  // print tasks
  static void printTasks(Todo obj){
    System.out.println();
    System.out.println("Tasks:");
    for (int i = 0; i < obj.tasks.size(); i++){
      System.out.printf("Task %d - %s\n", i + 1, obj.tasks.get(i));
    }
    System.out.println();
  }

  public static void main(String[] args) {
    
    try (Scanner scanObj = new Scanner(System.in)) {
      Todo myObj = new Todo();
      
      String add = "";
      int remove = 0;
      int complete = 0;
      System.out.println("Welcome to your To Do List!");
      System.out.println("Type \'add\', \'remove\', or \'complete\' to update your tasks.");
      System.out.println("Type \'quit\' to exit the application.");
      String input = scanObj.nextLine();

      while (input != "quit"){

        // if add
        if (input.equals("add")){
          System.out.println("Task to add:");
          add = scanObj.nextLine();
          Todo.addTask(add, myObj);
          Todo.printTasks(myObj);
          input = scanObj.nextLine();
        } 
        // if remove
        else if (input.equals("remove")){
          System.out.println("Task to remove (number):");
          remove = scanObj.nextInt();
          Todo.removeTask(remove, myObj);
          Todo.printTasks(myObj);
          scanObj.nextLine();
          input = scanObj.nextLine();
        } 
        // if complete
        else if (input.equals("complete")){
          System.out.println("Task to complete (number):");
          complete = scanObj.nextInt();
          Todo.completeTask(complete, myObj);
          Todo.printTasks(myObj);
          scanObj.nextLine();
          input = scanObj.nextLine();
        } 
        // if quit
        else if (input.equals("quit")){
          break;
        } 
        // else
        else {
          System.out.println("Please input a valid command.");
          input = scanObj.nextLine();
        }
      }
    }
  }
}
