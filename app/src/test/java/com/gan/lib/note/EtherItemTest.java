package com.gan.lib.note;

import com.gan.lib.note.data.EtherItemDoc;
import org.junit.Test;

/**
 * 测试EtherItemDoc类
 * Created by tangjun on 2017/4/11.
 */

public class EtherItemTest extends EtherItemDoc{

    @Test
    public void runTest() throws Exception{
        getData(1);
        System.out.print(getList());
    }
}
