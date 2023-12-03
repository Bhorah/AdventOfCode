package Day01;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

/**
 * @author broy
 * @created 01/12/2023 - 10:46
 * @project AdventOfCode
 */

public class Exercise1 {

    public Exercise1() throws IOException {

        List<String> list = Files.readAllLines(new File("src/Day01/ressources/coords.txt").toPath(), Charset.defaultCharset());


        int sum = list.stream().map(line -> {

            String regex = "([0-9])|(one)|(two)|(three)|(four)|(five)|(six)|(seven)|(eight)|(nine)";

            String[] matches = Pattern.compile(regex)
                    .matcher(line)
                    .results()
                    .map(MatchResult::group)
                    .toArray(String[]::new);
            String var1 = stringToNumber(matches[0]);
            String var2 = stringToNumber(matches[matches.length-1]);
            return  var1+ var2 ;
        }).map(var -> Integer.valueOf(var)).reduce(0, Integer::sum);

        System.out.println(sum);
    }


    public String stringToNumber(String txt) {
        switch (txt) {
            case "one":
                return "1";
            case "two":
                return"2";
            case "three":
                return"3";
            case "four":
                return "4";
            case"five":
                return "5";
            case "six":
                return "6";
            case "seven":
                return "7";
            case "eight":
                return "8";
            case "nine":
                return "9";
            default:
                return txt;
        }
    }


}

