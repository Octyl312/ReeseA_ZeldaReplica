/*Author: Adam Reese
 *Date: 2/9/2023 
 * Description: This is the Controller for the game. currently adds/removes tiles, saves/loads a map, and change between rooms.
 * 
 */

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;


class Controller implements ActionListener, MouseListener, KeyListener
{
	View view;
	Model model;
	boolean keyLeft, keyRight, keyUp, keyDown;
	int mousex = 0, mousey = 0;
	boolean tileTest;
	Controller(Model m)
	{
		model = m;
	}

	public void actionPerformed(ActionEvent e)
	{

	}

	void setView(View v)
	{
		view = v;
	}
	

	public void mousePressed(MouseEvent e)
	{
	}

	public void mouseReleased(MouseEvent e) {   }
	public void mouseEntered(MouseEvent e) {   }
	public void mouseExited(MouseEvent e) {   }
	public void mouseClicked(MouseEvent e) 
	{ 
		// gets location of mouse click and adds tile or removes tile
		mousex=e.getX();
		mousey=e.getY();
		tileTest = model.isTile(mousex - mousex % 50,mousey - mousey % 50);
		if(!tileTest) model.addTile(mousex - mousex % 50,mousey - mousey % 50);
	}

	public void keyPressed(KeyEvent e)
	{
		switch(e.getKeyCode())
		{
			// Exit the program
			case KeyEvent.VK_Q : System.exit(0); break;
			case KeyEvent.VK_ESCAPE: System.exit(0); break;
			// saves and load map
			case KeyEvent.VK_S: Json s = model.marshal(); s.save("map.json"); break;
			case KeyEvent.VK_L: Json l = Json.load("map.json"); model.unmarshal(l); break;
			// Shift between model
			case KeyEvent.VK_A: keyLeft = true; break;
			case KeyEvent.VK_D: keyRight = true; break;
			case KeyEvent.VK_W: keyUp = true; break;
			case KeyEvent.VK_X: keyDown = true; break;
			

		}

	}

	public void keyReleased(KeyEvent e)
	{
		switch(e.getKeyCode())
		{
			case KeyEvent.VK_A: keyLeft = false; break;
			case KeyEvent.VK_D: keyRight = false; break;
			case KeyEvent.VK_W: keyUp = false; break;
			case KeyEvent.VK_S: keyDown = false; break;
		}
	}

	public void keyTyped(KeyEvent e)
	{
	}

	void update()
	{
		/* 
		if(keyRight) model.dest_x+=4;
		if(keyLeft) model.dest_x-=4;
		if(keyUp) model.dest_y+=4;
		if(keyDown) model.dest_y-=4;  
		*/
	}

}
