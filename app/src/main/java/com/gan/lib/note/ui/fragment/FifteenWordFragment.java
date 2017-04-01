package com.gan.lib.note.ui.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import com.gan.lib.frame.base.ViewModeRecyclerFragment;
import com.gan.lib.frame.base.ViewModelBaseFragment;
import com.gan.lib.note.R;
import com.gan.lib.note.viewmodel.fragment.FifteenWordVM;

/**
 *  Fifteen word item
 * Created by tangjun on 2017/3/29.
 */

public class FifteenWordFragment extends ViewModeRecyclerFragment<FifteenWordVM>{

    public static ViewModelBaseFragment newInstance() {
        return new FifteenWordFragment();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //设置第一次进入自动刷新
        setAutoRefresh();
        setModelView(this);
    }


    @Override
    public void initRefreshLayout(SwipeRefreshLayout refreshLayout) {
        refreshLayout.setColorSchemeColors(getResources().getColor(R.color.colorPrimary));
        refreshLayout.setDistanceToTriggerSync(300);
        refreshLayout.setProgressBackgroundColorSchemeColor(Color.WHITE);
        refreshLayout.setSize(SwipeRefreshLayout.DEFAULT);
    }
}
