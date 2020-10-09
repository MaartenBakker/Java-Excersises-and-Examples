public class Main {

    public static void main(String[] args) {
        boolean gameOver = true;
        int score = 800;
        int levelCompleted = 5;
        int bonus = 100;

        int highScore = calculateScore(gameOver, score, levelCompleted, bonus);
        System.out.println("The final score was " + highScore);


        highScore = calculateScore(true, 10000,8,200);
        System.out.println("The final score was " + highScore);

        displayHighScorePosition("Maarten", calculateHighScorePosition(1500));
        displayHighScorePosition("Maarten", calculateHighScorePosition(900));
        displayHighScorePosition("Maarten", calculateHighScorePosition(400));
        displayHighScorePosition("Maarten", calculateHighScorePosition(50));



    }

    public static void displayHighScorePosition(String name, int position ) {
        System.out.println(name + " managed to get into position " + position + " on the hight score table");
    }

    public static int calculateHighScorePosition(int score) {

//        if (score >= 1000) return 1;
/*
        if (score >= 500) return 2;
        if (score >= 100) return 3;
        return 4;
*/

        int position = 4;
        if (score >= 1000) position = 1;
        else if (score >= 500) position = 2;
        else if (score >= 100) position = 3;

        return position;
    }

    public static int calculateScore(boolean gameOver, int score, int levelCompleted, int bonus) {

        if (gameOver) {
            int finalScore = score + (levelCompleted * bonus);
            finalScore += 2000;
            return finalScore;
        }

        return -1;

    }
}
