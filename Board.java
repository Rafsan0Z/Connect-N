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

        depths = new ArrayList<Integer>(length);
        for(int i = 0; i < length; i++){
            depths.add(depth);
        }

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

    public void drop(int position, char face){

        int deep = depths.get(position - 1);

        if(deep == 0){
            System.out.println("Cannot place here anymore!!");
            return;
        }

        Slot target = board.get(deep - 1).get(position - 1);
        Piece p = new Piece(face);
        target.put(p);

        depths.set(position - 1, deep - 1);

    }


}
