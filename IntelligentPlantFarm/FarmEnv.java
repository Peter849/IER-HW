// Environment code for project IntelligentPlantFarm.mas2j

import jason.asSyntax.*;
import jason.environment.*;
import jason.asSyntax.parser.*;
import java.util.logging.*;
import jason.environment.grid.Location;

public class FarmEnv extends Environment {

    private Logger logger = Logger.getLogger("IntelligentPlantFarm.mas2j."+FarmEnv.class.getName());
	FarmGridModel model;
	private int wheat = 0;
	private int corn = 0;
	private int barley = 0;
	public int amount;
	
	public static final Literal co = Literal.parseLiteral("collected");
	public static final Literal mo = Literal.parseLiteral("move");
	public static final Literal wa = Literal.parseLiteral("water");
	public static final Literal ha = Literal.parseLiteral("harvest");
	public static final Literal se = Literal.parseLiteral("sell");
	public static final Literal gp = Literal.parseLiteral("getPayment");
	public static final Literal le = Literal.parseLiteral("leave");
	
    /** Called before the MAS execution with the args informed in .mas2j */
    @Override
    public void init(String[] args) {
        super.init(args);
		model = new FarmGridModel();
		if (args.length == 1 && args[0].equals("gui")) {
            FarmerGridView view  = new FarmerGridView(model);
            model.setView(view);
        }
        updatePercepts();
    }

    @Override
    public boolean executeAction(String agName, Structure action) {
		//logger.info("Agent:" + agName + ",executes: " + action);
		try{
			switch(agName){
				case "farmerBob":
					executeActionBob(action, amount);
				break;
				case "farmerJim":
					executeActionJim(action, amount);
				break;
				case "farmerPaul":
					executeActionPaul(action, amount);
				break;
				case "manager":
					executeActionManager(action, amount);
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
	
	void executeActionBob(Structure action, int amount){
		if(action.equals(co)){
			wheat += 4;
			amount = wheat;
			logger.info("Collected: " + amount + " wheat");
		}
		if(action.equals(mo)){
			model.bobMoveToField();
		}
		if(action.equals(wa)){
			model.bobWater();
		}
		if(action.equals(ha)){
			model.bobHarvest();
		}
		if(action.equals(gp)){
			model.bobGetPayment();
		}
		if(action.equals(le)){
			model.bobLeave();
		}
		
	}
	void executeActionJim(Structure action, int amount){
		if(action.equals(co)){
			corn += 4;
			amount = corn;
			logger.info("Collected: " + amount + " corn");
		}
		if(action.equals(mo)){
			model.jimMoveToField();
		}
		if(action.equals(wa)){
			model.jimWater();
		}
		if(action.equals(ha)){
			model.jimHarvest();
		}
		if(action.equals(gp)){
			model.jimGetPayment();
		}
		if(action.equals(le)){
			model.jimLeave();
		}
	}
	void executeActionPaul(Structure action, int amount){
		if(action.equals(co)){
			barley += 4;
			amount = barley;
			logger.info("Collected: " + amount + " barley");
		}
		if(action.equals(mo)){
			model.paulMoveToField();
		}
		if(action.equals(wa)){
			model.paulWater();
		}
		if(action.equals(ha)){
			model.paulHarvest();
		}
		if(action.equals(gp)){
			model.paulGetPayment();
		}
		if(action.equals(le)){
			model.paulLeave();
		}
	}
	void executeActionManager(Structure action, int amount){
		if(action.equals(mo)){
			model.managerMoveToFarmHouse();
		}
		if(action.equals(se)){
			amount = barley+wheat+corn;
			logger.info(amount + " gooods sold!");
			barley -= 4;
			wheat -= 4;
			corn -=4;
			amount = barley+wheat+corn;
			logger.info("Remaining number of goods: " + amount);
		}
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
	}

    /** Called before the end of MAS execution */
    @Override
    public void stop() {
        super.stop();
    }
}
