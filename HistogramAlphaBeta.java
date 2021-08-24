//package sample;
//
//import java.util.Scanner;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.Map;
//import java.util.HashMap;
//
//
//
///*
// *   Calculates the n most frequent alphabet
// *   characters in the text and prints out a
// *   frequency table
// */
//
//public class HistogramAlphaBeta {
//    HashMap<Character, Integer> hashMap = new HashMap<>();
//    int total=0;
//
//    public HistogramAlphaBeta(String pathname) {
//        File file = new File(pathname);
//        Scanner scanner = null;
//
//        // Upload file
//        try {
//            scanner = new Scanner(file,"utf-8");
//        } catch (FileNotFoundException e) { e.printStackTrace(); }
//
//        // Loop every character
//        //keep reading line
//        while (scanner.hasNext()) {
//            char[] chars = scanner.nextLine().toLowerCase().toCharArray(); //takes each character and makes it lower case and stores it inside a character array
//            for (Character c : chars) { // for every character that's in the character array
//                if (hashMap.containsKey(c)) { // if the key already exists
//                    hashMap.put(c, hashMap.get(c) + 1); // Increment the value of the key with the same key
//                }
//                else if(!Character.isLetter(c)){ // Skip non characters ) skips spaces and other stuff that are not letters
//                    continue;
//                }
//                else  {
//                    hashMap.put(c, 1); // Unique // inserts into a hashmap
//                }
//                total++; // count how many letters there are for probability
//            }
//        }
//    }
//
//    public void numbeerofOccurences(){
//        System.out.printf("%5s %10s" , "Character", "Occurrence");
//        System.out.println();
//        // prints out how many of each character was counted
//        for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
//            System.out.format("%5s %10s", entry.getKey(), entry.getValue());
//            System.out.println();
//        }
//        System.out.println("Total: " + total);
//
//    }
//
//}
