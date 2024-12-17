import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> fileData= getFileData("Day5/src/Day5Input");
        ArrayList<String> rules = new ArrayList<>();
        ArrayList<String> updates = new ArrayList<>();
        for(String line:fileData){
            if(line.contains("|")){
                rules.add(line);
            }
            else updates.add(line);
        }
        partOne(rules,updates);
        partTwo(rules,updates);
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

    public static void partOne(ArrayList<String> rules,ArrayList<String> updates) {
        ArrayList<String> correct = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < updates.size(); i++) {
            boolean valid = true;
            for (int j = 0; j < rules.size(); j++) {
                String line = rules.get(j);
                String before = line.substring(0, line.indexOf("|"));
                String after = line.substring(line.indexOf("|") + 1);
                if (updates.get(i).contains(before) && updates.get(i).contains(after) && updates.get(i).indexOf(before) > updates.get(i).indexOf(after)) {
                    valid = false;
                }
            }
            if (valid) {
                correct.add(updates.get(i));
            }
        }
        for (String line : correct) {
            String[] page = line.split(",");
            int middle = page.length/2;
            sum += Integer.parseInt(page[middle]);
        }
        System.out.println(sum);
    }


    public static void partTwo(ArrayList<String> rules,ArrayList<String> updates) {
        ArrayList<String> fixed = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < updates.size(); i++) {
            for (int j = 0; j < rules.size(); j++) {
                String line = rules.get(j);
                String before = line.substring(0, line.indexOf("|"));
                String after = line.substring(line.indexOf("|") + 1);
                if (updates.get(i).contains(before) && updates.get(i).contains(after) && updates.get(i).indexOf(before) > updates.get(i).indexOf(after)) {
                    String viewing =updates.get(i);
                    while(viewing.indexOf(before)>viewing.indexOf(after)){
                        int bef = viewing.indexOf(before);
                        int aft = viewing.indexOf(after);
                        if((aft - 1) != -1){
                            String newLine = viewing.substring(0,aft) + before + viewing.substring(aft + after.length() + 1,bef) + after + viewing.substring(bef + before.length());
                            fixed.add(newLine);
                            System.out.println(newLine);
                        }
                    }
                }
            }
        }
        for (String line : fixed) {
            String[] page = line.split(",");
            int middle = page.length/2;
            sum += Integer.parseInt(page[middle]);
        }
        System.out.println(sum);
    }
}