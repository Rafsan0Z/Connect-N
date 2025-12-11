import java.util.ArrayList;

public class Board {
    
    ArrayList<ArrayList<Slot>> board;
    ArrayList<ArrayList<Piece>> buckets;
    ArrayList<Integer> depths;
    int length;
    int depth;

    public Board(int length, int depth){

        this.length = length;
        this.depth = depth;

        board = new ArrayList<>(depth);
        for(int i = 0; i < depth; i++){
            board.add(new ArrayList<Slot>(length));
            for(int j = 0; j < length; j++){
                board.get(i).add(new Slot(i, j));
            }
        }


    }


    public Board(){
        
        this(10,4);

    }

    public String toString(){

        String result = "";

        for(int i = 0; i < depth; i++){
            result += "| ";

            for(int j = 0; j < length; j++){
                result += board.get(i).get(j).toString();
                if(j == length - 1) result += " |";
                else result += " ";
            }

            result += "\n";

        }

        return result;

    }


}
