package com.gan.lib.note.viewmodel.fragment;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;

import com.gan.lib.frame.base.view.IRecyclerView;
import com.gan.lib.frame.base.view.RecyclerViewModel;
import com.gan.lib.frame.viewmodel.AbstractViewModel;
import com.gan.lib.note.ui.view.IFifteenWordView;

/**
 *
 * Created by tangjun on 2017/3/29.
 */

public class FifteenWordVM extends RecyclerViewModel {
    @Override
    public void onReceive(Context context, Intent intent) {

    }


    @Override
    public void onBindView(@NonNull IRecyclerView view) {
        super.onBindView(view);




        view.setRecyclerAdapter(null);
    }
}
