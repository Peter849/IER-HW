import jason.environment.grid.GridWorldModel;
import jason.environment.grid.Location;
import jason.asSyntax.*;
import jason.environment.*;
import jason.asSyntax.parser.*;
import java.util.logging.*;
import java.util.ArrayList;
import jason.environment.grid.Location;

public class FarmGridModel extends GridWorldModel{
	public static final int iWHEAT0 =4;
    public static final int iWHEAT1 =8;
    public static final int iWHEAT2 =16;
	public static final int iWHEAT3 =32;
	public static final int iCORN0 =64;
	public static final int iCORN1 =128;
	public static final int iCORN2 =256;
	public static final int iCORN3 =512;
	public static final int iBARLEY0 =1024;
	public static final int iBARLEY1 =2048;
	public static final int iBARLEY2 =5096;
	public static final int iBARLEY3 =10192;
	public static final int iFARMHOUSELEFT = 20384;
	public static final int iFARMHOUSEMIDDLE = 40768;
	public static final int iFARMHOUSERIGHT = 81536;
	public static final int iSILO = 163072;
	
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
	Location silo = new Location(9,5);
	
	//Location of soil fields:
	Location wheat0 = new Location(3,3);
	Location wheat1 = new Location(3,4);
	Location wheat2 = new Location(3,5);
	Location wheat3 = new Location(3,6);
	
	Location corn0 = new Location(5,3);
	Location corn1 = new Location(5,4);
	Location corn2 = new Location(5,5);
	Location corn3 = new Location(5,6);
	
	Location barley0 = new Location(7,3);
	Location barley1 = new Location(7,4);
	Location barley2 = new Location(7,5);
	Location barley3 = new Location(7,6);
	
	//Current Location of the Agents:
	Location managerLoc = new Location(4,0);
	Location farmerBobLoc = new Location(0,6);
	Location farmerJimLoc = new Location(0,7);
	Location farmerPaulLoc = new Location(0,8);
	
	//Starting(ideal) Location of the Agents:
	Location managerLocStart = new Location(6,1);
	Location farmerBobLocStart = new Location(2,3);
	Location farmerJimLocStart = new Location(4,3);
	Location farmerPaulLocStart = new Location(6,3);
		
	private Logger logger = Logger.getLogger("IntelligentPlantFarm.mas2j." + FarmGridModel.class.getName());

    public FarmGridModel(){
        super(GSizeX,GSizeY,8);
		
        setAgPos(ManagerID,managerLoc);
		setAgPos(BobID,farmerBobLoc);
		setAgPos(JimID,farmerJimLoc);
		setAgPos(PaulID,farmerPaulLoc);
		
		add(iFARMHOUSELEFT,farmhouseLeft);
		add(iFARMHOUSERIGHT,farmhouseRight);
		add(iSILO,silo);
		 
        add(iWHEAT0,wheat0);
        add(iWHEAT1,wheat1);
		add(iWHEAT2,wheat2);
		add(iWHEAT3,wheat3);
		add(iCORN0,corn0);
		add(iCORN1,corn1);
		add(iCORN2,corn2);
		add(iCORN3,corn3);
		add(iBARLEY0,barley0);
		add(iBARLEY1,barley1);
		add(iBARLEY2,barley2);
		add(iBARLEY3,barley3);
    }
	
	boolean moveAgent(int id, Location destination){
		//isFree - returns true if the location x,y has neither obstacle nor agent
		
		if(id < 0 || id > 4)
			return false;
		
		if(!inGrid(destination.x, destination.y))
			return false;
		
		Location agentPosition = getAgPos(id); 
		
		/*if(agentPosition.x == destination.x && agentPosition.y == destination.y)
			return false;*/
		
		logger.info("agentID:" + id);
		
			if(agentPosition.x < destination.x)
				agentPosition.x = agentPosition.x + 1;
			else if (agentPosition.y < destination.y)
				agentPosition.y = agentPosition.y + 1;
			else if(agentPosition.x > destination.x)
				agentPosition.x = agentPosition.x - 1;
			else if (agentPosition.y > destination.y)
				agentPosition.y = agentPosition.y - 1;

			setAgPos(id, agentPosition);
		
		return true;
	}
	
	int getDistanceFromDestination(int agentID, Location destination)
	{
		int distance = 0;
		if(agentID == 0)
		{
			distance = managerLoc.distance(destination);
		}
		else if(agentID == 1)
		{
			distance = farmerBobLoc.distance(destination);
		}
		else if(agentID == 2)
		{
			distance = farmerJimLoc.distance(destination);
		}
		else if(agentID == 3)
		{
			distance = farmerPaulLoc.distance(destination);
		}
		return distance;
	}
}
