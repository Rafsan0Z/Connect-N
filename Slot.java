public class Slot {

    int length;
    int depth;
    Piece p;

    public Slot(int depth, int length){
        this.length = length;
        this.depth = depth;
        p = null;
    }

    public String toString(){
        String result = "";
        
        if(p == null){
            result = "___";
        }
        else{
            result = p.toString();
        }

        return result;
    }

    
}
