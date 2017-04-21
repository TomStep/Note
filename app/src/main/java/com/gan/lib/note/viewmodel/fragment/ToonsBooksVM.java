package com.gan.lib.note.viewmodel.fragment;

import android.content.Context;
import android.content.Intent;

import com.gan.lib.frame.utils.LogUtils;
import com.gan.lib.frame.viewmodel.AbstractViewModel;
import com.gan.lib.note.broad.BroadLauncher;
import com.gan.lib.note.entiry.ToonsBookEntiry;
import com.gan.lib.note.ui.fragment.ToonsViewerFragment;
import com.gan.lib.note.ui.view.IToonsBooks;

/**
 *
 * Created by tangjun on 2017/4/19.
 */

public class ToonsBooksVM extends AbstractViewModel<IToonsBooks>{
    @Override
    public void onReceive(Context context, Intent intent) {
        if(null == getView()) return;

        switch (intent.getAction()){
            case BroadLauncher.ONCLICK_TOONS_BOOK_ITEM:
                ToonsBookEntiry entiry = BroadLauncher.receiveToonsBookItem(intent);

                getView().startInIView(ToonsViewerFragment.
                        newInstance(entiry.getTitle(),entiry.getUrl())
                );
                break;
        }
    }

    @Override
    public String[] getBroadAction() {
        return new String[]{
                BroadLauncher.ONCLICK_TOONS_BOOK_ITEM,
        };
    }
}
