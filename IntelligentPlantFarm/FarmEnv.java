// Environment code for project IntelligentPlantFarm.mas2j

import jason.asSyntax.*;
import jason.environment.*;
import jason.asSyntax.parser.*;
import java.util.logging.*;
import jason.environment.grid.Location;
import java.awt.Color;

public class FarmEnv extends Environment {

    private Logger logger = Logger.getLogger("IntelligentPlantFarm.mas2j."+FarmEnv.class.getName());
	FarmGridModel model;
	FarmerGridView view;
	private int taskCounter;
	private boolean reachedPosBob;
	
	public static final Term ns = Literal.parseLiteral("next(slot)");
	
	public static final Literal managerAtStartPosition = Literal.parseLiteral("at(manager,start)");
	public static final Literal farmerBobatStartPosition = Literal.parseLiteral("at(farmerBob,start)");
	public static final Literal farmerJimatStartPosition = Literal.parseLiteral("at(farmerJim,start)");
	public static final Literal farmerPaulatStartPosition = Literal.parseLiteral("at(farmerPaul,start)");
	
	public static final Literal full = Literal.parseLiteral("full(manager)");
	public static final Term at = Literal.parseLiteral("addTask");
	public static final Term wft = Literal.parseLiteral("waitForTask");
	public static final Term pe = Literal.parseLiteral("permit");
	//public static final Term pl = Literal.parseLiteral("plant");
	public static final Literal cm = Literal.parseLiteral("changeMind");
	
	public static final Term wc = Literal.parseLiteral("waterCorn");
	boolean waterCorn;
	
	public static final Literal mv = Literal.parseLiteral("move");
	
    /** Called before the MAS execution with the args informed in .mas2j */
    @Override
    public void init(String[] args) {
        super.init(args);
		model = new FarmGridModel();
		if (args.length == 1 && args[0].equals("gui")) {
            view = new FarmerGridView(model);
            model.setView(view);
        }
		this.taskCounter = 0;
		this.reachedPosBob = false;
		this.waterCorn = false;
        updatePercepts();
    }

