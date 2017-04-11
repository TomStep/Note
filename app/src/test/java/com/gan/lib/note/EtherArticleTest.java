package com.gan.lib.note;

import com.gan.lib.note.data.EthermeticArticleDoc;

import org.junit.Test;

/**
 *
 * Created by tangjun on 2017/4/11.
 */


public class EtherArticleTest extends EthermeticArticleDoc {


    @Test
    public void run(){
        getData("http://www.ethermetic.com/post-4443.html");

        System.out.print(getHtml());
    }
}
