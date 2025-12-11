import java.util.ArrayList;

public class Piece {
    
    ArrayList<ArrayList<Piece>> connects;
    Player p;
    Slot s;

    public Piece(Player p){

        this.p = p;
        s = null;
        connects = new ArrayList<>(8);
        for(int i = 0; i < 8; i++){
            connects.add(new ArrayList<Piece>());
        }

    }

    public void update(int direction){



    }

    public Slot getSlot(){return this.s;}

    public void setSlot(Slot s){
        this.s = s;
    }

    public ArrayList<Piece> getGroup(int direction){
        return connects.get(direction);
    }

    public String toString(){

        String result = "_" + p.getFace() + "_";

        return result;

    }

    public Player getPlayer(){return this.p;}

}
