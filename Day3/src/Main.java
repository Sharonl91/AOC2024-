import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/Day3Input.txt");
//        ArrayList<String> answer = new ArrayList<>();
        int total = 0;
//        Pattern p = Pattern.compile("mul\\((\\d{1,3}),(\\d{1,3})\\)|do\\(\\)|don't\\(\\)");
//        for(String sentence : fileData) {
//            Matcher m = p.matcher(sentence);
//            for (int start = 0; start < sentence.length();start++){
//                sentence = sentence.substring(start);
//                if (m.find()) {
//                    answer.add(m.group());
//                }
//            }
//        }
        String input = String.valueOf(fileData);
        int index = 0;
        while (index != -1) {
            if (input.indexOf("don't()", index) != -1 && input.indexOf("don't()", index) < input.indexOf("mul(", index)) {
                index = input.indexOf("do()", index);
                continue;
            }
            index = input.indexOf("mul(", index);
            if (index > input.length() || index == -1)
                break;

            index += 4;

            String num1 = "";
            while (Character.isDigit(input.charAt(index))) {
                num1 += input.charAt(index++);
            }
            if (input.charAt(index++) != ',')
                continue;
            String num2 = "";
            while (Character.isDigit(input.charAt(index))) {
                num2 += input.charAt(index++);
            }
            if (input.charAt(index++) != ')')
                continue;
            if (num1.equals("") || num2.equals(""))
                continue;

            total += Integer.parseInt(num1) * Integer.parseInt(num2);
        }

        System.out.println(Integer.toString(total));
    }
//        for (String i : answer){
//            if((i.charAt(0) == 'm') && skip == false){
//                i=i.substring(4);
//                int len = i.length();
//                i=i.substring(0,len-1);
//                String[] xy = i.split(",");
//                int x = Integer.parseInt(xy[0]);
//                int y = Integer.parseInt(xy[1]);
//                total+=x*y;
//            }
//            else if((i.charAt(0) == 'd')){
//                if (!(i.contains("n"))) {
//                    skip = false;
//                }
//                if(i == "don\'t\\(\\)"){
//                    skip=true;
//                }
//            }
//            else {
//                skip=true;
//            }
//            System.out.println(i);
//            System.out.println(skip);
//            System.out.println(total);
//        }
//        System.out.println(total);
//    }
    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
}