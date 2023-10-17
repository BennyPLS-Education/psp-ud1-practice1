package AnalitzarCaracters;

public class AnalitzarCaracters {
    public static void main(String[] args) {
        char letter = 0;
        countLetter(args[0], letter);
    }

    public static int countLetter(String text, char letter){
        int counter = 0;
        for (int i = 0; i < text.length(); i++)
        {
            if(text.charAt(i) == letter)
            {
                counter++;
            }
        }
        return counter;
    }
}
