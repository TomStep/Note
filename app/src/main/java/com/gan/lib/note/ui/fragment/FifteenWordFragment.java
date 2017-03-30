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
 *  http://www.15yan.com/topic/bian-ji-tui-jian/
 *
 *
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
    public void initRefreshLayout() {
        //设置进度条的颜色主题，最多能设置四种 加载颜色是循环播放的，只要没有完成刷新就会一直循环。
        getRefreshLayout().setColorSchemeColors(getResources().getColor(R.color.colorPrimary));
        // 设置手指在屏幕下拉多少距离会触发下拉刷新
        getRefreshLayout().setDistanceToTriggerSync(300);
        // 设定下拉圆圈的背景
        getRefreshLayout().setProgressBackgroundColorSchemeColor(Color.WHITE);
        // 设置圆圈的大小
        getRefreshLayout().setSize(SwipeRefreshLayout.DEFAULT);
    }
}
