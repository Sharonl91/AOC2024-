import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("Day2/src/Day2Input");
        System.out.println(getAnswer(fileData));

    }

    public static int getAnswer(ArrayList<String> fileData) {
        ArrayList<Integer> levels = new ArrayList<>();
        int safeCount = 0;
        for (int i = 0; i < fileData.size(); i++) {
            String line = fileData.get(i);
            String[] num = line.split(" ");
            for(int j = 0; j < num.length;j++){
                levels.add(j,Integer.parseInt(num[j]));
            }
            boolean s = checkSafe(levels);
            if (s){
                safeCount++;
            }
            levels.clear();
        }
        return safeCount;
    }
    public static boolean checkSafe(ArrayList<Integer> levels){
        int diff = 0;
        boolean safe = false;
        boolean in = false;
        int safeCount = 1;
        diff = levels.get(0) - levels.get(1);
        if (diff < 0){
            in = true;
        }
        for(int i = 1; i < levels.size(); i++){
            diff = levels.get(i-1) - levels.get(i);
            if(!in && (diff >= 1 && diff <= 3)){
                safe = true;
            }
            else if(in && (diff <= -1 && diff >= -3)){
                safe = true;
            }
            else {
                safeCount--;
            }
        }
        if (safeCount <= 0){
            safe = false;
        }
        return safe;
    }

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