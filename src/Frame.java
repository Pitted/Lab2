
public class Frame {
    private int score = 0; // score of the frame
    private int scoreType = 0; //type of score 0-9, 10 spare, 11 strike,
   // private int currentFrame = 0; //specific frame
    private int turn = 0; // turn of the frame
    private int totalPins = 10; // total pins of the frame
    
    
    public Frame(){
    	//currentFrame = t;
    }
    
    public int getScore(){
    	return score;
    }
    public int getScoreType(){
    	return scoreType;
    }
//    public int getCurrentFrame(){
//    	return currentFrame;
//    }
    public int getCurrentTurn(){
    	return turn;
    }
    public boolean isFrameOver(){
    	return turn>1;
    }
    public void setScore(int score){
    	this.score = score;
    }
    public void throww(int remainingPins){
    	if(turn > 1) throw new IllegalStateException();
    	if(0<=remainingPins && remainingPins > totalPins) throw new IllegalArgumentException();
    	totalPins = remainingPins;
    	if(remainingPins == 0){
    		if(turn == 0){
    			scoreType = 11;
    			turn = 2; // to make sure another throww is not used again on this frame
    		}
    		else
    			scoreType = 10;
    		turn++;
    		
    	}
    	else{
    		turn++;
    		scoreType = 10-totalPins;
    		score = 10 - totalPins;
    	}
    	
    	
    }
    
}
