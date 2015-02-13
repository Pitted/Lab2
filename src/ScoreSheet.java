
public class ScoreSheet {

	private Frame[] scoresheet = new Frame[10];
	private int score = 0;
	private int currentFrame = 0;
	private int numTilComp = 0;
	private boolean finished = false;
	public ScoreSheet(){
		for(int i = 0; i<10; i++){
			scoresheet[i] = new Frame();
		}
	}
	public int getFrame(){
		//frames are 1 - 10, currentFrame is pointer to the array 0-9
		return currentFrame+1;
	}
	public Frame getCurrentFrame(){
		return scoresheet[currentFrame];
	}
	public int getScore(){
		return score;
	}
	public Frame getFrame(int i){
		if(i>10||i<1) throw new IllegalArgumentException();
		return scoresheet[i-1];
	}
	
	public void addThrow(int remainingPins){
		if(currentFrame>9) throw new IllegalArgumentException();
		scoresheet[currentFrame].throww(remainingPins);
		//if strike
		if(scoresheet[currentFrame].getScoreType()==11 ){
			numTilComp=2;
			currentFrame++;
		}
		//if spare
		else if( scoresheet[currentFrame].getScoreType() == 10){
			numTilComp=1;
			currentFrame++;
		}
		//if second throw
		else if(scoresheet[currentFrame].isFrameOver()){
			numTilComp--;
			if(numTilComp <= 0){
				compute(currentFrame);
			}
			currentFrame++;
			
	
		}
		else{
			if(numTilComp<=0){
				compute(currentFrame);
			}
		}
		
		if(currentFrame>9)
			finished = true;
		
		
	}
	public boolean isFinished(){
		return finished;
	}
	private void compute(int index){
		//if index is strike or spare or index-1 is strike and index doesn't equal 9
		//or
		//index-1 is equal to strike and 
		
		if(index!=0&&(scoresheet[index].getScoreType() == 11 || scoresheet[index].getScoreType() == 10 || scoresheet[index-1].getScoreType() == 11)
				&& index != 9) throw new IllegalStateException();
		score = 0;
		for(int i = index; i>=0; i--){
//			if strike
			if(scoresheet[i].getScoreType() == 11){
				if(i == index) //should only happen at 9
					scoresheet[i].setScore(10);
				else if(i == index-1) //should be at 8
					scoresheet[i].setScore(10+scoresheet[i+1].getScore());
				else
					scoresheet[i].setScore(10+scoresheet[i+1].getScore()+ scoresheet[i+2].getScore());
			}
//			if spare
			else if(scoresheet[i].getScoreType() == 10){
				if(i == index) // should be 9
					scoresheet[i].setScore(10);
				else
					scoresheet[i].setScore(10+scoresheet[i+1].getScore());
			}
//			add frame score to scoresheet score, non spare or strike should be already in frame score
			score += scoresheet[i].getScore();
		}
	}
	
}
