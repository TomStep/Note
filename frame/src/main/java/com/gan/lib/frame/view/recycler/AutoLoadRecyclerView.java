package com.gan.lib.frame.view.recycler;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import com.bumptech.glide.RequestManager;
import com.gan.lib.frame.view.recycler.listener.LoadFinishCallBack;


/**
 *
 * Created by tangjun on 2016/11/23.
 */

public class AutoLoadRecyclerView extends RecyclerView implements LoadFinishCallBack {
    private onLoadMoreListener loadMoreListener;
    private boolean isLoadingMore;
    private RecyclerView.Adapter adapter;

    public AutoLoadRecyclerView(Context context) {
        this(context, null);
    }

    public AutoLoadRecyclerView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AutoLoadRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        isLoadingMore = false;
        setOnScrollListener(new AutoLoadScrollListener(null, true, true));
    }

    /**
     * 配置显示图片，需要设置这几个参数，快速滑动时，暂停图片加载
     *
     * @param imageLoader   ImageLoader实例对象
     * @param pauseOnScroll
     * @param pauseOnFling
     */
    public void setOnPauseListenerParams(RequestManager imageLoader, boolean pauseOnScroll, boolean pauseOnFling) {

        setOnScrollListener(new AutoLoadScrollListener(imageLoader, pauseOnScroll, pauseOnFling));

    }

    @Override
    public void setAdapter(Adapter adapter) {
        if(adapter instanceof RecyclerView.Adapter) {
            this.adapter = adapter;
        }
        super.setAdapter(adapter);
    }

    public void setLoadMoreListener(onLoadMoreListener loadMoreListener) {
        this.loadMoreListener = loadMoreListener;
    }

    @Override
    public void loadMoreContinue() {
        isLoadingMore = false;
    }

    //加载更多的回调接口
    public interface onLoadMoreListener {
        void loadMore();
    }


    private class AutoLoadScrollListener extends OnScrollListener {

        private RequestManager imageLoader;
        private final boolean pauseOnScroll;
        private final boolean pauseOnFling;

        public AutoLoadScrollListener(RequestManager imageLoader, boolean pauseOnScroll, boolean pauseOnFling) {
            super();
            this.pauseOnScroll = pauseOnScroll;
            this.pauseOnFling = pauseOnFling;
            this.imageLoader = imageLoader;
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);

            if (getLayoutManager() instanceof LinearLayoutManager) {
                int lastVisibleItem = ((LinearLayoutManager) getLayoutManager()).findLastVisibleItemPosition();
                int totalItemCount = AutoLoadRecyclerView.this.getAdapter().getItemCount();

                if (loadMoreListener != null && !isLoadingMore && lastVisibleItem >= totalItemCount -
                        2 && dy > 0) {
                    isLoadingMore = true;
                    loadMoreListener.loadMore();
                }

            }
        }

        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {

            if (imageLoader != null) {
                switch (newState) {
                    case 0://屏幕停止滚动时为0
                        imageLoader.resumeRequests();
                        break;

                    case 1://触碰或手指还在屏幕上时为1
                        if (pauseOnScroll) {
                            imageLoader.pauseRequests();
                        } else {
                            imageLoader.resumeRequests();
                        }
                        break;

                    case 2://屏幕产生惯性滑动时为2
                        if (pauseOnFling) {
                            imageLoader.pauseRequests();
                        } else {
                            imageLoader.resumeRequests();
                        }
                        break;
                }
            }
        }
    }
}
