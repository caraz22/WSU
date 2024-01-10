//import java.util.Arrays;

public class TwoDimensionalArrays {
    
    public static void print2DArr(int[][] arr) {
        for (int i=0; i<arr.length; i++) {
            for (int j=0; j<arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t"); //"\t" = tab
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        
        //int[rows][columns]
        int[][] grades = new int[5][4];
        
        //nested loops used a lot for 2D arrays
        for (int i=0; i<grades.length; i++) {
            for (int j=0; j<grades[i].length; j++) {
                grades[i][j] = (int) (Math.random() * 100) + 1;
            }
        }

        //print2DArr(grades);
        
        //find the grade of each student in the class
        for (int i=0; i<grades.length; i++) {
            double grade = 0;   
            for (int j=0; j<grades[i].length; j++) {
                System.out.print(grades[i][j] + "\t");
                grade += grades[i][j];
            }     
            System.out.println("-> " + grade/4);
        }       

        System.out.println();

        //find the average grade on each project
        for (int i=0; i<grades[0].length; i++) {
            double project = 0;
            for (int j=0; j<grades.length; j++) {
                System.out.print(grades[j][i] + "\t");
                project += grades[j][i];
            }
            System.out.println();
            System.out.println("project avg: " + (project/grades[0].length));
        }
    }

}
