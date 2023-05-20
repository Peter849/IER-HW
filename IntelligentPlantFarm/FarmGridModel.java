import jason.environment.grid.GridWorldModel;
import jason.environment.grid.Location;
import jason.asSyntax.*;
import jason.environment.*;
import jason.asSyntax.parser.*;
import java.util.logging.*;
import java.util.ArrayList;
import jason.environment.grid.Location;

public class FarmGridModel extends GridWorldModel{
	public static final int SOIL0 =4;
    public static final int SOIL1 =8;
    public static final int SOIL2 =16;
	public static final int SOIL3 =32;
	public static final int SOIL4 =64;
	public static final int SOIL5 =128;
	public static final int SOIL6 =256;
	public static final int SOIL7 =512;
	public static final int SOIL8 =1024;
	public static final int SOIL9 =2048;
	public static final int SOIL10 =5096;
	public static final int SOIL11 =10192;
	public static final int FARMHOUSELEFT = 20384;
	public static final int FARMHOUSEMIDDLE = 40768;
	public static final int FARMHOUSERIGHT = 81536;
	public static final int SILO = 163072;
	
	//Agent ID-s:
	private static final int ManagerID = 0;
	private static final int BobID = 1;
	private static final int JimID = 2;
	private static final int PaulID = 3;
		
	//Size of the grid
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
	
	//Starting Location of the Agents:
	Location managerLoc = new Location(6,1);
	Location farmerBobLoc = new Location(0,6);
	Location farmerJimLoc = new Location(0,7);
	Location farmerPaulLoc = new Location(0,8);
		
	private Logger logger = Logger.getLogger("IntelligentPlantFarm.mas2j." + FarmGridModel.class.getName());

    public FarmGridModel(){
        super(GSizeX,GSizeY,8);
		
        setAgPos(ManagerID,managerLoc);
		setAgPos(BobID,farmerBobLoc);
		setAgPos(JimID,farmerJimLoc);
		setAgPos(PaulID,farmerPaulLoc);
		
		add(FARMHOUSELEFT,farmhouseLeft);
		add(FARMHOUSERIGHT,farmhouseRight);
		add(SILO,silo);
		 
        add(SOIL0,soil0);
        add(SOIL1,soil1);
		add(SOIL2,soil2);
		add(SOIL3,soil3);
		add(SOIL4,soil4);
		add(SOIL5,soil5);
		add(SOIL6,soil6);
		add(SOIL7,soil7);
		add(SOIL8,soil8);
		add(SOIL9,soil9);
		add(SOIL10,soil10);
		add(SOIL11,soil11);
    }
	
	boolean moveAgent(int id, Location destination){
		//isFree - returns true if the location x,y has neither obstacle nor agent
		
		if(id < 0 || id > 4)
			return false;
		
		if(!inGrid(destination.x, destination.y))
			return false;
		
		Location agentPosition = getAgPos(id); 
		
		agentPosition.x = (agentPosition.x < destination.x && isFree(agentPosition.x+1, agentPosition.y)) ? agentPosition.x + 1 :
        (agentPosition.x > destination.x && isFree(agentPosition.x-1, agentPosition.y)) ? agentPosition.x - 1 : agentPosition.x;

	    agentPosition.y = (agentPosition.y < destination.y && isFree(agentPosition.x, agentPosition.y+1)) ? agentPosition.y + 1 :
        (agentPosition.y > destination.y && isFree(agentPosition.x, agentPosition.y-1)) ? agentPosition.y - 1 : agentPosition.y;
		
		setAgPos(id, agentPosition);
		return true;
	}
}
