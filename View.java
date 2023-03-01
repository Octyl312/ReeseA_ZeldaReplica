/*Author: Adam Reese
 *Date: 2/9/2023 
 * Description: This is the view for the game that updates images on the game frame.
 * 
 */

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;
import javax.swing.JButton;
import java.awt.Color;

class View extends JPanel
{
	
	BufferedImage tile_image;
	Tile tile;
	Model model;
	int roomx, roomy;


	View(Controller c, Model m, Tile t)
	{
		roomx = 0;
		roomy = 0;
		model = m;
		tile = t;
		c.setView(this);
		try
		{
			this.tile_image=ImageIO.read(new File("tile.jpg"));
		}
		catch(Exception e)
		{
			e.printStackTrace(System.err);
			System.exit(1);
		}
	}

	
	public void paintComponent(Graphics g)
	{
		g.setColor(new Color(128, 255, 255));
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		for(int i = 0; i < model.tiles.size(); i++)
		{	
			Tile t = model.tiles.get(i);
			g.drawImage(tile_image, t.x, t.y, t.height, t.width, null);
		}
		
	}

}
