// Agent manager in project intelligentPlantFarm

/* Initial BELIEFS*/

//!manageFarm.
!sendTasks.
value(0).
	
/* Initial goals */

!start.

/* Plans */

+!start : true <- .print("hello world.").
	
+!manageFarm : not full(manager)
	<- 	.print("add task");
		.random(X);
		addTask;
		!manageFarm.	
		
+!manageFarm : full(manager)
	<- .print("wait");
		waitForTask;
	   !manageFarm.	
	   
+!sendTasks
	<-	.send(farmerBob, tell, tellTask);
	    .send(farmerJim, tell, tellTask);
	    .send(farmerPaul, tell, tellTask);
		!sendTasks.
+receivedTask[source(farmerJim)] <- .print("OK").
