package com.gan.lib.frame.base.view;

import android.support.annotation.ColorInt;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.gan.lib.frame.viewmodel.IView;

/**
 * base list view
 * Created by tangjun on 2017/3/16.
 */

public interface ILisView extends IView {

    /**
     * 获取listView
     */
    ListView getListView();


    /**
     * 设置适配器
     */
    void setListAdapter(ListAdapter adapter);

    /**
     * 设置分割线颜色
     */
    void setListDivider(@ColorInt int color);


    /**
     * 设置分割线高度
     * @param height px
     */
    void setListDividerHeight(int height);

    /**
     * 设置分割线颜色和高度
     * @param color color
     * @param height px
     */
    void setListDivider(@ColorInt int color,int height);

    /**
     * 设置listView头部布局
     * @param headView  headView
     */
    void setListHeadView(View headView);

    /**
     * 设置listView尾部布局
     * @param footView footView
     */
    void setListFootView(View footView);

    /**
     * 设置listView背景颜色
     * @param color color
     */
    void setListViewBackground(@ColorInt int color);


    /**
     * listView具有选择模式
     * @param choiceMode {@link android.widget.ListView}
     *
     *  当listView不是默认模式时(CHOICE_MODE_NONE) ,item要实现Checkable接口后，才有效。
     *
     */
    void setChoiceMode(int choiceMode);

}
