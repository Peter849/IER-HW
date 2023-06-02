// Agent farmerJim in project intelligentPlantFarm - CORN

/* Initial beliefs and rules */
corn.
lazy.
/* Initial goals */

!start.

/* Plans */

+!start : true <- .print("I'm ready for Work!").

+plant : corn <- 	.print("Getting necessary seed from Silo.");
					move;
					.print("I'm planting corn.");	
					moveField;
					.wait(3000);
					!water(corn);
					.send(manager, tell, harvestDone).

					
+!water(corn) <- .print("Watering corn");
					water;
					.wait(2000);
					.print("Corns are grown").
					
				
+harvest : lazy <- .print("I'm lazy i'll do it later");
					.wait(3000);
					-lazy;
					.print("It's time for me to harvest");
					!harvest.
									
+!harvest  <- .print("Harvesting corns");
				harvest;
				collected;
				.send(manager, achieve, harvestDone).	
				
+!payment <- .wait(1500);
			getPayment;
			.print("Thank you Sir, see you next season!");
			leave.
