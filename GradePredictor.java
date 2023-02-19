import java.util.Scanner;

// import javax.swing.text.html.StyleSheet;

public class GradePredictor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1.Show Full result");
        System.out.println("2.Grade on Specific Marks");
        System.out.println("3.GradePoint on Specific Marks");
        System.out.println("4.Minumum marks for Specific Grade");
        System.out.print("Select the options: ");
        int option = sc.nextInt();
        switch (option) {
            case 1:
                   System.out.print("enter the number of subject: ");
                   int noOfSubject = sc.nextInt();
                       System.out.println();
                       System.out.println();
                       String[] subject = new String[noOfSubject];
                       int[] marks = new int[noOfSubject];
                       int[] credits = new int[noOfSubject];
                       for (int i = 0; i < noOfSubject; i++) {
                           System.out.print("enter the name of Subject-" + (i + 1) + ": ");
                           subject[i] = sc.next();
                           System.out.print("enter the subject " + subject[i] + " marks: ");
                           marks[i] = sc.nextInt();
                           System.out.print("enter the subject " + subject[i] + " Credit: ");
                           credits[i] = sc.nextInt();
                           System.out.println();
                           System.out.println();
                           System.out.println();

                       }
                    ShowResult(subject, marks, credits);
                    break;
            case 2:
                   System.out.print("Enter the marks: ");
                   System.out.printf("Your Grade is: " + Grade(sc.nextInt()));
                   break;
            case 3:
                   System.out.print("Enter the Grade: ");
                   System.out.printf("Your GradePoint is: " + GradePoint(sc.next()));
                   break;
            case 4:
                   System.out.print("enter the Grade: ");
                   System.out.print("Minimum Marks You need: " + MinimunMarks(sc.next()));
                   break;
                
            default:
                    System.out.println("Wrong Option Selected");
                
            }
            sc.close();
    }

    public static int MinimunMarks(String b) {
        switch (b) {
            case "O":
                return 90;
            case "A+":
                return 80;
            case "A":
                return 70;
            case "B+":
                return 60;
            case "B":
                return 50;
            case "C":
                return 40;
            default:
                return 0;

        }
    }

    public static void ShowResult(String[] s, int[] m, int[] c) {
        double sumOfCreditGot = 0;
        double sumOfTotalCredit = 0;
        System.out.println("Subject      Marks        Grade       Grade Point       Credit      CreditGot/TotalCredit");
        for (int i = 0; i < s.length; i++) {
            System.out.println(
                    s[i] + "         " + m[i] + "           " + Grade(m[i]) + "             " + GradePoint(Grade(m[i]))
                            + "              " + c[i] + "                " + (c[i] * GradePoint(Grade(m[i]))) + "/"
                            + c[i] * 10);
            sumOfCreditGot = sumOfCreditGot + (c[i] * GradePoint(Grade(m[i])));
            sumOfTotalCredit = sumOfTotalCredit + c[i] * 10;
        }
        double cgpa = (sumOfCreditGot / sumOfTotalCredit) * 100;

        System.out.println("CGPA: " + String.format("%.2f", cgpa));

    }

    public static String Grade(int m) {
        int k = m / 10;
        switch (k) {
            case 10:
                return "O";
            case 9:
                return "O";

            case 8:
                return "A+";
            case 7:
                return "A";
            case 6:
                return "B+";
            case 5:
                return "B";
            case 4:
                return "C";
            default:
                return "Fail";
        }
    }

    public static int GradePoint(String x) {

        switch (x) {
            case "O":
                return 10;
            case "A+":
                return 9;
            case "A":
                return 8;
            case "B+":
                return 7;
            case "B":
                return 6;
            case "C":
                return 5;
            default:
                return 0;
        }
    }
}
