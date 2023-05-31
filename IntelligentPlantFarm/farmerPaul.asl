// Agent farmerPaul in project intelligentPlantFarm - He likes to plant mainly BARLEY

/* Initial beliefs and rules */
carrot.
/* Initial goals */

!start.

/* Plans */
+!start : true <- .print("I'm farmer Paul, and ready for Work!");
				  !at(farmerPaul,start).

+!at(farmerPaul,P):at(farmerPaul,P)
	<- true.
	
+!at(farmerPaul,P): not at(farmerPaul,P)
	<- move_to_destination(P,3);
		!at(farmerPaul,P).	

+!plant : potato <- .print("I'm planting potato");	//+plant
					.wait(2500);
					!water(potato);
					.send(manager, tell, harvestDone).

+plant : carrot <- .print("I don't plant potatoes");
					.send(manager, achieve, resolve).

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
				
+!payment <- .print("Thank you Sir, see you next season!").				
				
