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

    public void drop(int position, Player player){

        int deep = depths.get(position - 1);
        //char face = player.getFace();

        if(deep == 0){
            System.out.println("Cannot place here anymore!!");
            return;
        }

        Slot target = board.get(deep - 1).get(position - 1);
        Piece p = new Piece(player);
        target.put(p);

        // // In the 1 direction
        // Slot direction = board.get(deep).get(position);
        // if(direction.isPiece()){
        //     Piece c = direction.getPiece();
        //     if(c.face == face){
        //          p.connects.set(1, c); // adds the immediate piece
        //          p.connects.get(1).addAll(c.getGroup(1)); // adds all the pieces that piece is attached to
        //          c.connects.get(5).add(p); // adding it to the connecting piece's connections
        //          //updateBound.set(5, c); // Update afterwards

        //          // Check if either end of the streak

        //          ArrayList<Piece> updateList = c.connects.get(1);
        //          updateList.forEach(type -> {

        //             type.connects.get(5).add(p);

        //          });

        //     } else{ // direction 1 is cut off
        //         p.connects.set(1, null);
        //     }
        // }
        // // In the 2 direction
        // direction = board.get(deep - 1).get(position);
        // if(direction.isPiece()){
        //     Piece c = direction.getPiece();
        //     if(c.face == face){
        //         p.connects.set(2, c);
        //         p.connects.get(2).addAll(c.getGroup(2));
        //         c.connects.get(6).add(p);
        //         //updateBound.set(6, c); // Update afterwards

        //         ArrayList<Piece> updateList = c.connects.get(2);
        //          updateList.forEach(type -> {

        //             type.connects.get(6).add(p);

        //          });

        //     } else{
        //         p.connects.set(2, null);
        //     }
        // }
        // // In the 3 direction
        // direction = board.get(deep - 2).get(position - 2);
        // if(direction.isPiece()){
        //     Piece c = direction.getPiece();
        //     if(c.face == face){
        //         p.connects.set(3, c);
        //         p.connects.get(3).addAll(c.getGroup(3));
        //         c.connects.get(7).add(p);
        //         updateBound.set(7,c);
        //         // Update afterwards
        //     } else{
        //         p.connects.set(3, null);
        //     }
        // }
        // // In the 4 direction
        // direction = board.get(deep - 2).get(position - 1);
        // if(direction.isPiece()){
        //     Piece c = direction.getPiece();
        //     if(c.face == face){
        //         p.connects.set(4, c);
        //         p.connects.get(4).addAll(c.getGroup(4));
        //         c.connects.get(0).add(p);
        //         updateBound.set(0, c);
        //         // Update afterwards
        //     } else{
        //         p.connects.set(4, null);
        //     }
        // }
        // // In the 5 direction


        // // In the 6 direction


        // // Initiate all the updates now 


        depths.set(position - 1, deep - 1);

    }
    

}
