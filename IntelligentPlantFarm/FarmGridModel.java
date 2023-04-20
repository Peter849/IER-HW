import jason.environment.grid.GridWorldModel;
import jason.environment.grid.Location;
import jason.asSyntax.*;
import jason.environment.*;
import jason.asSyntax.parser.*;
import java.util.logging.*;
import java.util.ArrayList;
import jason.environment.grid.Location;

public class FarmGridModel extends GridWorldModel{
	public static final int SOIL0DOCK =4;
    public static final int SOIL1DOCK =8;
    public static final int SOIL2DOCK=16;
	public static final int SOIL3DOCK=32;
	public static final int SOIL4DOCK=64;
	public static final int SOIL5DOCK=128;
	public static final int SOIL6DOCK=256;
	public static final int SOIL7DOCK=512;
	public static final int SOIL8DOCK=1024;
	public static final int SOIL9DOCK=2048;
	public static final int SOIL10DOCK=5096;
	public static final int SOIL11DOCK=10192;
	public static final int FARMHOUSELEFT = 20384;
	public static final int FARMHOUSEMIDDLE = 40768;
	public static final int FARMHOUSERIGHT = 81536;
	public static final int SILO = 163072;
	
    public static final int GSizeX=10;
    public static final int GSizeY=10;
	
	//Location of the farm buildings:
    Location farmhouseLeft=new Location(4,0);
    Location farmhouseRight=new Location(5,0);
	//ArrayList<Location> farmhouse = new ArrayLis<Location>();
	Location silo = new Location(9,5);
	
	//Location of soil fields:
	Location soil0 = new Location(3,3);
	Location soil1 = new Location(3,4);
	Location soil2 = new Location(3,5);
	Location soil3 = new Location(3,6);
	
	Location soil4 = new Location(5,3);
	Location soil5 = new Location(5,4);
	Location soil6 = new Location(5,5);
	Location soil7 = new Location(5,6);
	
	Location soil8 = new Location(7,3);
	Location soil9 = new Location(7,4);
	Location soil10 = new Location(7,5);
	Location soil11 = new Location(7,6);
	
	//Location of the Agents:
	Location managerLoc = new Location(6,1);
	Location farmerBobLoc = new Location(0,6);
	Location farmerJimLoc = new Location(0,7);
	Location farmerPaulLoc = new Location(0,8);
		
	private Logger logger = Logger.getLogger("IntelligentPlantFarm.mas2j." + FarmGridModel.class.getName());

    public FarmGridModel(){
        super(GSizeX,GSizeY,8);
		
        setAgPos(0,managerLoc);
		setAgPos(1,farmerBobLoc);
		setAgPos(2,farmerJimLoc);
		setAgPos(3,farmerPaulLoc);
		
		add(FARMHOUSELEFT,farmhouseLeft);
		add(FARMHOUSERIGHT,farmhouseRight);
		add(SILO,silo);
		 
        add(SOIL0DOCK,soil0);
        add(SOIL1DOCK,soil1);
		add(SOIL2DOCK,soil2);
		add(SOIL3DOCK,soil3);
		add(SOIL4DOCK,soil4);
		add(SOIL5DOCK,soil5);
		add(SOIL6DOCK,soil6);
		add(SOIL7DOCK,soil7);
		add(SOIL8DOCK,soil8);
		add(SOIL9DOCK,soil9);
		add(SOIL10DOCK,soil10);
		add(SOIL11DOCK,soil11);
    }
}
