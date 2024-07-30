import java.util.HashSet;
public class Basement{
    private HashSet<String> coinTracker;
    private int currentX;
    private int currentY;
    private String direction;
    private int maxX;
    private int minX;
    private int maxY;
    private int minY;
    private String currentPosition;
    
    // Basement constructor
    public Basement(){
        this.coinTracker = new HashSet<String>();
        this.direction = Const.UP;
    }

    // update method --------------------------------------------------------------------------------------------------
    public void update(){
        // Store X and Y positions in a coordinate string representation
        this.currentPosition = String.valueOf(this.currentX) + ", " + String.valueOf(this.currentY);        
        
        // If Uncle Scrooge is on a tile without a coin
        if (!this.coinTracker.contains(this.currentPosition)){
            this.coinTracker.add(this.currentPosition); // Places coin in current position
            if (this.direction == Const.UP){
                this.direction = Const.RIGHT;
                this.currentX = this.currentX + 1;
            }
            else if (this.direction == Const.DOWN){
                this.direction = Const.LEFT;
                this.currentX = this.currentX - 1;
            }
            else if (this.direction == Const.LEFT){
                this.direction = Const.UP;
                this.currentY = this.currentY - 1;
            }
            else if (this.direction == Const.RIGHT){
                this.direction = Const.DOWN;
                this.currentY = this.currentY + 1;
            }
        }

        // If Uncle Scrooge is on a tile with a coin
        else{
            this.coinTracker.remove(this.currentPosition); // Picks up coin from current position
            if (this.direction == Const.UP){
                this.direction = Const.LEFT;
                this.currentX = this.currentX - 1;
            }
            else if (this.direction == Const.DOWN){
                this.direction = Const.RIGHT;
                this.currentX = this.currentX + 1;
            }
            else if (this.direction == Const.LEFT){
                this.direction = Const.DOWN;
                this.currentY = this.currentY + 1;
            }
            else if (this.direction == Const.RIGHT){
                this.direction = Const.UP;
                this.currentY = this.currentY - 1;
            }
        }
        
        // Update boundaries of basement
        this.minX = Math.min(this.currentX, this.minX);
        this.maxX = Math.max(this.currentX, this.maxX);
        this.minY = Math.min(this.currentY, this.minY);
        this.maxY = Math.max(this.currentY, this.maxY);
    } // update method end
    
    // Overriden toString method --------------------------------------------------------------------------------------
    @Override
    public String toString(){
        String basementMap = "";
        for (int i = minY; i <= maxY; i++){
            for (int j = minX; j <= maxX; j++){
                String location = String.valueOf(j) + ", " + String.valueOf(i); // Generate coordinate positions
                if (this.currentX == j && this.currentY == i){
                    if (this.direction == Const.UP)
                        basementMap = basementMap + Const.UP;
                    else if (this.direction == Const.DOWN)
                        basementMap = basementMap + Const.DOWN;
                    else if (this.direction == Const.LEFT)
                        basementMap = basementMap + Const.LEFT;
                    else 
                        basementMap = basementMap + Const.RIGHT;
                }
                else if (this.coinTracker.contains(location))
                    basementMap = basementMap + Const.COIN;
                else 
                    basementMap = basementMap + Const.EMPTY;
            }
            basementMap = basementMap + "\n";
        }
        return basementMap;
    } // toString method end
} // Basement class end
