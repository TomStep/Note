package com.gan.lib.note.ui.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.gan.lib.frame.base.ViewModeRecyclerFragment;
import com.gan.lib.frame.base.view.IRecyclerView;
import com.gan.lib.note.R;
import com.gan.lib.note.viewmodel.fragment.ToonsHotVM;

/**
 *
 * Created by tangjun on 2017/4/12.
 */

public class ToonsHotFragment extends ViewModeRecyclerFragment<IRecyclerView,ToonsHotVM> {

    private View mRootView;

    public static ToonsHotFragment newInstance(){
        return new ToonsHotFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(null == mRootView) {
            mRootView = super.onCreateView(inflater, container, savedInstanceState);
        }
        return mRootView;
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
        refreshLayout.setColorSchemeResources(R.color.colorPrimary);
        refreshLayout.setDistanceToTriggerSync(300);
        refreshLayout.setProgressBackgroundColorSchemeColor(Color.WHITE);
        refreshLayout.setSize(SwipeRefreshLayout.DEFAULT);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(null != mRootView){
            ((ViewGroup)mRootView.getParent()).removeView(mRootView);
        }
    }

}
