// Agent farmerJim in project intelligentPlantFarm

/* Initial beliefs and rules */
carrot.
lazy.
/* Initial goals */

!start.

/* Plans */

+!start : true <- .print("I'm ready for Work!").

+plant : carrot <- .print("I'm planting carrots");
					.wait(3000);
					!water(carrots);
					.send(manager, tell, harvestDone).

					
+!water(carrots) <- .print("Watering carrots");
					.wait(2000);
					.print("Carrots are grown").
					
				
+harvest : lazy <- .print("I'm lazy i'll do it later");
					.wait(7000);
					-lazy;
					.print("It's time for me to harvest");
					!harvest.
					
					
+!harvest  <- .print("Harvesting carrots");
				.wait(4000);
				.print("Carrots are collected");
				.send(manager, achieve, harvestTime).	
				
+!payment <- .print("Thank you Sir, see you next season!").				
				
				
