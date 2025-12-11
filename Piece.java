import java.util.ArrayList;

public class Piece {
    
    ArrayList<ArrayList<Piece>> connects;
    char face;

    public Piece(char face){

        this.face = face;
        connects = new ArrayList<>(6);
        for(int i = 0; i < 6; i++){
            connects.add(new ArrayList<Piece>());
        }

    }

    public void update(int direction){


    }

    public String toString(){

        String result = "_" + face + "_";

        return result;

    }

}
