/*Author: Adam Reese
 *Date: 2/28/2023 
 * Description: This is the tile class for keeping track of information on tiles image
 * 
 */
class Tile{
    int x;
    int y;
    int width = 50;
    int height = 50;
    
    Tile()
    {
    }

    Tile(int horz, int vertic)
    {
        x = horz;
        y = vertic;
    }

    public void update()
    {
        
    }

     // marshaling for saving map
    Json marshal()
    {
        Json ob = Json.newObject();
        ob.add("x", x);
        ob.add("y", y);
        ob.add("width", width);
        ob.add("height", height);
        return ob;

    }

    // unMarshaling for loading map
    Tile(Json ob)
    {
         x = (int)ob.getLong("x");
         y = (int)ob.getLong("y");
         height = (int)ob.getLong("height");
         width = (int)ob.getLong("width");
         
    }

    
}