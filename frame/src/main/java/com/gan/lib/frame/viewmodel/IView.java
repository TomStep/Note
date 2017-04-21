package com.gan.lib.frame.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.gan.lib.frame.base.ViewModelBaseActivity;
import com.gan.lib.frame.base.ViewModelBaseFragment;
import com.gan.lib.frame.viewmodel.binding.ViewModelBindingConfig;

import java.util.List;

import me.yokeyword.fragmentation.SupportFragment;


/**
 * Any Activity or Fragment that needs a ViewModel needs to implement this interface.
 * You don't need to implement it yourself - use {@link ViewModelBaseActivity} and
 * {@link ViewModelBaseFragment} instead.
 */
public interface IView {
    /**
     * This method is used for Data Binding to bind correct layout and variable automatically
     * Can return null value in case that Data Binding is not used.
     *
     * @return defined ViewModelBinding Config for a specific screen.
     */
    @Nullable
    ViewModelBindingConfig getViewModelBindingConfig();

    /**
     * Implement this method to remove the ViewModel associated with the Fragment or Activity.
     * This is usually implemented by calling {@link ViewModelHelper#removeViewModel(Activity)},
     * see {@link ViewModelBaseActivity#removeViewModel()} and {@link ViewModelBaseFragment#removeViewModel()}.
     */
    void removeViewModel();



    /**
     * Implement this method to get context the ViewModel associated with the Fragment or Activity.
     * see {@link ViewModelBaseActivity#getViewContext()} and {@link ViewModelBaseFragment#getViewContext()}.
     */
    @Nullable
    Context getViewContext();

    /***************************************************************************/

    /**
     * 装载根Fragment, 即Activity内的第一个Fragment 或 Fragment内的第一个子Fragment
     */
    void loadRootFragmentInIView(int containerId, SupportFragment toFragment);

    /**
     *  以replace方式装载根Fragment，使用场景见Demo的ShopFragment
     */
    void replaceLoadRootFragmentInView(int containerId, SupportFragment toFragment, boolean addToBack);

    /**
     *  装载多个根Fragment，用于同级Fragment的场景，详情见新Demo的MainActivity
     */
    void loadMultipleRootFragmentInView(int containerId, int showPosition, SupportFragment... toFragments);


    /**
     *  启动新的Fragment，启动者和被启动者是在同一个栈的
     */
    void startInIView(SupportFragment fragment);

    /**
     *  以某种启动模式，启动新的Fragment
     */
    void startInView(SupportFragment fragment, int launchMode);

    /**
     *  启动新的Fragment，并能接收到新Fragment的数据返回
     */
    void startWithPopInIView(SupportFragment fragment);

    /**
     * 出栈当前Fragment(在当前Fragment所在栈内pop)
     */
    void popInIView();

    /**
     * replace方式启动目标Fragment，配合replaceLoadRootFragment()使用
     */
    void replaceFragmentInIView(SupportFragment toFragment, boolean addToBack);
}
