import java.util.ArrayList;

public class Piece {
    
    ArrayList<ArrayList<Piece>> connects;
    char face;
    Player p;

    public Piece(char face){

        this.face = face;
        connects = new ArrayList<>(8);
        for(int i = 0; i < 8; i++){
            connects.add(new ArrayList<Piece>());
        }

    }

    public Piece(Player p){

        this(p.getFace());

    }

    public void update(int direction){



    }

    public ArrayList<Piece> getGroup(int direction){
        return connects.get(direction);
    }

    public String toString(){

        String result = "_" + face + "_";

        return result;

    }

}
