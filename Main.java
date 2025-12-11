import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        clearTerminal();
        Scanner scanner = new Scanner(System.in);
        String quit = "";

        Board b = new Board();
        System.out.println(b.toString());

        while(!quit.equals("q")){

            System.out.println("Enter the position you want to drop your piece into: ");
            int pos = scanner.nextInt();
            scanner.nextLine();

            b.drop(pos);
            System.out.println(b.toString());

            System.out.println("Quit or keep going? ");
            quit = scanner.next();

        }

        scanner.close();


    }

    private static void clearTerminal(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    
}
