package com.gan.lib.note;

import com.gan.lib.note.data.FifteenDocument;
import com.gan.lib.note.entiry.FifteenWordEntiry;

import org.junit.Test;

import java.util.List;

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
        FifteenDocument d = new FifteenDocument();

        d.getData();

        System.out.print(d.getList());
    }
}