package Day01;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

import static org.apache.commons.io.FileUtils.readFileToString;

/**
 * @author broy
 * @created 01/12/2023 - 10:46
 * @project AdventOfCode
 */

public class Exercise1 {

    public Exercise1() throws IOException {

        List<String> list = Files.readAllLines(new File("src/Day01/ressources/coords.txt").toPath(), Charset.defaultCharset());

        int sum = list.stream().map(line -> {




            line = line.replaceAll("[^0-9]+","");
            return line.charAt(0) + String.valueOf(line.charAt(line.length()-1));
        }).map(var -> Integer.valueOf(var)).reduce(0, Integer::sum);

        System.out.println(sum);
    }




}

