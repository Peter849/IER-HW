// Agent farmerPaul in project intelligentPlantFarm

/* Initial beliefs and rules */

/* Initial goals */

!start.

/* Plans */

+!start : true <- .print("hello world.").

+tellTask[source(manager)] <- .print("I received a task").
