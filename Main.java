import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        clearTerminal();

        Board b = new Board();
        System.out.println(b.toString());

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the position you want to drop your piece into: ");
        int pos = scanner.nextInt();
        scanner.nextLine();

        b.drop(pos);

        System.out.println(b.toString());

        scanner.close();


    }

    private static void clearTerminal(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    
}
