import java.awt.Toolkit;

public class Main {
	public static final int ASPECT_WIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	public static final int ASPECT_HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	public static void main(String[] args) {
		System.out.println(ASPECT_WIDTH + " " + ASPECT_HEIGHT);
		String hi = RandomEventObject.getRandomEvent().nameOfEvent;
		MainMenuGUI.createMainMenu(args);
	}
	
	public static int[] scaledUIElements(int x, int y, int height, int width, int theirScreenWidth, int theirScreenHeight) {
		int scaledX = ASPECT_WIDTH * x / theirScreenWidth;
		int scaledY = ASPECT_HEIGHT * y / theirScreenHeight;
		int scaledHeight = ASPECT_HEIGHT * height / theirScreenHeight;
		int scaledWidth = ASPECT_WIDTH * width / theirScreenWidth;
		
		return new int[] {scaledX, scaledY, scaledHeight, scaledWidth};
	}
}
