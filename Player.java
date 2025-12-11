import java.util.ArrayList;

public class Player {

    char face;
    ArrayList<Slot> winningSlots;

    public Player(char face){

        this.face = face;
        winningSlots = new ArrayList<>();

    }

    public boolean hasWon(){
        for(Slot s: winningSlots){
            if(s.isPiece() && s.getPiece().face == face){
                return true;
            }
        }
        return false;
    }
    
}
