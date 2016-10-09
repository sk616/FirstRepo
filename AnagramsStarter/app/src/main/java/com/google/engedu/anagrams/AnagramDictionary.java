package com.google.engedu.anagrams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

import android.annotation.TargetApi;
import android.os.Build;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class       AnagramDictionary {

    private static final int MIN_NUM_ANAGRAMS = 5;
    private static int DEFAULT_WORD_LENGTH = 3;
    private static final int MAX_WORD_LENGTH = 7;
    private Random random = new Random();
    ArrayList<String> wordlist=new ArrayList<String>();
    private int y;
    char a[]=new char[9];
    char b[]=new char[9];
    ArrayList<String> ne=new ArrayList<String>();
    ArrayList<String> result = new ArrayList<String>();
    HashMap<Integer,ArrayList<String>> main;
    String s,d;


    public AnagramDictionary(InputStream wordListStream) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(wordListStream));
        String line;
        while((line = in.readLine()) != null) {
            String word = line.trim();
            wordlist.add(word);
        }
        y=wordlist.size();
    }


    public boolean isGoodWord(String word, String base) {
        int z=ne.size();
        for(int i=0;i<z;i++){

            if(ne.get(i).toLowerCase().equals(word.toLowerCase())){
                return true;
            }
        }
        return false;
    }

    public ArrayList<String> getAnagrams(String targetWord) {
        result.clear();
        a=targetWord.toLowerCase().toCharArray();
        Arrays.sort(a);
        s=new String(a);
        for(int i=0;i<y;i++){
            b=wordlist.get(i).toLowerCase().toCharArray();
            Arrays.sort(b);
            d=new String(b);
            if(d.equals(s)){

                result.add(wordlist.get(i).toLowerCase());

            }
        }
        return result;
    }

    public ArrayList<String> getAnagramsWithOneMoreLetter(String word) {
        char x;
        int si;
        String sl;

        ArrayList<String> onemore=new ArrayList<String>();
        for(x='a';x<'z';x++){
            sl=x+word.toLowerCase();
            onemore=getAnagrams(sl);
            si=onemore.size();
            for(int i=0;i<si;i++){
                ne.add(onemore.get(i).toLowerCase());
            }
        }
        return ne;
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public String pickGoodStarterWord() {
        ne.clear();
        ArrayList<String> nes = new ArrayList<String>();
        nes = wordlist;
        while (true) {
            int x = ThreadLocalRandom.current().nextInt(y);
            if (nes.get(x).length() == DEFAULT_WORD_LENGTH) {
                if (getAnagramsWithOneMoreLetter(nes.get(x)).size() >= MIN_NUM_ANAGRAMS) {
                    if (DEFAULT_WORD_LENGTH < MAX_WORD_LENGTH) {
                        DEFAULT_WORD_LENGTH++;
                    } else DEFAULT_WORD_LENGTH = 3;
                    return nes.get(x);
                }else ne.clear();
            }
        }
    }
}

