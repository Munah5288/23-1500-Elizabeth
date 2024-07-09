import java.util.Scanner;

public class ExamProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Example coursework results (out of 10)
        double[] coursework = {10, 9, 8, 7, 6};
        // Example exam result (out of 50)
        double examResult = 40;

        int choice;
        do {
            menu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewCourseworkResults(coursework);
                    break;
                case 2:
                    viewExamResults(examResult);
                    break;
                case 3:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }

            if (choice != 3) {
                if (!hasCompletedTwoThirds(coursework)) {
                    System.out.println("Student has not completed 2/3 of the coursework. Required to repeat the course irrespective of Final Exam Grade.");
                } else {
                    double totalScore = calculateTotalScore(coursework, examResult);
                    System.out.println("Total score: " + totalScore);
                }
            }

        } while (choice != 3);

        scanner.close();
    }

    private static void menu() {
        System.out.println("Menu:");
        System.out.println("1. View coursework results");
        System.out.println("2. View exam results");
        System.out.println("3. Exit the program");
    }

    private static void viewCourseworkResults(double[] coursework) {
        System.out.println("Coursework results:");
        for (int i = 0; i < coursework.length; i++) {
            System.out.println("Assessment " + (i + 1) + ": " + coursework[i]);
        }
    }

    private static void viewExamResults(double examResult) {
        System.out.println("Final exam result: " + examResult);
    }

    private static int countAssessments(double[] coursework) {
        return coursework.length;
    }

    private static boolean hasCompletedTwoThirds(double[] coursework) {
        int totalAssessments = countAssessments(coursework);
        int completedAssessments = 0;
        for (double score : coursework) {
            if (score > 0) {
                completedAssessments++;
            }
        }
        return completedAssessments >= (2.0 / 3) * totalAssessments;
    }

    private static double calculateTotalScore(double[] coursework, double examResult) {
        double courseworkScore = 0;
        for (double score : coursework) {
            courseworkScore += score;
        }
        courseworkScore = (courseworkScore / coursework.length) * 5; // Convert to percentage of 50%
        return courseworkScore + examResult;
    }
}
