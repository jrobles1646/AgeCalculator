
package languages;
import javax.swing.JFrame;
import java.awt.Dimension;

public class Main
{
	public static void main(String[] args)
	{
		new LanguageGUI();
		JFrame frame = new JFrame ("Танджоуби no Дентаку");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(new LanguageGUI());
		frame.setPreferredSize(new Dimension (500, 300));
		frame.pack();
		frame.setVisible(true);
	}//end public static void main(String[] args)
}//end public class Main
