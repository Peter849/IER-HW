// Agent farmerJim in project intelligentPlantFarm - WHEAT

/* Initial beliefs and rules */

/* Initial goals */

!start.

/* Plans */

+!start : true <- .print("I'm ready for Work!").

+!plant : wheat <- 	.print("Getting necessary seed from Silo.");
					move;
					.print("I'm planting wheat");	
					moveField;
					.wait(3000);
					!water(wheat);
					.send(manager, tell, harvestDone).
					
+plant : not wheat <- .print("I'm only planting wheat");
						.send(manager, achieve, resolve);
						+wheat.					

					
+!water(wheat) <- .print("Watering wheat");
					water;
					.wait(4000);
					.print("Wheat is grown").
					
+harvest <- .print("Harvesting wheat");
			harvest;
			collected. 
			
				
+!payment <- .wait(3000);
				getPayment;
				.print("Thank you Sir, see you next season!");
				leave.
				
