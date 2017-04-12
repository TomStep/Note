package com.gan.lib.note;

import com.gan.lib.note.data.ToonsHotDoc;

import org.junit.Test;

/**
 *
 * Created by tangjun on 2017/4/12.
 */

public class ToonsHotTest extends ToonsHotDoc{

    @Test
    public void run(){
        getData();
        System.out.print(getList());
    }
}
