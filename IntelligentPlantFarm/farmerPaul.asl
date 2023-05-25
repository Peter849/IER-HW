// Agent farmerPaul in project intelligentPlantFarm

/* Initial beliefs and rules */
carrot.
/* Initial goals */

!start.

/* Plans */
+!start : true <- .print("I'm ready for Work!").

+!plant : potato <- .print("I'm planting potato");	//+plant
					.wait(2500);
					!water(potato);
					.send(manager, tell, potatoDone).

+plant : carrot <- .print("I don't plant potatoes");
					.send(manager, achieve, paulDisagree).

+!persuade <- .print("Alright, I will plant potatoes");
				-carrot;
				+potato;
				!plant.  //+plant
				
+!water(potato) <- .print("Watering potatoes");
					.wait(3500);
					.print("Potatoes are grown").
					
+harvest <- .print("Harvesting potato");
				.wait(4000);
				.print("Potatoes are collected").					
				
