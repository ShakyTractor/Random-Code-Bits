import java.util.HashMap;
import java.util.Scanner;

public class MorseCodeTranslator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Character, String> codes = new HashMap<>();
        codes.put('A',".-");codes.put('B',"-...");
        codes.put('C',"-.-.");codes.put('D',"-..");
        codes.put('E',".");codes.put('F',"..-.");
        codes.put('G',"--.");codes.put('H',"....");
        codes.put('I',"..");codes.put('J',".---");
        codes.put('K',"-.-");codes.put('L',".-..");
        codes.put('M',"--");codes.put('N',"-.");codes.put('O',"---");
        codes.put('P',".--.");codes.put('Q',"--.-");
        codes.put('R',".-.");codes.put('S',"...");
        codes.put('T',"-");codes.put('U',"..-");
        codes.put('V',"..--");codes.put('W',".--");
        codes.put('X',"-..-");codes.put('Y',"-.--");
        codes.put('Z',"--..");codes.put(' ', "/");
        //System.out.println(codes);
        System.out.println(convert(sc.nextLine(), codes));
    }
    
    public static String convert(String text, HashMap<Character, String> codes) {
        text = text.toUpperCase();
        String newText = "";
        for(int i = 0; i < text.length(); i++) {
            newText = newText + codes.get(text.charAt(i));
            newText = newText + " ";
        }
        return newText;
    }
}
