import java.util.ArrayList;

public class Board {
    
    ArrayList<ArrayList<Slot>> board;
    ArrayList<Slot> buckets;
    ArrayList<Integer> depths;
    int length;
    int depth;
    int winLen = 4;

    public Board(int length, int depth){

        this.length = length;
        this.depth = depth;

        buckets = new ArrayList<Slot>();

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
        
        this(10,6);

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

    private boolean inGrid(int depth, int position){

        if(depth > this.depth) return false;
        if(depth < 0) return false;
        if(position > this.length) return false;
        if(position < 0) return false;

        return true;
    }

    public void drop(int position, Player player){

        int deep = depths.get(position - 1);
        char face = player.getFace();

        if(deep == 0){
            System.out.println("Cannot place here anymore!!");
            return;
        }

        Slot target = board.get(deep - 1).get(position - 1);
        Piece p = new Piece(player);
        target.put(p);

        // In the 1 direction
        Slot direction = board.get(deep).get(position);
        if(direction.isPiece() && this.inGrid(deep + 1, position + 1) ){
            Piece c = direction.getPiece();
            if(c.getPlayer().getFace() == face){
                 p.connects.get(1).add(c); // adds the immediate piece
                 p.connects.get(1).addAll(c.getGroup(1)); // adds all the pieces that piece is attached to

                 if(p.connects.get(1).size() == winLen - 1){

                    // if deep - 2, position - 2 is in the grid, that slot is now a winningSlot
                    if(this.inGrid(deep - 1, position - 1)) player.getSlots().add(board.get(deep-2).get(position-2));

                    // get the final slot
                    // get the slot dimension for the 1 direction
                    // if that's in grid, then we add it to winningSlot

                 }

                 c.connects.get(5).add(p); // adding it to the connecting piece's connections
                 //updateBound.set(5, c); // Update afterwards

                 // Check if either end of the streak

                 ArrayList<Piece> updateList = c.connects.get(1);
                 updateList.forEach(type -> {

                    type.connects.get(5).add(p);

                 });

            } else{ // direction 1 is cut off
                p.connects.set(1, null);
            }
        }
        // In the 2 direction
        direction = board.get(deep - 1).get(position);
        if(direction.isPiece()){
            Piece c = direction.getPiece();
            if(c.getPlayer().getFace() == face){
                p.connects.get(2).add(c);
                p.connects.get(2).addAll(c.getGroup(2));
                c.connects.get(6).add(p);
                //updateBound.set(6, c); // Update afterwards

                ArrayList<Piece> updateList = c.connects.get(2);
                 updateList.forEach(type -> {

                    type.connects.get(6).add(p);

                 });

            } else{
                p.connects.set(2, null);
            }
        }
        // In the 3 direction
        direction = board.get(deep - 2).get(position - 2);
        if(direction.isPiece()){
            Piece c = direction.getPiece();
            if(c.getPlayer().getFace() == face){
                p.connects.get(3).add(c);
                p.connects.get(3).addAll(c.getGroup(3));
                c.connects.get(7).add(p);
                // Update afterwards
            } else{
                p.connects.set(3, null);
            }
        }
        // In the 4 direction
        direction = board.get(deep - 2).get(position - 1);
        if(direction.isPiece()){
            Piece c = direction.getPiece();
            if(c.getPlayer().getFace() == face){
                p.connects.get(4).add(c);
                p.connects.get(4).addAll(c.getGroup(4));
                c.connects.get(0).add(p);
                // Update afterwards
            } else{
                p.connects.set(4, null);
            }
        }
        // In the 5 direction


        // In the 6 direction



        depths.set(position - 1, deep - 1);

    }
    

}
