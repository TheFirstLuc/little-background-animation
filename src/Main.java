import java.util.concurrent.TimeUnit;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		Window window = new Window(1920, 1080, 30);
		
		//game loop
		while(true) {
			
			window.repaint();
			TimeUnit.MILLISECONDS.sleep(20);
		}
	}
}
