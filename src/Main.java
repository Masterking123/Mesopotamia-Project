import java.awt.Toolkit;
import java.util.Random;

public class Main {
	public static final int ASPECT_WIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	public static final int ASPECT_HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	public static void main(String[] args) {
		System.out.println(ASPECT_WIDTH + " " + ASPECT_HEIGHT);
		MainMenuGUI.createMainMenu(args);
	}
	
	
	// Global method to allow anyone to when creating a percent random chance, just plug in the percent value 
	// And it will see if that event will actually happen given that random percent value
	public static boolean randomPercentOccurance(int randomPercent) {
		Random rand = new Random();
		int randomInt = rand.nextInt(100) + 1;
		if(randomInt <= randomPercent) {
			return true;
		}
		return false;
	}
	
	public static int[] scaledUIElements(int x, int y, int height, int width, int theirScreenWidth, int theirScreenHeight) {
		int scaledX = ASPECT_WIDTH * x / theirScreenWidth;
		int scaledY = ASPECT_HEIGHT * y / theirScreenHeight;
		int scaledHeight = ASPECT_HEIGHT * height / theirScreenHeight;
		int scaledWidth = ASPECT_WIDTH * width / theirScreenWidth;
		
		return new int[] {scaledX, scaledY, scaledHeight, scaledWidth};
	}
	
	public static int scaledFontSize(int fontSize, int theirScreenWidth, int theirScreenHeight) {
		return (int)((fontSize * theirScreenWidth / ASPECT_WIDTH) / 1.5);
	}
}
