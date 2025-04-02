import java.util.Arrays;
import java.util.Scanner;

public class todo_list {
    public static void main(String[] args) {
        String[] tasks = {};
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter your choice:\n1.Add new task \n2.Update task \n3.Delete task \n4.Exit");
        int num = myObj.nextInt();
        myObj.nextLine();
        while (num != 4) {
            switch (num) {
                case 1 -> {
                    System.out.println("Enter the task: ");
                    String task = myObj.nextLine();
                    tasks = arrayCopy(tasks, task);
                    System.out.println(Arrays.toString(tasks));
                }
                case 2 -> {
                    int j = 1;
                    for (String i: tasks) {
                        System.out.print(j + ". " + i + ",\n");
                        j++;
                    }
                    System.out.println("\nWhich task would you like to update?");
                    int updNum = myObj.nextInt();
                    myObj.nextLine();
                    System.out.println("Enter the task: ");
                    String task = myObj.nextLine();
                    tasks = arrayUpdate(tasks, updNum, task);
                    System.out.println();
                }
                case 3 -> {
                    int k = 1;
                    for (String i: tasks) {
                        System.out.print(k + ". " +  i + ",\n");
                        k++;
                    }
                    System.out.println();
                    int delNum = myObj.nextInt();
                    myObj.nextLine();
                    tasks = arrayDel(tasks, delNum);
                }
                    
                default -> System.out.println();
            }
            System.out.println("Current Tasks:");
            for (String i: tasks) {
                System.out.println("> " + i);
            }
            System.out.println("\nEnter your choice: \n1.Add new task \n2.Update task \n3.Delete task \n4.Exit");
            num = myObj.nextInt();
            myObj.nextLine();
        }
    }

    public static String[] arrayCopy(String[] arr, String task) {
        String[] newarr = new String[arr.length + 1];
        System.arraycopy(arr, 0, newarr, 0, arr.length);
        newarr[newarr.length - 1] = task;
        return newarr;
    }

    public static String[] arrayUpdate(String[] arr, int num, String task) {
        num -= 1;
        if (num < 0 || num >= arr.length) {
            System.out.print("Invalid Index");
            return arr;
        }
        arr[num] = task;
        return arr;
    }
    @SuppressWarnings("UnnecessaryContinue")
    public static String[] arrayDel(String[] arr, int num) {
        num -= 1;
        if (num < 0 || num >= arr.length) {
            System.out.print("Invalid Index");
            return arr;
        }
        String[] newarr = new String[arr.length - 1];
        int index = 0;
        for (int i = 0; i <= newarr.length; i++){
            if (i == num) {
                continue;
            } else {
                System.out.print(arr[i]);
                newarr[index++] = arr[i];
            }

        }
        return newarr;
    }
}