import java.util.Scanner;


public class ans {
    public static void main(String[] args){
        // let user enter the total number of assignment in this course
        System.out.println("Please enter the total number of assignments: ");
        Scanner scanner1 = new Scanner(System.in);
        int total = scanner1.nextInt();

        if (total <= 0) {
            System.out.println("The total number of assignments should larger than 0, please try again");
            return;
        }

        System.out.println();

        // let user enter the full mark of each assignment assigned in this course
        double[] points = new double[total];
        for(int i = 0; i < total; i++) {
            System.out.printf("Please enter the total points of assignment %d\n", i + 1);
            Scanner scanner2 = new Scanner(System.in);
            double point = scanner2.nextDouble();

            if (point <= 0) {
                System.out.println("The full mark of assignment should larger than 0, please try again");
                return;
            }

            points[i] = point;
        }
        System.out.println();

        // let user assign each assignment's weight
        double[] weights = new double[total];
        double judge_weights = 0;
        for(int i = 0; i < total; i++) {
            System.out.printf("Please enter the weight of assignment %d\n", i + 1);
            Scanner scanner3 = new Scanner(System.in);
            double weight = scanner3.nextDouble();

            if (weight < 0) {
                System.out.println("The weight of assignment should larger than or equal to 0, please try again");
                return;
            }

            weights[i] = weight;
            judge_weights += weight;
        }
        System.out.println();

        // total weight should be 100
        if (judge_weights == 100) {
            double grade = 0;
            double[] studentsGrades = new double[total]; // access the student's grade of each assignment
            for(int i = 0; i < total; i++) {
                System.out.printf("Please enter the student's points of assignment %d\n", i + 1);
                Scanner scanner4 = new Scanner(System.in);
                double studentGrade = scanner4.nextDouble();

                if (studentGrade < 0) {
                    System.out.println("The student grade should larger than or equal to 0, please try again");
                    return;
                }

                // student's grade of each assignment should less than or equal to the full mark
                if (studentGrade <= points[i]) {
                    grade += weights[i] * studentGrade / points[i];
                    studentsGrades[i] = studentGrade;
                }
                else{
                    System.out.println("The student grade is larger than total grade of this assignment, please try again");
                    return;
                }
            }
            System.out.println();
            System.out.printf("The total grade of this student is %f", grade);
        }
        else
            System.out.println("The total weight not equal to 100, please check again");
    }
}
