class TrafficSignal extends Thread {
    private String[] signals = {"Red", "Green", "Yellow"};
    @Override
    public void run() {
        while (true) {
            try {
                for (String signal : signals) {
                    System.out.println("Signal: " + signal);
                    switch (signal) {
                        case "Red":
                            Thread.sleep(2000); // Red for 5 seconds
                            break;
                        case "Yellow":
                                Thread.sleep(4000);
                                break;
                                case "Green":
                                Thread.sleep(5000); // Green for 2 seconds
                                break;
                        default:
                                System.out.println("the signel is resetted"); // Yellow for 2 seconds
                                break;

                    }
                }
            } catch (InterruptedException e) {
                System.out.println("Signal interrupted");
            }
        }
    }
}

public class Slip3B {
    public static void main(String[] args) {
        TrafficSignal signal = new TrafficSignal();
        signal.start();
    }
}
