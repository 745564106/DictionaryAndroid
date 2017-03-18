package com.example.nguyenthanhthai.dictionaryandroid.domain;

import android.util.Log;

import com.example.nguyenthanhthai.dictionaryandroid.dao.DataAccess;
import com.example.nguyenthanhthai.dictionaryandroid.model.Mearning;
import com.example.nguyenthanhthai.dictionaryandroid.model.Word;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by NguyenThanhThai on 3/18/2017.
 */

public class  WordMearning {
    DataAccess da;

    /**
     * Get list word when search with wordtext
     */
    public Collection<Word> getListWordMearning(String wordText){
        if (wordText==null){
            return null;
        }
        String query="exec spWordAndMeaning N'"+wordText+"'";
        da=new DataAccess();
        ResultSet rs=da.excuteQuery(query);
        Map<Integer,Word> mearningMapWordId;
        mearningMapWordId=new HashMap<Integer,Word> ();
        try {
            while (rs.next()){
                int wordId=rs.getInt("WordId");
                String wordTextGet =rs.getString("WordText");
                String pronounce=rs.getString("Pronounce");
                String mearningText=rs.getString("MearningText");
                Mearning mearning=new Mearning();
                mearning.setMearningText(mearningText);

                if (mearningMapWordId.containsKey(wordId)){
                    mearningMapWordId.get(wordId).getMearnings().add(mearning);
                    continue;
                }

                Word word=new Word(wordId,wordTextGet,pronounce);
                word.setMearnings(new ArrayList<Mearning>());
                word.getMearnings().add(mearning);
                mearningMapWordId.put(wordId, word);
            }
        }catch (Exception ex)
        {
            Log.d("\n\nEX",ex.getMessage());
        }


        return mearningMapWordId.values();
    }
}