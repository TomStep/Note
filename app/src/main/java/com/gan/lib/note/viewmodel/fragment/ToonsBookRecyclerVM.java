package com.gan.lib.note.viewmodel.fragment;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;

import com.gan.lib.frame.base.view.IRecyclerView;
import com.gan.lib.frame.base.view.RecyclerViewModel;
import com.gan.lib.note.broad.BroadLauncher;
import com.gan.lib.note.data.ToonsBookDoc;

/**
 *
 * Created by tangjun on 2017/4/19.
 */

public class ToonsBookRecyclerVM extends RecyclerViewModel<IRecyclerView>{
    @Override
    public void onReceive(Context context, Intent intent) {
        switch (intent.getAction()){
            case BroadLauncher.SEND_TOONS_BOOKS_ENTIRY:

                break;


        }

    }

    @Override
    public void onBindView(@NonNull IRecyclerView view) {
        super.onBindView(view);

        ToonsBookDoc bookDoc = new ToonsBookDoc();

    }

    @Override
    public String[] getBroadAction() {
        return new String[]{
                BroadLauncher.SEND_TOONS_BOOKS_ENTIRY,
        };
    }


}
