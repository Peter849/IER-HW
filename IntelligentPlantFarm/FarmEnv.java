// Environment code for project IntelligentPlantFarm.mas2j

import jason.asSyntax.*;
import jason.environment.*;
import jason.asSyntax.parser.*;
import java.util.logging.*;
import jason.environment.grid.Location;


public class FarmEnv extends Environment {

    private Logger logger = Logger.getLogger("IntelligentPlantFarm.mas2j."+FarmEnv.class.getName());
	FarmGridModel model;
	private int taskCounter;
	
	public static final Term ns = Literal.parseLiteral("next(slot)");
	
	public static final Literal full = Literal.parseLiteral("full(manager)");
	public static final Term at = Literal.parseLiteral("addTask");
	public static final Term wft = Literal.parseLiteral("waitForTask");
	public static final Term pe = Literal.parseLiteral("permit");
	public static final Term pl = Literal.parseLiteral("plant");
	public static final Literal cm = Literal.parseLiteral("changeMind");
	
	
    /** Called before the MAS execution with the args informed in .mas2j */
    @Override
    public void init(String[] args) {
        super.init(args);
		model = new FarmGridModel();
		if (args.length == 1 && args[0].equals("gui")) {
            FarmerGridView view  = new FarmerGridView(model);
            model.setView(view);
        }
		this.taskCounter = 0;
        updatePercepts();
    }

    @Override
    public boolean executeAction(String agName, Structure action) {
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
		}
		
		updatePercepts();
		
		try{
			Thread.sleep(200);
		}catch (Exception e) {}
		
		informAgsEnvironmentChanged();
		
        return true;
    }
	
	void executeActionBob(Structure action){
		if(action.equals(pl)){
			model.moveAgent(1, new Location(9,5));
		}
	}
	void executeActionJim(Structure action){
		//model.moveAgent(2, new Location(6,6));
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
		
		Location manager = model.getAgPos(0);
		Location farmerBob = model.getAgPos(1);
		Location farmerJim = model.getAgPos(2);
		Location farmerPaul = model.getAgPos(3);
		
		if(taskCounter >= 3){
			addPercept(full);	
		}
		
		
	}

    /** Called before the end of MAS execution */
    @Override
    public void stop() {
        super.stop();
    }
}


