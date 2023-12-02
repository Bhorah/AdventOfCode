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
 * @created 01/12/2023 - 09:37
 * @project Default (Template) Project
 */
public class Main {

    public static void main(String[] args) throws IOException {

        List<String> games = Files.readAllLines(new File("src/Day02/ressources/games.txt").toPath(), Charset.defaultCharset());


//        exercise1(games);
        exercise2(games);


    }

    public static void exercise1(List<String> games){
        
        int maxRed = 12;
        int maxGreen = 13;
        int maxBlue = 14;

        Integer answer = 0;

        for (String game : games) {
            int id = Integer.parseInt(game.split(":")[0].split(" ")[1]);

            int biggestRed = getBiggestOfColor(game, "red");
            int biggestGreen = getBiggestOfColor(game, "green");
            int biggestBlue = getBiggestOfColor(game, "blue");


            if(biggestBlue <= maxBlue && biggestGreen <= maxGreen && biggestRed <= maxRed){
                answer += id;
            }
        };

        System.out.println(answer);
    }


    public static void exercise2(List<String> games) {

        long answer = 0;

        for (String game : games) {

            int biggestRed = getBiggestOfColor(game, "red");
            int biggestGreen = getBiggestOfColor(game, "green");
            int biggestBlue = getBiggestOfColor(game, "blue");

            if(biggestBlue != 0 && biggestRed != 0 && biggestGreen != 0){
                answer += biggestRed * biggestGreen * biggestBlue;
            }
        }
        System.out.println(answer);
    }


    public static int getBiggestOfColor(String game, String colorName){

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