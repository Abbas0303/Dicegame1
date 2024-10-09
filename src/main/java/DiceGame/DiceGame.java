package DiceGame; // Definierar paketnamnet för klassen

import java.util.Random; // Importerar Random-klassen för att generera slumpmässiga tal
import java.util.Scanner; // Importerar Scanner-klassen för att läsa indata från användaren

public class DiceGame {
    public static void main(String[] args) {
        // Skapa instanser av Scanner och Random
        Scanner scanner = new Scanner(System.in); // För att läsa användarens inmatning
        Random random = new Random(); // För att generera slumpmässiga tärningskast

        // Ange spelarnamn
        System.out.println("Välkommen till tvåspelartärningsspelet!"); // Välkomnar spelarna
        System.out.print("Spelare 1, ange ditt namn: "); // Frågar om spelare 1:s namn
        String player1Name = scanner.nextLine(); // Lagrar spelare 1:s namn
        System.out.print("Spelare 2, ange ditt namn: "); // Frågar om spelare 2:s namn
        String player2Name = scanner.nextLine(); // Lagrar spelare 2:s namn

        boolean playAgain = true; // Variabel för att hålla reda på om spelarna vill spela igen

        // Huvudloopen för spelet
        while (playAgain) {
            System.out.println("\n" + player1Name + ", tryck på enter för att kasta tärningen...");
            scanner.nextLine(); // Vänta på att spelare 1 ska trycka på enter
            int player1Roll = rollDice(random); // Kasta tärningen för spelare 1
            System.out.println(player1Name + " fick: " + player1Roll); // Visa resultatet

            System.out.println("\n" + player2Name + ", tryck på enter för att kasta tärningen...");
            scanner.nextLine(); // Vänta på att spelare 2 ska trycka på enter
            int player2Roll = rollDice(random); // Kasta tärningen för spelare 2
            System.out.println(player2Name + " fick: " + player2Roll); // Visa resultatet

            // Bestäm vinnaren
            if (player1Roll > player2Roll) {
                System.out.println("\nGrattis " + player1Name + "! Du vann denna omgång."); // Spelare 1 vinner
            } else if (player1Roll < player2Roll) {
                System.out.println("\nGrattis " + player2Name + "! Du vann denna omgång."); // Spelare 2 vinner
            } else {
                System.out.println("\nDet är oavgjort!"); // Om både får samma resultat
            }

            // Fråga om spelarna vill spela igen
            System.out.print("\nVill ni spela igen? (ja/nej): "); // Fråga om att spela igen
            String response = scanner.nextLine(); // Läs in svaret
            playAgain = response.trim().equalsIgnoreCase("ja"); // Om svaret är "ja", fortsätt spela
        }

        System.out.println("Tack för att ni spelade!"); // Avslutande meddelande
        scanner.close(); // Stäng Scanner för att frigöra resurser
    }

    // Metod för att kasta en tärning (1 till 6)
    public static int rollDice(Random random) {
        return random.nextInt(6) + 1; // Generera ett slumpmässigt tal mellan 1 och 6
    }
}
