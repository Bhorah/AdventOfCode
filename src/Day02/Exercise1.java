package Day02;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author broy
 * @created 02/12/2023 - 15:39
 * @project AdventOfCode
 */
public class Exercise1 {


    public Exercise1() throws IOException {

        List<String> games = Files.readAllLines(new File("src/Day02/ressources/games.txt").toPath(), Charset.defaultCharset());

        int red = 12;
        int green = 13;
        int blue = 14;

        Integer answer = 0;

        for (String game : games) {
            int id = Integer.parseInt(game.split(":")[0].split(" ")[1]);

            int biggestRed = getBiggestOfColor(game, "red");
            int biggestGreen = getBiggestOfColor(game, "green");
            int biggestBlue = getBiggestOfColor(game, "blue");


            if(biggestBlue <= blue && biggestGreen <= green && biggestRed <= red){
                answer += id;
            }
        };

        System.out.println(answer);
    }


    public int getBiggestOfColor(String game, String colorName){

        List<String> colorList = new ArrayList<>(Arrays.stream(game.split(" "+colorName)).toList());

        for(int i = 0; i <colorList.size() ; i++ ){
            if (!Character.isDigit(colorList.get(i).charAt(colorList.get(i).length()-1))){
                colorList.remove(i);
            }
        }

        int biggestNumber = 0;

        for (String extract: colorList) {

            String[] subExtract = extract.split(" ");

            if (Integer.valueOf(subExtract[subExtract.length-1]) > biggestNumber){
                biggestNumber = Integer.valueOf(subExtract[subExtract.length-1]);
            }

        };

        return biggestNumber;
    }

}
