import java.util.Scanner;
import java.util.Random;

public class ChroniclesOfEldoria {
    
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    
    public static void main(String[] args) {
        System.out.println("Welcome to Chronicles of Eldoria!");

        boolean gameRunning = true;

        while (gameRunning) {
            intro();

            if (!fightGuard()) continue;
            if (!solveRiddle()) continue;
            if (!combatEncounter()) continue;
            if (!hallwayDecision()) continue;
            if (!finalBattle()) continue;

            System.out.println("Congratulations! You have retrieved the Crystal of Light and saved the kingdom of Eldoria.");
            gameRunning = false;  // Ends the game after victory
        }
    }

    private static boolean intro() {
    System.out.println("Shrouded in darkness, your eyes flicker open to the cold, damp air of the Eldoria dungeon...");
    System.out.println("With a heavy heart, you recall your quest – to find the fabled Crystal of Light,");
    System.out.println("the kingdom's last hope against the encroaching evil.");
    System.out.println("As your eyes adjust, the silhouette of a guard becomes clear.");
    System.out.println("The first obstacle in your path to destiny awaits.");
    System.out.println("Gathering your courage, you move stealthily in the shadows, preparing to face your fate.");
    return promptEnterKey();
}


private static boolean fightGuard() {
    System.out.println("\nYou steady your breath and ready your stance. The guard hasn't noticed you... yet.");
    System.out.println("It's now or never. Do you choose to fight the guard (1) or try to sneak past (2)?");
    System.out.print("Your choice [1-2]: ");
    
    int choice = scanner.nextInt();
    scanner.nextLine(); // Consume newline left-over
    
    if (choice == 1) {
        System.out.println("You decide to take on the guard. You must roll a 5 or higher to succeed.");
        return rollForSuccess("combat");
    } else if (choice == 2) {
        System.out.println("You attempt to move silently and sneak past the guard. You must roll a 7 or higher to succeed.");
        return rollForSuccess("sneak");
    } else {
        System.out.println("Invalid choice. You lost a precious moment and the guard is now alert!");
        return false; // Automatically fail for an invalid choice
    }
}


   private static boolean solveRiddle() {
    System.out.println("\nYou come across a door with enigmatic inscriptions that seem to shift before your eyes.");
    System.out.println("A disembodied voice booms through the chamber, 'Answer my riddle, and you may pass. Fail, and be forever lost.'");
    System.out.println("The riddle is: 'I speak without a mouth and hear without ears. I have no body, but I come alive with wind. What am I?'");

    System.out.print("Your answer: ");
    String answer = scanner.nextLine().trim().toLowerCase();

    if (answer.equals("echo")) {
        System.out.println("The door creaks open, and a path forward is revealed. You've solved the riddle!");
        return true;
    } else {
        System.out.println("The voice booms, 'Incorrect! The path forward remains hidden.' You must solve the riddle to proceed.");
        return false;
    }
}


    private static boolean combatEncounter() {
    System.out.println("\nAs the riddle's answer leaves your lips, the door grudgingly opens to reveal a vast, dim chamber.");
    System.out.println("A demonic figure emerges from the shadows, its eyes burning with malice.");
    System.out.println("There's no way around it; you must fight!");

    // Simulate combat encounter with a demon
    System.out.println("To defeat the demon, you must roll a 5 or higher.");
    boolean victory = rollForSuccess("combat");

    if (victory) {
        System.out.println("The demon lets out a terrible howl as it dissipates into the ether.");
        System.out.println("You've won the battle, but the war for Eldoria continues.");
        return true;
    } else {
        System.out.println("Overwhelmed by the demon's power, you succumb to your wounds.");
        System.out.println("As darkness closes in, you realize you must start your quest anew.");
        // In an actual game, you would handle restarting the game here
        return false;
    }
}


    private static boolean hallwayDecision() {
    System.out.println("\nBreathing heavily from the battle, you find yourself at the end of a long, torch-lit hallway.");
    System.out.println("The hallway splits into two, one veering left, the other right.");
    System.out.println("To the left, you can see a guard's shadow flickering against the wall.");
    System.out.println("To the right, an ornate door looms, likely locked, but perhaps holding the way forward.");

    System.out.print("Will you go left towards the guard (1), or right towards the locked door (2)? Enter your choice [1-2]: ");
    int choice = scanner.nextInt();
    scanner.nextLine(); // Consume newline left-over

    if (choice == 1) {
        System.out.println("You choose to sneak past the guard on the left.");
        System.out.println("You must roll a 7 or higher to sneak past successfully.");
        return rollForSuccess("sneak");
    } else if (choice == 2) {
        System.out.println("You choose to try your luck with the locked door on the right.");
        System.out.println("You must roll a 7 or higher to pick the lock and proceed.");
        return rollForSuccess("lockpick");
    } else {
        System.out.println("Confused, you hesitate and neither path is taken. You must choose quickly!");
        return false; // Automatically fail for an invalid choice
    }
}


    private static boolean finalBattle() {
    System.out.println("\nAfter navigating the treacherous hallways, you enter a vast cavern illuminated by a faint, ethereal glow.");
    System.out.println("In the center, atop a pile of gold and jewels, lies the Crystal of Light. Guarding it, a dragon of immense size watches you intently.");
    System.out.println("Its scales shimmer with arcane energy as it readies itself for your challenge.");
    System.out.println("This is the final battle for the fate of Eldoria!");

    // Simulate final battle with the dragon
    System.out.println("To defeat the dragon and claim the Crystal of Light, you must roll an 8 or higher.");
    boolean victory = rollForSuccess("finalCombat");

    if (victory) {
        System.out.println("With a mighty effort, you strike true, and the dragon lets out a final, thunderous roar before collapsing.");
        System.out.println("The path to the Crystal of Light is clear. The kingdom of Eldoria will sing praises of your valor for generations to come.");
        return true;
    } else {
        System.out.println("The dragon proves too powerful, its fiery breath consuming all hope.");
        System.out.println("You fall in battle, and with your last breath, you wish for another chance to save Eldoria...");
        // In an actual game, you would handle restarting the game or ending the session here
        return false;
    }
}


    private static boolean promptEnterKey() {
        System.out.println("Press \"ENTER\" to continue...");
        scanner.nextLine();
        return true;
    }

private static boolean rollForSuccess(String actionType) {
    int roll = random.nextInt(10) + 1;
    int successThreshold;

    if (actionType.equals("combat") || actionType.equals("finalCombat")) {
        successThreshold = 5;
    } else {
        successThreshold = 7;
    }

    if (roll >= successThreshold) {
        System.out.println("Success! You've managed to " + (actionType.equals("combat") || actionType.equals("finalCombat") ? "defeat your enemy." : "perform the action."));
        return true;
    } else {
        System.out.println("Failure! You have been defeated and must start over.");
        return false;
    }
}



    private static boolean choosePath() {
        System.out.println("Do you choose to go left (1) or right (2)?");
        System.out.print("Your choice [1-2]: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the rest of the line
        
        if (choice == 1) {
            // Sneak past the guard logic
            return rollForSuccess("sneak");
        } else {
            // Lockpick the door logic
            return rollForSuccess("lockpick");
        }
    }
}
