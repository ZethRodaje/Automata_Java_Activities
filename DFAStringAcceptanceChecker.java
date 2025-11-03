import java.util.Scanner;

public class DFAStringAcceptanceChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input: ");
        String s = sc.nextLine();

        int state = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '0') {
                if (state == 0 || state == 1) state = 1;
                else state = 1;
            } else if (c == '1') {
                if (state == 0) state = 0;
                else if (state == 1) state = 2;
                else state = 0;
            } else {
                System.out.println("Invalid input! Only 0 and 1 allowed.");
                return;
            }
        }

        if (state == 2)
            System.out.println("Output: Accepted");
        else
            System.out.println("Output: Rejected");
        System.out.println();
        
        sc.close();
    }
}

