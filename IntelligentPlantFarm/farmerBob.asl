// Agent farmerJim in project intelligentPlantFarm

/* Initial beliefs and rules */

!check(slots).

/* Initial goals */

!start.

/* Plans */

+!start : true <- .print("hello world.").

+!check(slots) : not pos(farmerJim,6,6)
	<- next(slot);
	!check(slots).
	
+tellTask[source(manager)] <- .print("I received a task").
