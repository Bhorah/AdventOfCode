package Day03;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.imageio.ImageTranscoder;

/**
 * @author broy
 * @created 03/12/2023 - 10:24
 * @project AdventOfCode
 */
public class Main {

    public static void main (String[] args) throws IOException {

        List<String> partsList = Files.readAllLines(new File("src/Day03/parts.txt").toPath(), Charset.defaultCharset());
        Character[][] partsTable = partsList.stream()
                .map(line -> line.chars().mapToObj(e -> (char)e).toArray(Character[]::new))
                .toArray(Character[][]::new);


        exercise1(partsTable);
        exercise2(partsTable);
    }


    public static void exercise1(Character[][] partsTable) {

        int sum = 0;

        for(int i = 0; i<partsTable.length; i++){

            String currentNumber = "";
            boolean isTop = i == 0;
            boolean isBottom = i == partsTable.length-1;


            for(int j=0; j<partsTable[0].length ; j++){

                boolean isRight = j == partsTable[0].length-1;

                if(!Character.isDigit(partsTable[i][j])){
                    currentNumber = "";
                    continue;
                }else {
                    currentNumber += partsTable[i][j];
                    if (!isRight && Character.isDigit(partsTable[i][j+1])){
                        continue;
                    }
                }

                boolean isLeft = j-currentNumber.length()<0;

                if((!isLeft && !Objects.equals(partsTable[i][j-currentNumber.length()],'.'))
                    || (!isRight && !Objects.equals(partsTable[i][j+1],'.'))
                    || (!isTop && (hasSymbolAdjacent(isLeft, isRight, partsTable[i-1], j, currentNumber)))
                    || (!isBottom && (hasSymbolAdjacent(isLeft, isRight, partsTable[i+1], j, currentNumber)))) {

                    sum += Integer.parseInt(currentNumber);
                }
            }
        }

        System.out.println(sum);
    }

    public static void exercise2(Character[][] partsTable){

        int sum = 0;

        for(int i = 0; i<partsTable.length; i++) {

            boolean isTop = i == 0;
            boolean isBottom = i == partsTable.length - 1;


            for (int j = 0; j < partsTable[0].length; j++) {

                boolean isLeft = j == 0;
                boolean isRight = j == partsTable[0].length - 1;

                if (!Character.isDigit(partsTable[i][j])) {
                    continue;
                }

            }
        }

    }

    public static boolean hasSymbolAdjacent(boolean isLeft, boolean isRight, Character[] lineToCheck, int j, String currentNumber){

        List<String> toCheck;

        if(isLeft){
            toCheck = new ArrayList<>(Arrays.stream(lineToCheck).toList().subList(j, j+2).stream().map(Object::toString).toList());
        }else if (isRight) {
            toCheck = new ArrayList<>(Arrays.stream(lineToCheck).toList().subList(j-currentNumber.length(), j+1).stream().map(Object::toString).toList());
        } else {
            toCheck = new ArrayList<>(Arrays.stream(lineToCheck).toList().subList(j-currentNumber.length(), j+2).stream().map(Object::toString).toList());
        }

        toCheck.removeIf(Pattern.compile("[0-9]|\\.").asPredicate());

        return toCheck.size()>0;

    }

}
