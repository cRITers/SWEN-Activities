public class Run {
    /*
     * Start the application.
     */
    public static void main(String[] args) {
        WeatherStation ws = new WeatherStation();
        Thread thread = new Thread(ws);
        TextUI ui = new TextUI(ws);
        SwingUI swingui = new SwingUI(ws);

        thread.start();
    }
}