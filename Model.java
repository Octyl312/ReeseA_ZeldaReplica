/*Author: Adam Reese
 *Date: 2/28/2023 
 * Description: This is the Model for the game for keeping track of currently tiles.
 * 
 */
import java.util.ArrayList;
class Model{
    
    ArrayList<Tile> tiles;

    Model()
    {
        tiles = new ArrayList<Tile>();
    }

    public void update()
    {
        
    }

    // checks if spot on screen has a tile then removes it if it does
    public boolean isTile(int x, int y)
    {
        for(int i = 0; i < this.tiles.size(); i++)
		{
			Tile t = this.tiles.get(i);
		    if(t.x == x && t.y == y)
            {
                this.tiles.remove(i);
                return true;
            }
		}
        return false;
    }
    
    public void setDestination(int x, int y)
    {
       
    }

    public void addTile(int x, int y)
    {
        Tile t = new Tile(x, y);
        tiles.add(t);
    }

    // unmarshaling for loading map
    void unmarshal(Json ob)
    {
         tiles = new ArrayList<Tile>();
         Json tmpList = ob.get("tiles");
         for(int i = 0; i < tmpList.size(); i++)
             tiles.add(new Tile(tmpList.get(i)));
    
         
    }

    // Marshaling for saving map
    Json marshal()
    {
        Json ob = Json.newObject();
        Json tmpList = Json.newList();
        ob.add("tiles", tmpList);
        for(int i = 0; i < tiles.size(); i++)
             tmpList.add(tiles.get(i).marshal());
        return ob;
    }

    
}