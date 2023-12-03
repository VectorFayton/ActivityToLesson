// GameEngine.java
abstract class TextBasedGameEngine {
    // Template Method
    public void playGame() {
        initializeGame();
        while (!gameOver()) {
            takeTurn();
            displayScore();
        }
        endGame();
    }

    // Hooks for game-specific logic
    protected abstract void initializeGame();
    protected abstract void takeTurn();
    protected abstract boolean gameOver();
    protected abstract void displayScore();
    protected abstract void endGame();
}

// QuizGame.java
class QuizGame extends TextBasedGameEngine {
    private int score;

    // Game-specific logic for QuizGame
    @Override
    protected void initializeGame() {
        System.out.println("Initializing Quiz Game...");
        score = 0;
    }

    @Override
    protected void takeTurn() {
        System.out.println("Taking a quiz turn...");
        // Quiz-specific turn-taking logic
        // Increment the score for demonstration purposes
        score += 10;
    }

    @Override
    protected boolean gameOver() {
        // Quiz-specific game over condition
        return score >= 30; // Game ends when the score reaches 30
    }

    @Override
    protected void displayScore() {
        // Quiz-specific score display
        System.out.println("Current Score: " + score);
    }

    @Override
    protected void endGame() {
        System.out.println("Quiz Game Over. Final Score: " + score);
    }
}

// AdventureGame.java
class AdventureGame extends TextBasedGameEngine {
    private int steps;

    // Game-specific logic for AdventureGame
    @Override
    protected void initializeGame() {
        System.out.println("Initializing Adventure Game...");
        steps = 0;
    }

    @Override
    protected void takeTurn() {
        System.out.println("Taking an adventure turn...");
        // Adventure-specific turn-taking logic
        // Increment the steps for demonstration purposes
        steps++;
    }

    @Override
    protected boolean gameOver() {
        // Adventure-specific game over condition
        return steps >= 5; // Game ends after 5 steps
    }

    @Override
    protected void displayScore() {
        // Adventure-specific score display
        System.out.println("Current Steps: " + steps);
    }

    @Override
    protected void endGame() {
        System.out.println("Adventure Game Over. Total Steps: " + steps);
    }
}

// GameEngineTest.java
public class Main {
    public static void main(String[] args) {
        // Test QuizGame
        TextBasedGameEngine quizGame = new QuizGame();
        quizGame.playGame();

        System.out.println("\n---------------------------\n");

        // Test AdventureGame
        TextBasedGameEngine adventureGame = new AdventureGame();
        adventureGame.playGame();
    }
}
