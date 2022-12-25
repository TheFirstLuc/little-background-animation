public class Dot {
	
	int width, height;
	int PosX, PosY;
	int velocityX;
	int velocityY;
	int size = 3;
	
	public Dot(int PosX, int PosY, int size) {
		this.PosX = PosX;
		this.PosY = PosY;
		this.size = size;
		
		//set random velocity
		this.velocityX = getRandomNumber(-5, 5);
		this.velocityY = getRandomNumber(-5, 5);
		
		//check that velocity isnt 0
		if(velocityX == 0 && velocityY == 0) {
			if(Math.random() < 0.5) {
				velocityX++;
			} else {
				velocityY++;
			}
		}

	}
	
	public int getRandomNumber(int min, int max) {
	    return (int) ((Math.random() * (max - min)) + min);
	}
	
	//other constructor
	public Dot(int PosX, int PosY) {
		this(PosX, PosY, 3);
	}
	
}
