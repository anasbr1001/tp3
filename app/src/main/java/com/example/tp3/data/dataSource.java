package com.example.tp3.data;
import com.example.tp3.model.Word;

import java.util.LinkedList;

public class dataSource {

    public dataSource(){}

    public LinkedList<Word> loadWords(){
        // Mettre les données initiales dans la liste de mots.
        LinkedList<Word> wordList = new LinkedList<>();
        for (int i = 0; i < 20; i++) {
            wordList.addLast(new Word("Word " + i));
        }
        return wordList;
    }
}