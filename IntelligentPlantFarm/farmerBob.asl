// Agent farmerJim in project intelligentPlantFarm

/* Initial beliefs and rules */
//corn.
/* Initial goals */

!start.

/* Plans */

+!start : true <- .print("I'm ready for Work!").

+!plant : corn <- .print("I'm planting corn");
					.wait(3000);
					!water(corn);
					.send(manager, tell, cornDone).
					
+plant : not potato <- .print("I'm only planting corn");
						.send(manager, achieve, resolve);
						+corn.					

					
+!water(corn) <- .print("Watering corn");
					.wait(11000);
					.print("Corn is grown").
					
+harvest <- .print("Harvesting corn");
				.wait(4000);
				.print("Corn is collected").							
				
