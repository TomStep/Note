package com.gan.lib.note;

import com.gan.lib.note.data.FifteenArticleDoc;
import com.gan.lib.note.data.FifteenItemDoc;
import com.gan.lib.note.entiry.FifteenArticleEntiry;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void getDoc(){
        FifteenItemDoc d = new FifteenItemDoc();

        d.getData();

        System.out.print(d.getList());
    }

    @Test
    public void getArticle(){
        FifteenArticleDoc articleDoc = new FifteenArticleDoc("http://www.15yan.com/topic/bian-ji-tui-jian/2VZwtTfZ9N3/");

        articleDoc.getData();
        FifteenArticleEntiry entiry = articleDoc.getEntiry();

        System.out.print(entiry.toString());
    }
}