package com.gan.lib.frame.base;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bumptech.glide.Glide;
import com.gan.lib.frame.R;
import com.gan.lib.frame.base.view.IRecyclerView;
import com.gan.lib.frame.base.view.RecyclerViewModel;
import com.gan.lib.frame.view.recycler.AutoLoadRecyclerView;
import com.gan.lib.frame.view.recycler.DividerItemDecoration;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * 带有RecyclerView的基础fragment
 *    此fragment不用于fragment.start()开启新界面，请在此fragment外再套一层X fragment。用X.start()开启。
 * Created by tangjun on 2017/3/29.
 */
public abstract class ViewModeRecyclerFragment<I extends IRecyclerView,M extends RecyclerViewModel<I>> extends ViewModelBaseFragment<I,M> implements IRecyclerView {

    /**
     *  AutoLoadRecyclerView
     */
    private AutoLoadRecyclerView mRecyclerView;
    /**
     *  SwipeRefreshLayout
     */
    private SwipeRefreshLayout mRefreshLayout;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRecyclerView = (AutoLoadRecyclerView) view.findViewById(R.id.recycler_view);
        mRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh_layout);

        //初始化RefreshLayout
        initRefreshLayout(getRefreshLayout());
        //初始化RecyclerView
        initRecycler(getRecyclerView());
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recycler, container, false);
    }

    @Override
    public SwipeRefreshLayout getRefreshLayout() {
        return mRefreshLayout;
    }

    @Override
    public AutoLoadRecyclerView getRecyclerView() {
        return mRecyclerView;
    }

    @Override
    public void setRecyclerAdapter(RecyclerView.Adapter adapter) {
        getRecyclerView().setAdapter(adapter);
    }

    /**
     * 可以重写此方法设置自己想要的样式
     */
    @Override
    public void initRecycler(RecyclerView recyclerView) {
        //设置布局管理器
        recyclerView.setLayoutManager(new LinearLayoutManager(_mActivity));
        //设置Item增加、移除动画
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        //添加分割线
        recyclerView.addItemDecoration(new DividerItemDecoration(
                getActivity(), DividerItemDecoration.VERTICAL_LIST,0,Color.WHITE));

    }

    /**
     * 可以重写此方法设置自己想要的样式
     */
    @Override
    public void initRefreshLayout(SwipeRefreshLayout refreshLayout) {
        //设置进度条的颜色主题，最多能设置四种 加载颜色是循环播放的，只要没有完成刷新就会一直循环。
        refreshLayout.setColorSchemeColors(Color.BLUE, Color.GREEN, Color.YELLOW, Color.RED);
        // 设置手指在屏幕下拉多少距离会触发下拉刷新
        refreshLayout.setDistanceToTriggerSync(300);
        // 设定下拉圆圈的背景
        refreshLayout.setProgressBackgroundColorSchemeColor(Color.WHITE);
        // 设置圆圈的大小
        refreshLayout.setSize(SwipeRefreshLayout.DEFAULT);
    }

    @Override
    public void setOnRefreshListener(SwipeRefreshLayout.OnRefreshListener listener) {
        getRefreshLayout().setOnRefreshListener(listener);
    }

    @Override
    public void setRefreshFinish() {
        if(getRefreshLayout().isRefreshing()) getRefreshLayout().setRefreshing(false);
    }

    @Override
    public void setLoadingMoreListener(AutoLoadRecyclerView.onLoadMoreListener loadingMoreListener) {
        getRecyclerView().setLoadMoreListener(loadingMoreListener);
    }

    @Override
    public void setLoadMoreContinue() {
        getRecyclerView().loadMoreContinue();
    }

    @Override
    public void setOnPauseListenerParams(boolean pauseOnScroll, boolean pauseOnFling) {
        getRecyclerView().setOnPauseListenerParams(Glide.with(_mActivity),pauseOnScroll,pauseOnFling);
    }

    @Override
    public void setAutoRefresh() {
        getRefreshLayout().post(new Runnable() {
            @Override
            public void run() {
                getRefreshLayout().setRefreshing(true);
            }
        });
    }
}