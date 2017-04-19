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
import com.gan.lib.note.viewmodel.fragment.ToonsBookRecyclerVM;

/**
 *
 * Created by tangjun on 2017/4/19.
 */

public class ToonsBookRecyclerFragment extends ViewModeRecyclerFragment<IRecyclerView,ToonsBookRecyclerVM> {
    private View mRootView;

    public static ToonsBookRecyclerFragment newInstance() {
        
        Bundle args = new Bundle();
        
        ToonsBookRecyclerFragment fragment = new ToonsBookRecyclerFragment();
        fragment.setArguments(args);
        return fragment;
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
    public void onDestroyView() {
        super.onDestroyView();
        if(null != mRootView){
            ((ViewGroup)mRootView.getParent()).removeView(mRootView);
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setAutoRefresh();
        setModelView(this);

    }

    @Override
    public void initRefreshLayout(SwipeRefreshLayout refreshLayout) {
        refreshLayout.setColorSchemeColors(Color.alpha(R.color.colorPrimary));
        refreshLayout.setDistanceToTriggerSync(300);
        refreshLayout.setProgressBackgroundColorSchemeColor(Color.WHITE);
        refreshLayout.setSize(SwipeRefreshLayout.DEFAULT);
    }

}
