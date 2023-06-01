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
	private static final int wheatID = 40;
	private static final int wheatID2 = 41;
	private static final int wheatID3 = 42;
	private static final int wheatID4 = 43;
	private static final int cornID = 8;
	private static final int cornID2 = 9;
	private static final int cornID3 = 10;
	private static final int cornID4 = 11;
	private static final int barleyID = 12;
	private static final int barleyID2 = 13;
	private static final int barleyID3 = 14;
	private static final int barleyID4 = 15;
		
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
	Location managerLoc = new Location(7,0);
	Location farmerBobLoc = new Location(0,6);
	Location farmerJimLoc = new Location(0,7);
	Location farmerPaulLoc = new Location(0,8);
	Location wheatLoc = new Location(3,3);
	Location wheatLoc2 = new Location(3,4);
	Location wheatLoc3 = new Location(3,5);
	Location wheatLoc4 = new Location(3,6);
	Location cornLoc = new Location(5,3);
	Location cornLoc2 = new Location(5,4);
	Location cornLoc3 = new Location(5,5);
	Location cornLoc4 = new Location(5,6);
	Location barleyLoc = new Location(7,3);
	Location barleyLoc2 = new Location(7,4);
	Location barleyLoc3 = new Location(7,5);
	Location barleyLoc4 = new Location(7,6);
	
		
	private Logger logger = Logger.getLogger("IntelligentPlantFarm.mas2j." + FarmGridModel.class.getName());
	
    public FarmGridModel(){
        super(GSizeX,GSizeY,81537);
		
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
	
	void bobMoveToField(){
		try{
			move("EAST", 1);
			Thread.sleep(250);
			move("EAST", 1);
			Thread.sleep(250);
			move("NORTH", 1);
			Thread.sleep(250);
			move("NORTH", 1);
			Thread.sleep(250);
			move("NORTH", 1);
		}catch (Exception e){}
		setAgPos(wheatID,wheatLoc);
		setAgPos(wheatID2,wheatLoc2);
		setAgPos(wheatID3,wheatLoc3);
		setAgPos(wheatID4,wheatLoc4);
	}
	
	void bobWater(){
		try{
			for(int i = 0; i<3; i++){
				move("SOUTH", 1);
				Thread.sleep(250);
			}
		}catch(Exception e){}
	}
	
	void bobHarvest(){
		try{
			for(int i=0; i<3; i++){
				move("NORTH",1);
				Thread.sleep(250);
			}
		}catch(Exception e){}
		remove(wheatID,wheatLoc);
		remove(wheatID2,wheatLoc2);
		remove(wheatID3,wheatLoc3);
		remove(wheatID4,wheatLoc4);
		try{
			for(int i = 0; i<3; i++){
				move("NORTH", 1);
				Thread.sleep(250);
			}
			move("EAST",1);
		}catch(Exception e){}
	}
	
	void bobGetPayment(){
		try{
			move("SOUTH", 1);
			Thread.sleep(250);
			move("EAST", 1);
			Thread.sleep(250);
			move("EAST", 1);
			Thread.sleep(250);
			move("EAST", 1);
			Thread.sleep(500);
		}catch(Exception e){}
	}
	
	void bobLeave(){
		try{
			for(int i = 0; i<1; i++){
				move("EAST", 1);
				Thread.sleep(250);
			}
		}catch(Exception e){}
	}
	
	boolean jimMoveToField(){
		try{
			for(int i = 0; i<4; i++){
				move("EAST", 2);
				Thread.sleep(250);
			}
			for(int j = 0; j<4; j++){
				move("NORTH", 2);
				Thread.sleep(250);
			}
		}catch (Exception e){}
		setAgPos(cornID, cornLoc);
		setAgPos(cornID2, cornLoc2);
		setAgPos(cornID3, cornLoc3);
		setAgPos(cornID4, cornLoc4);
		return true;
	}
	
	void jimWater(){
		try{
			for(int i = 0; i<3; i++){
				move("SOUTH", 2);
				Thread.sleep(250);
			}
		}catch(Exception e){}
	}
	
	void jimHarvest(){
		try{
			for(int i=0; i<3; i++){
				move("NORTH",2);
				Thread.sleep(250);
			}
		}catch(Exception e){}
		remove(cornID,cornLoc);
		remove(cornID2,cornLoc2);
		remove(cornID3,cornLoc3);
		remove(cornID4,cornLoc4);
		try{
			for(int i = 0; i<2; i++){
				move("NORTH", 2);
				Thread.sleep(250);
			}
		}catch(Exception e){}
	}
	
	void jimGetPayment(){
		try{
			move("EAST", 2);
			Thread.sleep(250);
			move("EAST", 2);
			Thread.sleep(500);
		}catch(Exception e){}
	}
	
	void jimLeave(){
		try{
			for(int i = 0; i<2; i++){
				move("EAST", 2);
				Thread.sleep(250);
			}
		}catch(Exception e){}
	}
	
	boolean paulMoveToField(){
		try{
			for(int i = 0; i<6; i++){
				move("EAST", 3);
				Thread.sleep(250);
			}
			for(int j = 0; j<5; j++){
				move("NORTH", 3);
				Thread.sleep(250);
			}
		}catch (Exception e){}
		setAgPos(barleyID, barleyLoc);
		setAgPos(barleyID2, barleyLoc2);
		setAgPos(barleyID3, barleyLoc3);
		setAgPos(barleyID4, barleyLoc4);
		return true;
	}
	
	void paulWater(){
		try{
			for(int i = 0; i<3; i++){
				move("SOUTH", 3);
				Thread.sleep(250);
			}
		}catch(Exception e){}
	}
	
	void paulHarvest(){
		try{
			for(int i=0; i<3; i++){
				move("NORTH",3);
				Thread.sleep(250);
			}
		}catch(Exception e){}
		remove(barleyID,barleyLoc);
		remove(barleyID2,barleyLoc2);
		remove(barleyID3,barleyLoc3);
		remove(barleyID4,barleyLoc4);
		try{
			for(int i = 0; i<2; i++){
				move("NORTH", 3);
				Thread.sleep(250);
			}
			move("WEST",3);
		}catch(Exception e){}
	}
	
	void paulGetPayment(){
		try{
			move("EAST", 3);
			Thread.sleep(500);
		}catch(Exception e){}
	}
	
	void paulLeave(){
		try{
			for(int i = 0; i<3; i++){
				move("EAST", 3);
				Thread.sleep(250);
			}
		}catch(Exception e){}
	}
	
	void managerMoveToFarmHouse(){
		move("WEST",0);
	}
	
	boolean move(String dir, int id){
		Location agentPos = getAgPos(id);
		switch (dir) {
        case "NORTH":
            setAgPos(id, agentPos.x, agentPos.y - 1);
            break;
        case "SOUTH":
            setAgPos(id, agentPos.x, agentPos.y + 1);
            break;
        case "EAST":
            setAgPos(id, agentPos.x + 1, agentPos.y);
            break;
        case "WEST":
            setAgPos(id, agentPos.x - 1, agentPos.y);
            break;
        }
        return true;
	}
}
