import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day1Input.txt");
        System.out.println(getAnswer(fileData));
    }

    public static int getAnswer(ArrayList<String> fileData) {
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        int answer = 0;
        for (int i = 0; i < fileData.size(); i++) {
            String line = fileData.get(i);
            String[] separate = line.split("\\s+");
            left.add(i, Integer.parseInt(separate[0]));
            right.add(i, Integer.parseInt(separate[1]));
        }
        Collections.sort(left);
        Collections.sort(right);
        for (int j = 0; j < left.size();j++){
            int searchNum = left.get(j);
            int repeat = 0;
            for(int k = 0; k < right.size(); k++){
                if(right.get(k) == searchNum){
                    repeat++;
                }
            }
            answer+= searchNum*repeat;
        }
        return answer;
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