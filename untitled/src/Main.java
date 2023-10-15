import java.io.*;
import java.util.Scanner;
;

public class Main {

    public static linkedlist wordList_Positive = new linkedlist();
    public static linkedlist wordList_Negative = new linkedlist();
    public static linkedlist wordList_Neutral = new linkedlist();

    public static void main(String[] args){
        try {
            File positiveWordFile = new File("Positive_Word_List.txt");
            Scanner positiveWordReader = new Scanner(positiveWordFile);

            String word;

            while (positiveWordReader.hasNextLine()){
                word = positiveWordReader.nextLine().trim();

                if(!word.isEmpty()) {
                    linkedlist.input(wordList_Positive, word);
                }
            }

            File negativeWordFile = new File("Negative_Word_List.txt");
            Scanner negativeWordReader = new Scanner(negativeWordFile);

            while (negativeWordReader.hasNextLine()) {
                word = negativeWordReader.nextLine().trim();

                if(!word.isEmpty()){
                    linkedlist.input(wordList_Negative, word);
                }
            }
            File NeutralFile = new File("Negation_Words_List.txt");
            Scanner negationReader = new Scanner(NeutralFile);
            while (negationReader.hasNextLine()) {
                word = negationReader.nextLine().trim();
                if(!word.isEmpty()){
                    linkedlist.input(wordList_Neutral, word);
                }
            }
        }catch (Exception e){
            System.out.println("Invalid input...");
            e.printStackTrace();
        }


        linkedlist.state =0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Say somthing: ");
        String inputValue = scanner.nextLine();

        inputValue = inputValue.toLowerCase();

        String[] wordList = inputValue.split(" ");


        for (int i =0;i<wordList.length;i++){
            linkedlist.checkPositiveWord(wordList_Positive,wordList[i]);
            linkedlist.checkNegativeWord(wordList_Negative,wordList[i]);
        }

        for (int i =0;i<wordList.length;i++){
            linkedlist.checkNegationWord(wordList_Neutral,wordList[i]);
        }


        if(linkedlist.state == 100){
            System.out.println("This Sentiment is: positive.");
        }

        else if (linkedlist.state == 200) {
            System.out.println("This Sentiment is: negative.");
        }

        else if(linkedlist.state ==150){
            System.out.println("This Sentiment is: negative.");
        }

        else if (linkedlist.state ==250) {
            System.out.println("This Sentiment is: positive.");
        }

        else if (linkedlist.state == 50) {
            System.out.println("This Sentiment is: Negative.");
        }

        else {
            System.out.println("This Sentiment is: neutral.");
        }

    }
}