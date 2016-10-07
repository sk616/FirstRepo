package com.google.engedu.anagrams;



import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;

public class AnagramDictionary {

    private static final int MIN_NUM_ANAGRAMS = 5;
    private static final int DEFAULT_WORD_LENGTH = 3;
    private static final int MAX_WORD_LENGTH = 7;
    private String res1,s,res2,res3,res4,s1;
    private int size,size2;
    ArrayList<String> wordList = new ArrayList<String>();
    ArrayList<String> result = new ArrayList<>();
    private Random random = new Random();

    public AnagramDictionary(InputStream wordListStream) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(wordListStream));
        String line;

        while((line = in.readLine()) != null) {
            String word = line.trim();
            wordList.add(word);
        }
        size=wordList.size();
    }

    public boolean isGoodWord(String word, String base) {
        if(word.length()==base.length())
        {
            res3=sortLetters(word);
            res4=sortLetters(base);
            if(res3.equals(res4))
            {
                for(int j=0;j<size2;j++)
                {
                    s1=result.get(j);
                    if(s1.equals(word))
                        return true;
                }


            }
        }
        return false;
    }

    public ArrayList<String> getAnagrams(String targetWord) {

        res2 = sortLetters(targetWord);
        for(int i=0;i<size;i++) {
            s = wordList.get(i);
            if (s.length() == targetWord.length()) {
                res1 = sortLetters(s);
                if (res1.equals(res2))
                    result.add(s);
            }
        }
        size2=result.size();
        return result;
        }
    public String sortLetters(String s)
    {
        String sorted;sorted="";int i,j;char temp;
        char ch[]=new char[s.length()];
        for(i=0;i<s.length();i++)
            ch[i]=s.charAt(i);
        for(i=0;i<s.length()-1;i++)
        {
            for(j=0;j<(s.length()-i-1);j++)
            {
                if(ch[j]>ch[j+1])
                {
                    temp=ch[j];
                    ch[j]=ch[j+1];
                    ch[j+1]=temp;
                }
            }
        }
        for(i=0;i<s.length();i++)
            sorted=sorted+ch[i];
        return sorted;
    }

    public ArrayList<String> getAnagramsWithOneMoreLetter(String word) {
        ArrayList<String> result = new ArrayList<String>();
        return result;
    }

    public String pickGoodStarterWord() {
        return "stop";
    }
}

