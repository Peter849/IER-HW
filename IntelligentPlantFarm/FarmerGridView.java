import jason.environment.grid.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.logging.*;

public class FarmerGridView extends GridWorldView{
    private FarmGridModel model;
	private Logger logger = Logger.getLogger("IntelligentPlantFarm.mas2j."+FarmerGridView.class.getName());
	
    public FarmerGridView(FarmGridModel m){
        super(m,"Intelligent Plant Farm",700);
        model=m;
        defaultFont = new Font("Arial", Font.BOLD, 16);
        setVisible(true);
        repaint();
    }
    @Override
    public void draw(Graphics g, int x, int y, int object){ 	
		String label="label!";
        switch(object){
            case FarmGridModel.SOIL0:
				super.drawObstacle(g,x,y);
                break;
            case FarmGridModel.SOIL1:
				super.drawObstacle(g,x,y);
                break;
			case FarmGridModel.SOIL2:
				super.drawObstacle(g,x,y);
                break;
			case FarmGridModel.SOIL3:
				super.drawObstacle(g,x,y);
                break;
			case FarmGridModel.SOIL4:
				super.drawObstacle(g,x,y);
                break;
			case FarmGridModel.SOIL5:
				super.drawObstacle(g,x,y);
                break;
			case FarmGridModel.SOIL6:
				super.drawObstacle(g,x,y);
                break;
			case FarmGridModel.SOIL7:
				super.drawObstacle(g,x,y);
                break;
			case FarmGridModel.SOIL8:
				super.drawObstacle(g,x,y);
                break;
			case FarmGridModel.SOIL9:
				super.drawObstacle(g,x,y);
                break;
			case FarmGridModel.SOIL10:
				super.drawObstacle(g,x,y);
                break;
			case FarmGridModel.SOIL11:
				super.drawObstacle(g,x,y);
                break;
			case FarmGridModel.FARMHOUSELEFT:
				super.drawObstacle(g,x,y);
				break;
			case FarmGridModel.FARMHOUSERIGHT:
				super.drawObstacle(g,x,y);
                break;
			case FarmGridModel.SILO:
				super.drawObstacle(g,x,y);
                break;
        }
    }
    @Override
    public void drawAgent(Graphics g, int x, int y, Color c, int id){
		String label="label";
		c=Color.yellow;
		switch(id){
			case 0:
				label="Manager";
				c=Color.green;
				break;
			case 1:
				label="Bob";
				c=Color.red;
				break;
			case 2:
				label="Jim";
				c=Color.red;
				break;
			case 3:
				label="Paul";
				c=Color.red;
				break;
			case 40,41,42,43:
				label="Wheat";
				c=Color.yellow;
				break;
			case 8,9,10,11:
				label="Corn";
				c=Color.yellow;
				break;
			case 12,13,14,15:
				label="Barley";
				c=Color.yellow;
				break;
			default:
				logger.info("Invalid argument: Agent is not existing!");
				break;
		}
        super.drawAgent(g,x,y,c,-1);
        g.setColor(Color.black);
        super.drawString(g, x, y, defaultFont, label);
    }
}
