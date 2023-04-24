import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

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
        CustomInputReader reader;
        Map map;
        Snake[] snakes;

        for(String fileName : fileNames){
            reader = new CustomInputReader(inputPath+fileName);
            map = reader.readMap();
            snakes = reader.readSnakes(map);

            for(Snake s : snakes) s.place();

            int totScore = 0;
            for(Snake s : snakes) {
                //System.out.println(s);
                totScore += s.getScore();
            }
            System.out.println(fileName+":\t"+totScore);

            writeOutput(snakes,fileName);
        }


    }

    private static void writeOutput(Snake[] snakes, String fileName){
        Path filePath = Paths.get(outputPath+fileName);
        ArrayList<String> lines = new ArrayList<>();
        for(Snake s : snakes){
            lines.add(s.getPath());
        }

        try{
            Files.write(filePath, lines, StandardCharsets.UTF_8);
        }catch(IOException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

}