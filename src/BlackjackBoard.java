import javax.swing.*;
import java.awt.*;

public class BlackjackBoard extends JPanel{
	private Image background=new ImageIcon(BlackjackBoard.class.getResource("/image/gameboard.jpg")).getImage();

	public void paintComponent(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(0, 0, 1000, 600);
		
		//gameboard 이미지 삽입
		g.drawImage(background, 0, 0, null);
		

	}
	
	
	
}
