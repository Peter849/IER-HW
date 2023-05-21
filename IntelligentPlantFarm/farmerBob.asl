// Agent farmerJim in project intelligentPlantFarm

/* Initial beliefs and rules */

!getSeed.

/* Initial goals */

!start.

/* Plans */

+!start : true <- .print("hello world.").

+!getSeed : not pos(farmerBob,9,5)
	<- next(slot);
	!getSeed.

+tellTask[source(manager)] <- .print("I received a task");
							  permit.
