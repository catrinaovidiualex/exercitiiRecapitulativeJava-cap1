package com.company;

import com.sun.jdi.connect.Connector;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Exercitii {
    public static void duplicateCh(String text) {
        int count = 0;

        System.out.println("Duplicate characters: ");
        for (int i = 0; i < text.length(); i++) {
            for (int j = 0; j < text.length(); j++) {
                if (text.charAt(i) == text.charAt(j)) {

                    count++;
                }

            }

            System.out.println(text.charAt(i) + "=" + count);
            String d = String.valueOf(text.charAt(i)).trim();
            text = text.replaceAll(d, "");
            count = 0;

        }

    }

    public static void firstNonRepetedCh(String text) {

        for (int i = 0; i < text.length(); i++) {
            boolean unic = true;
            for (int j = 0; j < text.length(); j++) {
                if (i != j && text.charAt(i) == text.charAt(j)) {
                    unic = false;
                    break;

                }
            }
            if (unic) {

                System.out.println("First nonrepeted character is:" + text.charAt(i));
                break;
            }
        }

    }

    public static void reverseLettersofWords(String word) {
        char[] ch = word.toCharArray();
        for (int i = word.length() - 1; i >= 0; i--) {
            System.out.println(ch[i]);
        }

    }

    public static void reverseWordsOfText(String text) {
        String[] words = text.split("");

        for (int i = words.length - 1; i >= 0; i--) {
            System.out.println(words[i]);

        }
    }

    public static boolean containOnlyDigits(String text) {

        boolean onlyDigits = false;

        if (text.matches("[0-9]+")) {
            onlyDigits = true;
        } else {
            onlyDigits = false;
        }

        return onlyDigits;


    }

    public static void numbersofVowelsAndConsonants(String text) {
        int count = 0;
        char[] vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};

        for (int i = 0; i <= text.length() - 1; i++) {
            for (int j = 0; j <= 9; j++) {
                if (text.charAt(i) == vowels[j]) {
                    //&& (text.indexOf(text.charAt(i))>=65 && text.indexOf(text.charAt(i))<90 || text.indexOf(text.charAt(i))>=97 && text.indexOf(text.charAt(i))<=122))
                    // text.indexOf(text.charAt(i))!=-1 sa nu contina caractere speciale
                    count++;

                }
            }

        }
        System.out.println("Numbers of vowels: " + count);
        System.out.println("Numbers of consonants: " + (text.length() - count));

    }

    public static void numberOfOccurrences(String text, char ch) {
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ch) {
                count++;

            }
        }
        System.out.println("Number of occurrences: " + count);
    }

    public static void removingWhiteSpaces(String text) {
        for (int i = 0; i < text.length(); i++) {

            text = text.replaceAll(" ", "");

        }

        System.out.println("After deletion of white spaces: " + text);
    }

    public static void joinningMultipleStringWithDelimiter(String t1, String t2, String t3, char delimiter) {

        System.out.println(t1 + delimiter + t2 + delimiter + t3);
    }

    public static void palindromeString(String text) {
        String reverseString = "";
        for (int i = text.length() - 1; i >= 0; i--) {
            reverseString = reverseString + text.charAt(i);

        }
        if (text.equals(reverseString)) {
            System.out.println("Your string is palindrome");

        } else
            System.out.println("Your string is not palindrome");


    }

    public static void removingGivenCh(String text, char ch) {
        for (int i = 0; i <= text.length() - 1; i++) {

            if (text.charAt(i) == ch) {
                text = text.replace(text.charAt(i), ' ');

            }
        }
        System.out.println("New text is: " + text);
    }

    public static String removingDuplCh(String text) {

        String newString = new String();
        int len = text.length();
        for (int i = 0; i < len; i++) {
            char c = text.charAt(i);

            if (newString.indexOf(c) < 0) {
                // daca text.indexOf(c)<0 -> inseamna ca c nu exista in stringul 'text', daca exista intoarce indexul lui c
                newString += c;

            }


        }
        return newString;


    }

    public static void findingMaxAppearances(String text) {

        int charCount = 0;
        char max = ' ';
        for (int i = 0; i < text.length(); i++) {
            int count = 0;
            for (int j = 0; j < text.length(); j++) {
                if (text.charAt(i) == text.charAt(j)) {
                    count++;
                }
            }
            if (charCount <= count) {
                charCount = count;
                max = text.charAt(i);
            }
        }
        System.out.println("Max occurring: " + max);
    }

    public static void sortStringArray() {
        String[] examples = {"Alex-Ovidiu", "Marea-Britanie", "Drobeta Turnu Severin", "Germania", "Ana are multe mere", "Lac"};
        int size = examples.length;
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < examples.length; j++) {
                if (examples[i].compareTo(examples[j]) < 0) {
                    String temp = examples[i];
                    examples[i] = examples[j];
                    examples[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(examples));

    }

    public static boolean stringContainsSubstring(String text, String substr) {

        return text.contains(substr);

    }

    public static void countingSubstringsOfString(String text, String substr) {

        int lastIndex = 0;
        int count = 0;

        while (lastIndex != -1) {
            lastIndex = text.indexOf(substr, lastIndex);

            if (lastIndex != -1) {
                count++;

                lastIndex += substr.length();
            }


        }
        System.out.println("Number of substring occurrences: "+count);

    }

    public static void countingSubstringsOfStringV2(String text, String substr){
        Pattern p = Pattern.compile(substr);
        Matcher m = p.matcher(text);
        int count = 0;
        while (m.find()){
            count ++;
        }
        System.out.println(count);

    }

    public static boolean checkingAnagrams(String text1, String text2){
      if(text1.length()!=text2.length())
          return false;

      char [] ch1 = text1.toCharArray();
      char [] ch2 = text2.toCharArray();
      Arrays.sort(ch1); // sortam fiecare sir de cartactere;
      Arrays.sort(ch2);
      return Arrays.equals(ch1,ch2); // daca dupa sortare nu cotin aceleasi caractere -> nu sunt anagrame;
    }

    //https://openjdk.java.net/jeps/355
    //https://books.google.ro/books?id=QlqxDwAAQBAJ&pg=PA9&lpg=PA9&dq=write+a+program+that+declares+multiline+strings+or+text+blocks+in+java&source=bl&ots=KtFAL1t_3B&sig=ACfU3U2jW7r1a5f2kNwAB_gm42ENyJTD0Q&hl=en&sa=X&ved=2ahUKEwj3vMWY9tLwAhXAhf0HHfl4CosQ6AEwEHoECA8QAw#v=onepage&q=write%20a%20program%20that%20declares%20multiline%20strings%20or%20text%20blocks%20in%20java&f=false
    public static void declaringMultilineStrings(){

        String multilines=String.format("%s"+"%s"+"%s",
                "Acesta este un exemplu\n",
                "de multiline string\n",
                " sau bloc de text");
        System.out.println(multilines);

       }

    public static void concatSameStringNTimes(String text, int number){
        String newTextV1 = text.repeat(number);
        String newTextV2 = String.format("%0"+number+"d",0).replace("0",text);
            System.out.println("Varianta 1: "+newTextV1);
            System.out.println("Varianta 2: "+ newTextV2);

        }

    public static void removingLeadingTraillingSpaces (String text){
        for (int i=0; i<text.length();i++){
            text=text.trim(); // sau se poate face si text=text.strip() -> ambele sterg spatiile de la inceput si sfarsit de string;
        }
        System.out.println(text);
    }

    public static String longestCommonPrefix (String text1, String text2){
        int minLength = Math.min(text1.length(),text2.length());
        for (int i = 0; i < minLength; i++) {
            if (text1.charAt(i) != text2.charAt(i)) {
                return "Cel mai lung prefix este: "+ text1.substring(0, i);
            }
        }
        return "Cel mai lung prefix este: "+ text1.substring(0, minLength);


    }

    public static String identationString (int idn){
        String text="Luni\n"+
                    "Marti\n"+
                    "Miercuri\n"+
                    "Joi\n"+
                    "Vineri\n"+
                    "Sambata\n"+
                    "Duminica\n";
        return text.indent(idn);

    }

    public static void transformingStringIntoString(){
        String exemplu1="Acesta este un exemplu de a transforma un string intr-un alt string - fiind defapt un Obiect de tip String".transform(String::toString);
        System.out.println(exemplu1);
        String exemplu2="Acesta este un exemplu de a transforma un string intr-un alt string uppercase - fiind defapt un Obiect de tip String".transform(String::toUpperCase);
        System.out.println(exemplu2);
    }

    public static void minAndMaxOf2Numbers(int n1, int n2){
            if(n1<n2){

                System.out.println( "Minimul este:"+n1);
                System.out.println( "Maximul este:"+n2);

        }
            else if (n1>n2){
                System.out.println( "Minimul este:"+n2);
                System.out.println( "Maximul este:"+n1);

            }
            else{ System.out.println("Sunt egale");}


    }

    public static long sumOf2Numbers(long n1, long n2){
        long sum=0;
        if (n1!=0 && n2!=0){
            sum=n1+n2;

        }
        else{
            throw new ArithmeticException("This operation cannot be actioned");
        }
        return sum;
    }

    public static int parseStringAsUnsignedNumer(String text, int radix){
        int result=Integer.parseUnsignedInt(text,radix);
        return result;
    }

    public static long convertIntIntoUnsignedLong(int i1){
        long result  = Integer.toUnsignedLong(i1);
        return result;
    }

    public static int compareTwoUnsignedIntNumbers(int i1, int i2){

        int result2=Integer.compareUnsigned(i1,i2);

        if(result2==1){
            System.out.println(i2+" is greater than: "+i1);
        }
        else if (result2==-1){

         System.out.println(i1+" is greater than: "+i2);}

        else System.out.println("Both are equal");

        return result2;

    }

    public static void divisionAndModulo(int i1, int i2){
        int division;
        int modulo;
        // varianta 1
        //division= i1/i2;
        //modulo=i1%i2;


        //varianta 2 - folosind divideUnsigned () si reminderUnsigned();
        division= Integer.divideUnsigned(i1, i2);
        modulo=Integer.remainderUnsigned(i1,i2);

        System.out.println("Division: "+division);
        System.out.println("Modulo: " +modulo);

    }

}




