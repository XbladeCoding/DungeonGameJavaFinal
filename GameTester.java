public class GameTester {
    public static void main(String[] args) {
        Game game = new Game();

        if (game != null) {
            System.out.println("PASS: game object created");
        } else {
            System.out.println("FAIL: game object not created");
        }

        game.endGame();
        System.out.println("PASS: endGame runs without crashing");
    }
}