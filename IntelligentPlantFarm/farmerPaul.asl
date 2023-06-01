// Agent farmerPaul in project intelligentPlantFarm - BARLEY

/* Initial beliefs and rules */
corn.
/* Initial goals */

!start.

/* Plans */
+!start : true <- .print("I'm ready for Work!").

+!plant : barley <- 	move;
					.print("I'm planting barley");	//+plant
					.wait(2500);
					!water(barley);
					.send(manager, tell, harvestDone).

+plant : corn <- .print("I don't plant barley");
					.send(manager, achieve, resolve).

+!persuade <- .print("Alright, I will plant barley");
				-corn;
				+barley;
				!plant.  //+plant
				
+!water(barley) <- .print("Watering barley");
					water;
					.wait(3500);
					.print("Barley is grown").
					
+harvest <- .print("Harvesting barley");
				harvest;
				collected.			
				
+!payment <- getPayment;
			.print("Thank you Sir, see you next season!");
			leave.
