package com.google.engedu.anagrams;



import android.annotation.TargetApi;
import android.os.Build;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static android.R.attr.y;

public class AnagramDictionary {

    private static final int MIN_NUM_ANAGRAMS = 5;
    private int DEFAULT_WORD_LENGTH = 3;
    private static final int MAX_WORD_LENGTH = 7;
    private String res1 = "", s, res2 = "",word1;
    private int size;
    ArrayList<String> wordList = new ArrayList<String>();
    ArrayList<String> result = new ArrayList<>();
    HashSet<String> wordSet = new HashSet<String>();
    HashMap<String, ArrayList> lettersToWord = new HashMap<String, ArrayList>();
    ArrayList<String> result1 = new ArrayList<String>();


    public AnagramDictionary(InputStream wordListStream) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(wordListStream));
        String line;

        while ((line = in.readLine()) != null) {
            String word = line.trim();
            wordList.add(word);
            wordSet.add(word);
        }
        size = wordList.size();

    }

    public boolean isGoodWord(String word, String base) {
        if (!(word.contains(base))) {
            Iterator<String> itr = wordSet.iterator();
            while (itr.hasNext()) {
                if (word.equals(itr.next()))
                    return true;
            }
        }
        return false;
    }


    public void getAnagrams(String word1, String targetWord) {
        res2 = sortLetters(targetWord);
        for (int i = 0; i < size; i++) {
            s = wordList.get(i);
            res1 = sortLetters(s);
            if (!(s.contains(word1))) {
                if (s.length() == targetWord.length()) {
                    if (res1.equals(res2)) {

                        result.add(s);

                    }
                }
            }
            lettersToWord.put(word1, result);
        }
    }

    public String sortLetters(String s) {
        String sorted;
        sorted = "";
        int i, j;
        char temp;
        char ch[] = new char[s.length()];
        for (i = 0; i < s.length(); i++)
            ch[i] = s.charAt(i);
        for (i = 0; i < s.length() - 1; i++) {
            for (j = 0; j < (s.length() - i - 1); j++) {
                if (ch[j] > ch[j + 1]) {
                    temp = ch[j];
                    ch[j] = ch[j + 1];
                    ch[j + 1] = temp;
                }
            }
        }
        for (i = 0; i < s.length(); i++)
            sorted = sorted + ch[i];
        return sorted;
    }

    public ArrayList<String> getAnagramsWithOneMoreLetter(String word) {
        result1.clear();
        char ch = 'a';
        String targetWord = word;
        while (ch != 'z') {
            targetWord = new StringBuilder().append(ch).append(word).toString();
            getAnagrams(word, targetWord);
            ch++;
        }

        for (Map.Entry m : lettersToWord.entrySet()) {
            if (m.getKey().equals(word)) {
                result1 = (ArrayList<String>) m.getValue();

            }
        }


        return result1;
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public String pickGoodStarterWord() {
        result1.clear();
        ArrayList<String> result2 = new ArrayList<String>();
        result2 = wordList;
        while (true) {
            int x = ThreadLocalRandom.current().nextInt(size);
            if (result2.get(x).length() == DEFAULT_WORD_LENGTH) {
                if ((getAnagramsWithOneMoreLetter(result2.get(x)).size()) >= MIN_NUM_ANAGRAMS) {
                    if (DEFAULT_WORD_LENGTH < MAX_WORD_LENGTH) {
                        DEFAULT_WORD_LENGTH++;
                    } else {
                        DEFAULT_WORD_LENGTH = 3;
                    }
                    return result2.get(x);
                } else
                    result1.clear();
            }


        }


    }
}




