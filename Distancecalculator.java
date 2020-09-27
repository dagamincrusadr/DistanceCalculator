import java.util.Scanner;
public class Distancecalculator {
    public static Scanner scan = new Scanner(System.in);
    static boolean calc = false;
    public static void main(String[] args) {
        Interface();
        scan.close();
        return;
        }
    public static void Interface() {
        while (calc == false) {
            System.out.println("Would you like to use Manhattan or Euclidian distance calculations?");
            switch (scan.nextLine().toLowerCase()) {
                case "euclidian":
                Euclidian();
                break;
                case "manhattan":
                Manhattan();
                break;
                default:
                System.out.println("Please enter Euclidian or Manhattan");
                break;
            }
        }
        while (calc == true) {
            System.out.println("Would you like to do another calculation?");
            switch (scan.nextLine()) {
                case "yes":
                calc = false;
                Interface();
                break;
                case "no":
                return;
                default:
                System.out.println("Please enter yes or no");
                break;
            }
        }
    }
    public static void Euclidian() {
        String p = scan.nextLine();
        String q = scan.nextLine();
        String[] parray = p.split(", ");
        String[] qarray = q.split(", ");
        Double last = 0.0;
        Double output = 0.0;
        for (int i = 0; i < parray.length; i++) {
            System.out.println(parray[i]);
            System.out.println(qarray[i]);
            output = Math.pow(Double.valueOf(parray[i]) - Double.valueOf(qarray[i]), 2);
            output += last;
            last = output;
        }
        System.out.println(Math.sqrt(output));
        calc = true;
    }
    public static void Manhattan() {
        String p = scan.nextLine();
        String q = scan.nextLine();
        String[] parray = p.split(", ");
        String[] qarray = q.split(", ");
        Double output = 0.0;
        Double save1 = 0.0;
        Double save2 = 0.0;
        Double last = 0.0;
        for (int i = 0; i < parray.length; i++) {
            save1 = Math.max(Double.valueOf(parray[i]), Double.valueOf(qarray[i]));
            save2 = Math.min(Double.valueOf(parray[i]), Double.valueOf(qarray[i]));
            output = save1 - save2;
            output += last;
            last = output;
        }
        System.out.println(output);
        calc = true;
    }
}
