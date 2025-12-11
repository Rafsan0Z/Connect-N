import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        clearTerminal();
        Scanner scanner = new Scanner(System.in);
        String quit = "";

        Player p1 = new Player("Player 1", 'O');
        Player p2 = new Player("Player 2", 'X');

        ArrayList<Player> playerList = new ArrayList<Player>();
        playerList.add(p1);
        playerList.add(p2);

        int turn = 0;

        //char face = 'p';
        Board b = new Board();
        System.out.println(b.toString());

        while(!quit.equals("q")){

            clearTerminal();

            if(turn == 0){
                System.out.println("--------");
                //face = 'O';
            }
            else if (turn == 1){
                System.out.println("             --------");
                //face = 'B';
            }
            System.out.println(p1.getName() + "     " + p2.getName());
            System.out.println(b.toString());

            System.out.println("Enter the position you want to drop your piece into: ");
            int pos = scanner.nextInt();
            scanner.nextLine();

            b.drop(pos,playerList.get(turn));
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
