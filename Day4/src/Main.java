import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 140 for real puzzle, 10 for testing input
        String[][] fileData = getFileData("src/Day04Input.txt",140);
        partOne(fileData);
        partTwo(fileData);
    }

    public static String[][] getFileData(String fileName, int size) { //2D arrays
        String[][] fileData = new String[size][size];
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            int count = 0;
            while (s.hasNext() && count < size) {
                String line = s.nextLine();
                if (!line.isEmpty()) {
                    for (int i = 0; i < line.length(); i++) {
                        fileData[count][i] = String.valueOf(line.charAt(i));
                    }
                    count++;
                }
            }
            return fileData;
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            return new String[size][size];
        }
    }


    public static void partOne(String[][] data) {
        int count = 0;
        for (int row = 0; row < data.length; row++){
            for (int col = 0; col < data[0].length; col++){
                // horizontal left, col - 1
                if (col - 3 >= 0
                        && data[row][col].equals("X")
                        && data[row][col-1].equals("M")
                        && data[row][col-2].equals("A")
                        && data[row][col-3].equals("S")){
                    count++;
                }
                // horizontal right, col + 1
                if (col + 3 < data[0].length
                        && data[row][col].equals("X")
                        && data[row][col+1].equals("M")
                        && data[row][col+2].equals("A")
                        && data[row][col+3].equals("S")){
                    count++;
                }
                // vertical up, row - 1
                if (row - 3 >= 0
                        && data[row][col].equals("X")
                        && data[row-1][col].equals("M")
                        && data[row-2][col].equals("A")
                        && data[row-3][col].equals("S")){
                    count++;
                }
                // vertical down, row + 1
                if (row + 3 < data.length
                        && data[row][col].equals("X")
                        && data[row+1][col].equals("M")
                        && data[row+2][col].equals("A")
                        && data[row+3][col].equals("S")){
                    count++;
                }
                // diagonal left top, right bottom, row + 1, col + 1
                if (row + 3 < data.length
                        && col + 3 < data[0].length
                        && data[row][col].equals("X")
                        && data[row+1][col+1].equals("M")
                        && data[row+2][col+2].equals("A")
                        && data[row+3][col+3].equals("S")){
                    count++;
                }
                // diagonal right top, left bottom, row + 1, col - 1
                if (row + 3 < data.length
                        && col - 3 >= 0
                        && data[row][col].equals("X")
                        && data[row+1][col-1].equals("M")
                        && data[row+2][col-2].equals("A")
                        && data[row+3][col-3].equals("S")){
                    count++;
                }
                // diagonal right bottom, left top, row - 1, col - 1
                if (row - 3 >= 0
                        && col - 3 >= 0
                        && data[row][col].equals("X")
                        && data[row-1][col-1].equals("M")
                        && data[row-2][col-2].equals("A")
                        && data[row-3][col-3].equals("S")){
                    count++;
                }
                // diagonal left bottom, right top, row - 1, col + 1
                if (row - 3 >= 0
                        && col + 3 < data[0].length
                        && data[row][col].equals("X")
                        && data[row-1][col+1].equals("M")
                        && data[row-2][col+2].equals("A")
                        && data[row-3][col+3].equals("S")){
                    count++;
                }
            }
        }
        System.out.println(count);
    }


    public static void partTwo(String[][] data) {
        int totalCount = 0;
        for (int row = 0; row < data.length; row++){
            for (int col = 0; col < data[0].length; col++){
                int count = 0;
                // diagonally top left, bottom right
                if (row + 1 < data.length
                        && row - 1 >= 0
                        && col + 1 < data[0].length
                        && col - 1 >= 0
                        && data[row-1][col-1].equals("M")
                        && data[row][col].equals("A")
                        && data[row+1][col+1].equals("S")){
                    count++;
                }
                // diagonally top right, bottom left
                if (row + 1 < data.length
                        && row - 1 >= 0
                        && col + 1 < data[0].length
                        && col - 1 >= 0
                        && data[row-1][col+1].equals("M")
                        && data[row][col].equals("A")
                        && data[row+1][col-1].equals("S")){
                    count++;
                }
                // diagonally bottom right, top left
                if (row + 1 < data.length
                        && row - 1 >= 0
                        && col + 1 < data[0].length
                        && col - 1 >= 0
                        && data[row+1][col+1].equals("M")
                        && data[row][col].equals("A")
                        && data[row-1][col-1].equals("S")){
                    count++;
                }
                // diagonally bottom left, top right
                if (row + 1 < data.length
                        && row - 1 >= 0
                        && col + 1 < data[0].length
                        && col - 1 >= 0
                        && data[row+1][col-1].equals("M")
                        && data[row][col].equals("A")
                        && data[row-1][col+1].equals("S")){
                    count++;
                }
                if (count == 2){
                    totalCount++;
                }
            }
        }
        System.out.println(totalCount);
    }
}