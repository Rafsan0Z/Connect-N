import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        clearTerminal();
        Scanner scanner = new Scanner(System.in);
        String quit = "";

        String p1 = "Player 1";
        String p2 = "Player 2";

        int turn = 0;

        char face = 'p';
        Board b = new Board();
        System.out.println(b.toString());

        while(!quit.equals("q")){

            clearTerminal();

            if(turn == 0){
                System.out.println("--------");
                face = 'O';
            }
            else if (turn == 1){
                System.out.println("             --------");
                face = 'B';
            }
            System.out.println(p1 + "     " + p2);
            System.out.println(b.toString());

            System.out.println("Enter the position you want to drop your piece into: ");
            int pos = scanner.nextInt();
            scanner.nextLine();

            b.drop(pos,face);
            System.out.println(b.toString());

            System.out.println("Quit or keep going? ");
            quit = scanner.next();

            turn = (turn + 1) % 2;

        }

        scanner.close();


    }

    private static void clearTerminal(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    
}
