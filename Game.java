/*Author: Adam Reese
 *Date: 2/28/2023 
 * Description: This is the main game code for the game. putting all the controller,model, and view
 * together to make a functioning game.
 * 
 */
import javax.swing.JFrame;
import java.awt.Toolkit;

public class Game extends JFrame
{
	Model model;
	Controller controller;
	View view;
	Tile tile;
	public Game()
	{
		model = new Model();
		tile = new Tile();
		controller = new Controller(model);
		view = new View(controller, model , tile);
		this.setTitle("A3 - Map Editor");
		this.setSize(700, 500);
		this.setFocusable(true);
		this.getContentPane().add(view);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		view.addMouseListener(controller);
		this.addKeyListener(controller);
	}

	public static void main(String[] args)
	{
		Game g = new Game();
		g.run();
	}
	public void run()
	{
		while(true)
		{
			controller.update();
			view.repaint();
			Toolkit.getDefaultToolkit().sync();

			try
			{
				Thread.sleep(40);
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.exit(1);
			}
		}
	}
}
