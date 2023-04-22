
public class Main {
    private static final String inputPath = "input\\";
    private static final String outputPath = "output\\";

    private static final String[] fileNames = {
            "00-example.txt",
            "01-chilling-cat.txt",
            "02-swarming-ant.txt",
            "03-input-anti-greedy.txt",
            "04-input-low-points.txt",
            "05-input-opposite-points-hole.txt",
            "06-input-reply-running-man.txt"
    };
    public static void main(String[] args) {
        CustomInputReader reader = new CustomInputReader(inputPath+fileNames[0]);
        Map map = reader.readMap();
        Snake[] snakes = reader.readSnakes();

        System.out.println(map.toString());
        for(Snake s: snakes) System.out.println(s.toString());
    }
}