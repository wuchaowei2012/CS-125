import sun.net.TelnetProtocolException;

//UIUC CS125 SPRING 2016 MP. File: RainGame.java, CS125 Project: PairProgramming, Version: 2016-02-23T05:57:26-0600.780520870
/**
 * @author ywang443,jiebao3
 * @reviewed by vkahuja2, apdunn2
 */ 
public class RainGame {

	public static void main(String[] args) {
		// To get points type your netids above (CORRECTLY-Please double check your partner correctly spells your netid correctly!!)
		// Your netid is the unique part of your @illinois email address
		// Do not put your name or your UIN. 
		// REMEMBER TO COMMIT this file...
	
		int x=0, y=0, dx=0, dy=0, score = 9, level = 1;
		int speed = 0;
		int direction = 1;
		String text = "";
		//long startTime =System.currentTimeMillis();
		//int skipped = 1;
		Zen.setFont("Helvetica-32");
		/*Zen.drawText("Skip easy levels? Y for yes and N for no", 0, 200);
		String skip = Zen.getEditText();
		if(skip.charAt(0) == 'Y' || skip.charAt(0) == 'y'){
			level = 3;
		}
		Zen.sleep(90);*/
		while (Zen.isRunning()) {
			/*
			if(skipped == 1){
				skipped = 0;
				String skip = "";
				Zen.drawText("Skip easy levels? Y for yes and N for no", 0, 200);
				do{
					skip = Zen.getEditText();
				}while(skip == "");
				char c = skip.charAt(0);
				if(c == 'Y' || c == 'y')
					level = 3;
			}*/
			direction = (int)(Math.random() * 4 + 1);
			if(score > 50){
				Zen.drawText("Don't stay in the hospital anymore.", 0, 400);
				Zen.drawText("You are good to go!", 0, 430);
				break;
			}
			if(score < 0){
				Zen.drawText("Take the pill right now!", 150, 400);			
				break;
			}
			
			if (text.length() == 0) {
				score++;
				if(direction == 1){ //up
					x = Zen.getZenWidth() / 2;
					y = 0;
					dx = 0;
					dy = 2 + speed;
				}
				else if(direction == 2){ //down
					x = Zen.getZenWidth() / 2;
					y = Zen.getZenHeight();
					dx = 0;
					dy = -(2 + speed);
				}
				else if(direction == 3){ //left
					x = 0;
					y = Zen.getZenHeight() / 2;
					dy = 0;
					dx = 2 + speed;
				}
				else{ //right
					x = Zen.getZenWidth();
					y = Zen.getZenHeight() / 2;
					dy = 0;
					dx = -(2 + speed);
				}
				

				if(level < 2){  // can be changed
					text = "" + randomChar() + randomChar() + randomChar() + randomChar() + randomChar();
				}
				else{
					text = "" + randomChar() + (int)(Math.random() * 99) + randomChar() + randomChar() + (int)(Math.random() * 99) + randomChar() + randomChar();
				}
				//long elapsed = System.currentTimeMillis() - startTime;
				//startTime = System.currentTimeMillis();
				 /*3000 / elapsed;*/
				level = score / 10;
				if(level == 0)
					level = 1;
				speed = score / 10;
			}
			
			Zen.setColor(0, 0, 0);
			Zen.fillRect(0, 0, Zen.getZenWidth(), Zen.getZenHeight());

			Zen.setColor(255, 255, 255);
			Zen.drawText(text, x, y);
			
			Zen.drawText("Level:" + level,10,30);
			Zen.drawText("Score:" + score,10,60);
			
			x += dx;
			y += dy;
			
			// Find out what keys the user has been pressing.
			String user = Zen.getEditText();
			// Reset the keyboard input to an empty string
			// So next iteration we will only get the most recently pressed keys.
			Zen.setEditText("");
			
			for(int i=0; i < user.length(); i++) {
				char c = user.charAt(i);
				if(text == ""){
				}
				else if(toUpperCase(c) == text.charAt(0) || toLowerCase(c) == text.charAt(0)){
					text = text.substring(1,text.length()); // all except first character
				}
				else{
					text = "";
					score -= 2;
					continue;
				}
			}
			
			Zen.sleep(90);// sleep for 90 milliseconds
			
		}
	}
	
	public static char randomChar(){
		return (char)((int) (Math.random() * 26 + 65));
	}
	public static char toUpperCase(char c){
		if(c >= 65 && c <= 90)
			return c;
		return (char) (c - 32);
	}
	public static char toLowerCase(char c){
		if(c >= 65 && c <= 90)
			return (char) (c + 32);
		return c;
	}
}
