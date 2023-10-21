import java.io.Serializable;
import java.util.HashMap;

public class Seans implements Serializable {
    static char[] letters = new char[26];
    private String title;
    private String day;
    private String hour;
    private int numberOfRows; //rzędy jako literki (A,B,C...)
    private int numberOfSeats;


    private HashMap<Character, HashMap<Integer, Boolean>> SeatsRow;
    private HashMap<Integer, Boolean> SeatsInner;

    public Seans(String title, String day, String hour, int numberOfRows, int numberOfSeats) {
        this.title = title;
        this.day = day;
        this.hour = hour;
        this.numberOfRows = numberOfRows;
        this.numberOfSeats = numberOfSeats;
        saveLetters();
        SeatsRow = new HashMap<>();
        seatsSetting();
    }

    private void saveLetters() {
        int index = 0;
        for (char letter = 'A'; letter <= 'Z'; letter++) {
            letters[index] = letter;
            index++;
        }
    }

    public void seatsSetting() {
        for (int i = 0; i < numberOfRows; i++) {
            SeatsInner = new HashMap<>();
            for (int j = 1; j <= numberOfSeats; j++) {
                SeatsInner.put(j, true);
            }
            SeatsRow.put(letters[i], SeatsInner);
        }
    }

    public void changingSeatStatus(char row, int seat) {
        HashMap<Integer, Boolean> rowMap = SeatsRow.get(row);
        for (char rowTmp : SeatsRow.keySet()) {
            if (rowTmp == row) {
                for (int seatNumber : rowMap.keySet()) {
                    if (seatNumber == seat) {
                        boolean isOccupied = rowMap.get(seatNumber);
                        if (isOccupied) {
                            rowMap.put(seat, false); // Oznacz miejsce jako wolne
                        } else {
                            System.out.println("Miejsce jest zajęte. Wybierz inne miejsce...");
                        }
                    }
                }
            }
        }
    }


    public Boolean isOccupied(char row, int seat) {
        HashMap<Integer, Boolean> rowMap = SeatsRow.get(row);
        for (char rowTmp : SeatsRow.keySet()) {
            if (rowTmp == row) {
                for (int seatNumber : rowMap.keySet()) {
                    if (seatNumber == seat) {
                        boolean isOccupied = rowMap.get(seatNumber);
                        if (isOccupied) {
                            return true;
                        } else {
                            return false;
                        }
                    }
                }
            }
        }
        return false;
    }

    public void displaySeatsMap() {
        for (char row : SeatsRow.keySet()) {
            HashMap<Integer, Boolean> rowMap = SeatsRow.get(row);
            System.out.print(row + ": ");
            for (int seatNumber : rowMap.keySet()) {
                boolean isOccupied = rowMap.get(seatNumber);
                System.out.print((isOccupied ? 1 : 0));
            }
            System.out.print("\n");
        }
    }

    @Override
    public String toString() {
        return "Seans{" +
                "title='" + title + '\'' +
                ", day='" + day + '\'' +
                ", hour='" + hour + '\'' +
                ", numberOfRows=" + numberOfRows +
                ", numberOfSeats=" + numberOfSeats +
                ", SeatsRow=" + SeatsRow +
                ", SeatsInner=" + SeatsInner +
                '}';
    }
}
