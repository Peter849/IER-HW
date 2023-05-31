// Agent farmerJim in project intelligentPlantFarm - He likes to plant mainly WHEAT

/* Initial beliefs and rules */
//wheat.

/* Initial goals */
!start.

/* Plans */

+!start : true <- .print("I'm farmer Bob, and ready for Work!");
				  !at(farmerBob,start). 
				  				  
+!at(farmerBob,P):at(farmerBob,P)
	<- true.
	
+!at(farmerBob,P): not at(farmerBob,P)
	<- move_to_destination(P,1);
		!at(farmerBob,P).				  
				  
+!plant : wheat <- .print("I'm planting WHEAT");
					.wait(3000);
					!water(wheat);
					drawCorn;
					.send(manager, tell, harvestDone).
					
+plant : not wheat <- .print("I'm only planting WHEAT");
						.send(manager, achieve, resolve);
						+wheat.					
						
+!water(wheat) <- .print("Watering WHEAT");
					waterCorn;
					.wait(11000);
					.print("WHEAT is grown").
					
+harvest <- .print("Harvesting WHEAT");
				.wait(4000);
				//resetWheat;
				.print("WHEAT is collected").	
				
+!payment <- .print("Thank you Sir, see you next season!").				
				
