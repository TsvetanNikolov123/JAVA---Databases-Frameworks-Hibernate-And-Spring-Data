package app;

import app.tasks.*;

import java.sql.Connection;

public class Engine implements Runnable {
    private Connection connection;

    public Engine(Connection connection) {
        this.connection = connection;
    }

    public void run() {
        /**
         *  2.	Get Villains’ Names
         */
//        P02_GetVillainsNames getVillainsNames = new P02_GetVillainsNames(this.connection);
//        getVillainsNames.run();

        /**
         *  3.   Get Minion Names
         */
//        P03_GetMinionNames getMinionNames = new P03_GetMinionNames(this.connection);
//        getMinionNames.run();

        /**
         *  4.	Add Minion
         */
//        P04_AddMinion addMinion = new P04_AddMinion(this.connection);
//        addMinion.run();

        /**
         *  5.	Change Town Names Casing
         */
//        P05_ChangeTownNamesCasing changeTownNamesCasing = new P05_ChangeTownNamesCasing(this.connection);
//        changeTownNamesCasing.run();

        /**
         *  6.	*Remove Villain
         */
//        P06_RemoveVillain removeVillain = new P06_RemoveVillain(this.connection);
//        removeVillain.run();

        /**
         *  7.	Print All Minion Names
         */
//        P07_PrintAllMinionNames printAllMinionNames = new P07_PrintAllMinionNames(this.connection);
//        printAllMinionNames.run();

        /**
         *  8.	Increase Minions Age
         */
//        P08_IncreaseMinionsAge increaseMinionsAge = new P08_IncreaseMinionsAge(this.connection);
//        increaseMinionsAge.run();

        /**
         *  9.	Increase Age Stored Procedure
         */
//        P09_IncreaseAgeStoredProcedure increaseAgeStoredProcedure = new P09_IncreaseAgeStoredProcedure(this.connection);
//        increaseAgeStoredProcedure.run();
    }
}
