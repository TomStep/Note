package com.gan.lib.frame.view.recycler.listener;

import android.view.View;

/**
 *
 * Created by tangjun on 2016/10/31.
 */
public interface OnRecyclerListener  {

        void onItemClick(View view, int position);

        void onItemLongClick(View view, int position);
}
