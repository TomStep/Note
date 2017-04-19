package com.gan.lib.note;

import com.gan.lib.note.data.ToonsBookDoc;
import com.gan.lib.note.entiry.ToonsBookEntiry;

import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by tangjun on 2017/4/19.
 */

public class ToonsBookText extends ToonsBookDoc{

    @Test
    public void getToonsBookList(){

        getData("http://www.webtoons.com/zh-hans/drama/kanlianshidai/list?title_no=423");

        ArrayList<ToonsBookEntiry> list = getList();

        System.out.print(list);
    }
}
