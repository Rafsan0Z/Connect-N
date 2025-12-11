import java.util.ArrayList;

public class Player {

    String name;
    char face;
    ArrayList<Slot> winningSlots;

    public Player(String name, char face){

        this.name = name;
        this.face = face;
        winningSlots = new ArrayList<>();

    }

    public boolean hasWon(){
        for(Slot s: winningSlots){
            if(s.isPiece() && s.getPiece().getPlayer().getFace() == face){
                return true;
            }
        }
        return false;
    }

    public String getName(){return this.name;}

    public char getFace(){return this.face;}
    
}
