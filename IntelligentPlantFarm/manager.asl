// Agent manager in project intelligentPlantFarm

/* Initial BELIEFS*/

/* Initial goals */

!start.
!manageFarm.


/* Plans */

+!start : true <- .wait(500); 
				  .print("Let's Work!");
				  !at(manager,start).

+!at(manager,P):at(manager,P)
	<- true.
	
+!at(manager,P): not at(manager,P)
	<- move_to_destination(P,0);
		!at(manager,P).	

+!manageFarm : true <- .wait(1000);
						.print("Bob plant some potato!");
				  		.send(farmerBob, tell, plant);
						.wait(4000);
						.print("Jim plant some carrot!");
						.send(farmerJim, tell, plant).
						
+!resolve [source (farmerBob)] <- .print("Alright you can plant corn, Paul will plant some potato then!");
									.send(farmerBob, achieve, plant);
									.wait(2000);
									.send(farmerPaul, tell, plant).						
				  
+!resolve [source(farmerPaul)] <- .print("We need potatoes, so please plant some.");
									.send(farmerPaul, achieve, persuade).
						
+harvestDone [source(farmerPaul)] <- .print("Harvest is closing near!").
				
+harvestDone [source(farmerJim)] <- .print("Harvest is uppon us!").
				
+harvestDone [source(farmerBob)] <- .print("It's harvest time!");
									.wait(1500);
									.broadcast(tell, harvest).
				
+!harvestTime <- .print("Sell Goods!");
					.wait(2000);
					.print("Dividing payment equally");
					.print("Sending payment");
					.broadcast(achieve, payment).


