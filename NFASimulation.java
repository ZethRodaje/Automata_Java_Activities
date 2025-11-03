package cst4;
import java.util.Scanner;

public class NFASimulation {

    static boolean simulate(String input, int index, String state) {
        if (index == input.length())
            return state.equals("q2"); 

        char c = input.charAt(index);

        if (state.equals("q0")) {
            if (c == 'a') return simulate(input, index + 1, "q0") || simulate(input, index + 1, "q1");
            if (c == 'b') return simulate(input, index + 1, "q0");
        } 
        else if (state.equals("q1")) {
            if (c == 'a') return simulate(input, index + 1, "q1");
            if (c == 'b') return simulate(input, index + 1, "q2");
        } 
        else if (state.equals("q2")) {
            return simulate(input, index + 1, "q2");
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input: ");
        String input = sc.nextLine();

        boolean accepted = simulate(input, 0, "q0");

        if (accepted)
            System.out.println("Output: Accepted");
        else
            System.out.println("Output: Rejected");
        sc.close();
    }
}
