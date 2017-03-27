package com.example.nguyenthanhthai.dictionaryandroid.domain;

import android.util.Log;

import com.example.nguyenthanhthai.dictionaryandroid.dao.DataAccess;
import com.example.nguyenthanhthai.dictionaryandroid.model.Example;
import com.example.nguyenthanhthai.dictionaryandroid.model.Mearning;
import com.example.nguyenthanhthai.dictionaryandroid.model.Word;
import com.example.nguyenthanhthai.dictionaryandroid.model.WordType;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by NguyenThanhThai on 3/18/2017.
 */

public class WordMearning {
    static DataAccess da;

    /**
     * Get list word when search with wordtext
     */
    public Collection<Word> getListWordMearning(String wordText) {
        if (wordText == null) {
            return null;
        }
        String query = "exec spWordAndMeaning N'" + wordText + "'";
        da = new DataAccess();
        ResultSet rs = da.excuteQuery(query);
        Map<Integer, Word> mearningMapWordId;
        mearningMapWordId = new HashMap<Integer, Word>();
        try {
            while (rs.next()) {
                int wordId = rs.getInt("WordId");
                String wordTextGet = rs.getString("WordText");
                String pronounce = rs.getString("Pronounce");
                String mearningText = rs.getString("MearningText");
                Mearning mearning = new Mearning();
                mearning.setMearningText(mearningText);

                if (mearningMapWordId.containsKey(wordId)) {
                    mearningMapWordId.get(wordId).getMearnings().add(mearning);
                    continue;
                }

                Word word = new Word(wordId, wordTextGet, pronounce);
                word.setMearnings(new ArrayList<Mearning>());
                word.getMearnings().add(mearning);
                mearningMapWordId.put(wordId, word);
            }
        } catch (Exception ex) {
            Log.d("\n\nEX", ex.getMessage());
        }

        return mearningMapWordId.values();
    }

    public static List<WordType> getListMearningWordType(Word word) {
        if (word == null) {
            return null;
        }
        String query = "exec spWordAndMeaning N'" + word.getWordId() + "'";
        da = new DataAccess();
        ResultSet rs = da.excuteQuery(query);
        Map<Integer, Word> mearningMapWordId;
        mearningMapWordId = new HashMap<Integer, Word>();
        try {
            while (rs.next()) {
                int wordId = rs.getInt("WordId");
                String wordTextGet = rs.getString("WordText");
                String pronounce = rs.getString("Pronounce");
                String mearningText = rs.getString("MearningText");
                Mearning mearning = new Mearning();
                mearning.setMearningText(mearningText);

                if (mearningMapWordId.containsKey(wordId)) {
                    mearningMapWordId.get(wordId).getMearnings().add(mearning);
                    continue;
                }

                Word wordn = new Word(wordId, wordTextGet, pronounce);
                wordn.setMearnings(new ArrayList<Mearning>());
                wordn.getMearnings().add(mearning);
                mearningMapWordId.put(wordId, wordn);
            }
        } catch (Exception ex) {
            Log.d("\n\nEX", ex.getMessage());
        }

        List<WordType>  listWordType;
        listWordType =new ArrayList<WordType>();
        listWordType.add(new WordType(1, "danh từ"));
        listWordType.add(new WordType(2, "động từ"));
        return listWordType;
    }

    public static List<Mearning> getListMearning(Word word, WordType type) {
        List<Mearning> mearnings=new ArrayList<>();
        mearnings.add(new Mearning(1,"trọng âm"));
        mearnings.add(new Mearning(2,"dấu trọng âm"));
        Example example=new Example(1,"speak English with a French accent","nói tiếng anh với giọng pháp");
        Example example2=new Example(2," 2 speak English with a French accent","nói tiếng anh với giọng pháp");
        Example example3=new Example(1,"in all our products the accent í on quality","trong tất cả sản phẩm của chúng tôi, điều chúng tôi nhấn mạnh là chất lượng");
        List<Example> list1, list2;
        list1=new ArrayList<>();
        list1.add(example);
        list1.add(example2);
        list2=new ArrayList<>();
        list2.add(example3);
        mearnings.add(new Mearning(3,"giọng",list1));
        mearnings.add(new Mearning(3,"điều nhấn mạnh",list2));

        if (type.getTypeId()==1)
            return mearnings;

        List<Mearning> mearnings2=new ArrayList<>();
        mearnings2.add(new Mearning(1,"đọc nhấn mạnh"));
        mearnings2.add(new Mearning(1,"đánh dấu âm"));
        return  mearnings2;
    }
}