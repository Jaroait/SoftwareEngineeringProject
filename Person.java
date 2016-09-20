import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;


import javax.imageio.ImageIO;

class Person {
	static Image personLeft = null;
	static Image personRight = null;
	//static Image feathers = null;
	int leftCounter, rightCounter;
	int x, y, width, height;
	boolean collision, leftDirection, jump;
	double gravity;
	int gravityCounter, jumpCounter;
	
	
	Person()throws IOException{
		x = 100;
		y = 700;
		width = 44;
		height = 64;
		personLeft = ImageIO.read(new File("personLeft.png"));
		personRight = ImageIO.read(new File("personRight.png"));
	}
	
	public void update() {
		leftCounter -= 1;
		rightCounter -= 1;
		if (gravity >= 15){
			gravity = 3.6;
		}
		if (collision == false && gravity <= 15){
			gravity += 3.6;
			gravityCounter -= 1;
			y += gravity;
			jump = false;
		}
		else if(jumpCounter <= 2 && gravity <= 15 && jump == true){
			gravity += 77;
			gravityCounter -= 1;
			y+= gravity;
			jumpCounter++;
		}
		else{
			gravity = 0;
		}
	}
	
	
	void draw(Graphics g){
		if(leftDirection){
			if (leftCounter < 2){
				g.drawImage(personLeft, x, y, null);
			}
			//else if (leftCounter >= 2){
			//	g.drawImage(personLeftWalking, x, y, null);
			//}
		}
		else{
			if (rightCounter < 2){
				g.drawImage(personRight, x, y, null);
			}
			//else if (leftCounter >= 2){
			//	g.drawImage(personLeftWalking, x, y, null);
			//}
		}
		
	}
	
	public void walkLeft() {
		//if (leftCounter < -5)
		//	leftCounter = 8;
		x = x - 9;
		leftDirection = true;
	}
	public void walkRight() {
		//if (rightCounter < -5)
		//	rightCounter = 8;
		x = x + 9;
		leftDirection = false;
	}
	public void jump(){
		jumpCounter = 0;
		jump = true;
		if (collision){
			if (jumpCounter == 0)
				gravity = 0;
				gravity -= 100;
				//y += gravity;
				gravityCounter = 8;
		}
		else{
			//do nothing -- fall
		}
	}
}
	