    @Override
    public boolean executeAction(String agName, Structure action) {
		boolean successfulAction = false;
		
		if(action.getFunctor().equals("move_to_destination")){
			String locationName = action.getTerm(0).toString();				//Where should we move?
			int agentID = Integer.parseInt(action.getTerm(1).toString());	//Who should be moved?
			Location destination = null;
			
			if(locationName.equals("silo")){
				destination = model.silo;
			}else if(locationName.equals("start")){
				try{
					switch(agName){
						case "farmerBob":
							destination = model.farmerBobLocStart;
						break;
						case "farmerJim":
							destination = model.farmerJimLocStart;
						break;
						case "farmerPaul":
							destination = model.farmerPaulLocStart;
						break;
						case "manager":
							destination = model.managerLocStart;
						break;
						default:
							logger.info("No agent: " + agName);
					}
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			else if(locationName.equals("wheat0")){
				destination = model.wheat0;
			}
			else if(locationName.equals("wheat1")){
				destination = model.wheat1;
			}
			else if(locationName.equals("wheat2")){
				destination = model.wheat2;
			}
			else if(locationName.equals("wheat3")){
				destination = model.wheat3;
			}
			else if(locationName.equals("corn0")){
				destination = model.corn0;
			}
			else if(locationName.equals("corn1")){
				destination = model.corn1;
			}
			else if(locationName.equals("corn2")){
				destination = model.corn2;
			}
			else if(locationName.equals("corn3")){
				destination = model.corn3;
			}
			else if(locationName.equals("barley0")){
				destination = model.barley0;
			}
			else if(locationName.equals("barley1")){
				destination = model.barley1;
			}
			else if(locationName.equals("barley2")){
				destination = model.barley2;
			}
			else if(locationName.equals("barley3")){
				destination = model.barley3;
			}
			
			try{
				successfulAction = model.moveAgent(agentID, destination);
			}catch(Exception e){
				e.printStackTrace();
			}	
		}
		
		/*else if(action.getFunctor().equals("get")){
			String table = action.getTerm(0).toString();
			int tableID = Integer.parseInt(table);
			result = model.getOrder(tableID);
		}
		
		else if(action.getFunctor().equals("hand_in")){
			String table = action.getTerm(0).toString();
			int tableID = Integer.parseInt(table);
			result = model.handInOrder(tableID);
		}
		
		else if(action.getFunctor().equals("chew")){
			String table = action.getTerm(0).toString();
			int tableID = Integer.parseInt(table);
			result = model.chewCount(tableID);
		}
		
		else if(action.getFunctor().equals("pay")){
			result = model.pay();
		}
		
		if (result) {
            updatePercepts();
            try {
                Thread.sleep(100);
            } catch (Exception e) {}
        }
        return result;		
		
		//logger.info("Agent:" + agName + ",executes: " + action);
		try{
			switch(agName){
				case "farmerBob":
					executeActionBob(action);
				break;
				case "farmerJim":
					executeActionJim(action);
				break;
				case "farmerPaul":
					executeActionPaul(action);
				break;
				case "manager":
					executeActionManager(action);
				break;
				default:
					
			}
		}catch(Exception e){
			e.printStackTrace();
		}*/
		
		if(successfulAction)
		{
			updatePercepts();
			informAgsEnvironmentChanged();
		}
		try{
			Thread.sleep(200);
		}catch (Exception e) {}
			
        return successfulAction;
    }
	
	void executeActionBob(Structure action){
		/*if(action.equals(mv)){
			model.moveAgent(1, new Location(9,5));
		}*/
		/*if(action.equals("home1")){
				destination = model.homelocationR1;
		}*/
		/*if(action.equals(gs)){
			logger.info("ASDASDASDASDASD:" + action);
			while(!reachedPosBob)
			{
				boolean temp = model.moveAgent(1, new Location (4,5));
				if(temp)
					reachedPosBob = true;
			}		
		}*/
		if(action.equals(wc)){
			waterCorn = true;
		}
	}
	void executeActionJim(Structure action){
		model.moveAgent(2, new Location(6,6));
	}
	void executeActionPaul(Structure action){
		if(action.equals(cm)){
			model.moveAgent(3, new Location(6,6));
		}	
	}
	void executeActionManager(Structure action){
		
	}
	
	void updatePercepts(){
		clearPercepts("manager");
		clearPercepts("farmerBob");
		clearPercepts("farmerJim");
		clearPercepts("farmerPaul");
		
		Location managerCurrentPos    =  model.getAgPos(0);
		Location farmerBobCurrentPos  =  model.getAgPos(1);
		Location farmerJimCurrentPos  =  model.getAgPos(2);
		Location farmerPaulCurrentPos =  model.getAgPos(3);
		
		if(taskCounter >= 3){
			addPercept(full);	
		}
		
		if(managerCurrentPos.equals(model.managerLocStart))
		{
			addPercept("managerCurrentPos", managerAtStartPosition);
		}
		if(farmerBobCurrentPos.equals(model.farmerBobLocStart))
		{
			addPercept("farmerBobCurrentPos", farmerBobatStartPosition);
		}
		if(farmerJimCurrentPos.equals(model.farmerJimLocStart))
		{
			addPercept("farmerJimCurrentPos", farmerJimatStartPosition);
		}
		if(farmerPaulCurrentPos.equals(model.farmerPaulLocStart))
		{
			addPercept("farmerPaulCurrentPos", farmerPaulatStartPosition);
		}	
		
		/*if(farmerBob.equals(model.farmerBobLoc)
		{
			addPercept("farmerBob",farmerBobatStartPosition);
		}*/
		
		/*if(waterCorn){
			view.setCornColor(Color.BLUE);
		}*/
	}

    /** Called before the end of MAS execution */
    @Override
    public void stop() {
        super.stop();
    }
}


