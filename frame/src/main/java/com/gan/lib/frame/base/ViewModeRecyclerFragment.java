package com.gan.lib.frame.base;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.gan.lib.frame.R;
import com.gan.lib.frame.base.view.IRecyclerView;
import com.gan.lib.frame.base.view.RecyclerViewModel;
import com.gan.lib.frame.databinding.FragmentRecyclerBinding;
import com.gan.lib.frame.view.recycler.DividerItemDecoration;
import com.gan.lib.frame.viewmodel.binding.ViewModelBindingConfig;

/**
 * 带有RecyclerView的基础fragment
 * Created by tangjun on 2017/3/29.
 */
public class ViewModeRecyclerFragment<M extends RecyclerViewModel>
        extends ViewModelBaseBindingFragment<IRecyclerView,M,FragmentRecyclerBinding>
        implements IRecyclerView {

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //初始化RefreshLayout
        initRefreshLayout();
        //初始化RecyclerView
        initRecycler();
    }


    @Nullable
    @Override
    public ViewModelBindingConfig getViewModelBindingConfig() {
        return new ViewModelBindingConfig(R.layout.fragment_recycler, _mActivity);
    }

    @Override
    public SwipeRefreshLayout getRefreshLayout() {
        return getBinding().swipeRefreshLayout;
    }

    @Override
    public RecyclerView getRecyclerView() {
        return getBinding().recyclerView;
    }

    @Override
    public void setRecyclerAdapter(RecyclerView.Adapter adapter) {
        getRecyclerView().setAdapter(adapter);
    }

    /**
     * 可以重写此方法设置自己想要的样式
     */
    @Override
    public void initRecycler() {
        //设置布局管理器
        getRecyclerView().setLayoutManager(new LinearLayoutManager(_mActivity));
        //设置Item增加、移除动画
        getRecyclerView().setItemAnimator(new DefaultItemAnimator());
        //添加分割线
        getRecyclerView().addItemDecoration(new DividerItemDecoration(
                getActivity(), DividerItemDecoration.HORIZONTAL_LIST));

    }

    /**
     * 可以重写此方法设置自己想要的样式
     */
    @Override
    public void initRefreshLayout() {
        //设置进度条的颜色主题，最多能设置四种 加载颜色是循环播放的，只要没有完成刷新就会一直循环。
        getRefreshLayout().setColorSchemeColors(
                Color.BLUE, Color.GREEN, Color.YELLOW, Color.RED);

        // 设置手指在屏幕下拉多少距离会触发下拉刷新
        getRefreshLayout().setDistanceToTriggerSync(300);
        // 设定下拉圆圈的背景
        getRefreshLayout().setProgressBackgroundColorSchemeColor(Color.WHITE);
        // 设置圆圈的大小
        getRefreshLayout().setSize(SwipeRefreshLayout.DEFAULT);
    }

    @Override
    public void setOnRefreshListener(SwipeRefreshLayout.OnRefreshListener listener) {
        getRefreshLayout().setOnRefreshListener(listener);
    }

}