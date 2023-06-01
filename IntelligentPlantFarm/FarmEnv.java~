// Environment code for project IntelligentPlantFarm.mas2j

import jason.asSyntax.*;
import jason.environment.*;
import jason.asSyntax.parser.*;
import java.util.logging.*;
import jason.environment.grid.Location;


public class FarmEnv extends Environment {



    private Logger logger = Logger.getLogger("IntelligentPlantFarm.mas2j."+FarmEnv.class.getName());

	
	FarmGridModel model;


    /** Called before the MAS execution with the args informed in .mas2j */

    @Override

    public void init(String[] args) {

        super.init(args);

		model = new FarmGridModel();
		if (args.length == 1 && args[0].equals("gui")) {
            FarmerGridView view  = new FarmerGridView(model);
            model.setView(view);
        }
        try {

			addPercept(ASSyntax.parseLiteral("percept(demo)"));

		} catch (ParseException e) {

			e.printStackTrace();

		}

    }



    @Override

    public boolean executeAction(String agName, Structure action) {

        logger.info("executing: "+action+", but not implemented!");

        if (true) { // you may improve this condition

             informAgsEnvironmentChanged();

        }

        return true; // the action was executed with success

    }



    /** Called before the end of MAS execution */

    @Override

    public void stop() {

        super.stop();

    }

}


