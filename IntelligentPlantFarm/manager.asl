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
		addTask;
		!manageFarm.	
		
+!manageFarm : full(manager)
	<- .print("wait");
		waitForTask;
	   !manageFarm.	
	   
+!sendTasks
	<-	.send(farmerBob, tell, tellTask);
	    //.send(farmerJim, tell, tellTas(X));
	    //.send(farmerPaul, tell, tellTask(X));
		!sendTasks.
		
+receivedTask[source(farmerJim)] <- .print("OK").
