package com.gan.lib.frame.base.view;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import com.gan.lib.frame.view.recycler.AutoLoadRecyclerView;
import com.gan.lib.frame.viewmodel.IView;

import java.util.List;

/**
 * RecyclerView fragment 的接口view
 * Created by tangjun on 2017/3/29.
 */

public interface IRecyclerView extends IView{


    /**
     *  获取swipeRefreshLayout
     */
    SwipeRefreshLayout getRefreshLayout();


    /**
     *  获取RecyclerView
     */
    RecyclerView getRecyclerView();


    /**
     *  设置RecyclerView的适配器
     */
    void setRecyclerAdapter(RecyclerView.Adapter adapter);

    /**
     *  初始化Recycler
     *  可以重写此方法设置自己想要的样式
     */
    void initRecycler();

    /**
     *  初始化RefreshLayout
     *  可以重写此方法设置自己想要的样式
     */
    void initRefreshLayout();

    /**
     *  设置下拉刷新监听事件
     */
    void setOnRefreshListener(SwipeRefreshLayout.OnRefreshListener listener);

    /**
     *  设置下拉刷新完成
     */
    void setRefreshFinish();

    /**
     *  设置加载更多
     */
    void setLoadingMoreListener(AutoLoadRecyclerView.onLoadMoreListener loadingMoreListener);

    /**
     *  判断加载更多是否完成
     */
    void setLoadMoreContinue();

    /**
     * 设置是否停止加载图片
     * @param pauseOnScroll 如果为true，滚动时停止加载图片
     * @param pauseOnFling  如果为true，飞滑时停止加载图片
     */
    void setOnPauseListenerParams(boolean pauseOnScroll, boolean pauseOnFling);

    /**
     * 设置自动刷新
     */
    void setAutoRefresh();
}
