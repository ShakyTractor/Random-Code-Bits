import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> flavours = new ArrayList<>();
        String answer;
        while(true) {
            System.out.println("a = add, e = exit, m = menu, rp = replace, rm = remove");
            answer = sc.nextLine();
            if(answer.toUpperCase().equals("A")) {
                System.out.println("flavours u want to add (seperated by commas)");
                for(String flav : sc.nextLine().split(",")) {
                    flavours.add(flav);
                }
                addFlavours(flavours);
                flavours.clear();
                System.out.println(makeMenu(readLines("new.txt")));
            } else if(answer.toUpperCase().equals("M")) {
                System.out.println(makeMenu(readLines("new.txt")));
            } else if(answer.toUpperCase().equals("RP")){
                String wanted;
                String unwanted;
                System.out.println("unwanted flavour:");
                unwanted = sc.nextLine();
                System.out.println("replacement flavour:");
                wanted = sc.nextLine();
                replaceFlavour(unwanted, wanted);
            } else if(answer.toUpperCase().equals("RM")) {
                System.out.println("Flavour you wish to remove:");
                removeFlavour(sc.nextLine());
            } else {
                break;
            }
        }
    }
    
    public static ArrayList<String> readLines(String file) {
        ArrayList<String> lines = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String currentLine;
            while((currentLine = br.readLine()) != null) {
                lines.add(currentLine);
            }
        } catch(Exception e) {
            e.getStackTrace();
        }
        
        return lines;
    }
    
    public static String makeMenu(ArrayList<String> flavours) {
        String menu = "Fantastic flavours of the day:\n";
        for(String flav : flavours) {
            menu += "  -"+flav+"\n";
        }
        return menu;
    }
    
    public static void writeFlavours(ArrayList<String> flavours) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("new.txt"));
            for(String flav : flavours) {
                bw.write(flav+"\n");
            }
            bw.close();
        } catch(Exception e) {
            e.getStackTrace();
        }
    }
    
    public static void addFlavours(ArrayList<String> flavours) {
        ArrayList<String> flavoursToBeWritten = readLines("new.txt");
        for(String flav : flavours) {
            flavoursToBeWritten.add(flav);
        }
        writeFlavours(flavoursToBeWritten);
    }
    
    public static void replaceFlavour(String unwanted, String wanted) {
        ArrayList<String> flavours = readLines("new.txt");
        for(int i = 0; i < flavours.size(); i++) {
            if(flavours.get(i).equals(unwanted)) {
                flavours.set(i, wanted);
                break;
            }
        }
        writeFlavours(flavours);
    }
    
    public static void removeFlavour(String unwanted) {
        ArrayList<String> flavours = readLines("new.txt");
        for(int i = 0; i < flavours.size(); i++) {
            if(flavours.get(i).equals(unwanted)) {
                flavours.remove(i);
                break;
            }
        }
        writeFlavours(flavours);    
    }
}