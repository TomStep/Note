package com.gan.lib.frame.base;

import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.gan.lib.frame.R;
import com.gan.lib.frame.base.view.BaseListViewModel;
import com.gan.lib.frame.base.view.ILisView;


/**
 *
 * Created by tangjun on 2017/3/16.
 */

public class ViewModelListFragment<T extends BaseListViewModel>
        extends ViewModelBaseFragment<ILisView,T>
        implements ILisView{


    private ListView mListView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    @CallSuper
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mListView = (ListView) view.findViewById(R.id.list_view);
    }

    @Override
    @SuppressWarnings("unused")
    public ListView getListView() {
        if(mListView == null){
            throw new NullPointerException("listView == null,super.onViewCreated() is none ?");
        }
        return mListView;
    }

    @Override
    @SuppressWarnings("unused")
    public void setListAdapter(ListAdapter adapter) {
        getListView().setAdapter(adapter);
    }

    @Override
    @SuppressWarnings("unused")
    public void setListDivider(@ColorInt int color) {
        getListView().setDivider(new ColorDrawable(color));
    }

    @Override
    @SuppressWarnings("unused")
    public void setListDividerHeight(int height) {
        getListView().setDividerHeight(height);
    }

    @Override
    @SuppressWarnings("unused")
    public void setListDivider(@ColorInt int color, int height) {
        setListDivider(color);
        setListDividerHeight(height);
    }

    @Override
    @SuppressWarnings("unused")
    public void setListHeadView(View headView) {
        getListView().addHeaderView(headView);
    }

    @Override
    @SuppressWarnings("unused")
    public void setListFootView(View footView) {
        getListView().addFooterView(footView);
    }

    @Override
    @SuppressWarnings("unused")
    public void setListViewBackground(@ColorInt int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            getListView().setBackground(new ColorDrawable(color));
            getListView().setScrollingCacheEnabled(false);
        }
    }

    @Override
    public void setChoiceMode(int choiceMode) {
        getListView().setChoiceMode(choiceMode);
    }

}
