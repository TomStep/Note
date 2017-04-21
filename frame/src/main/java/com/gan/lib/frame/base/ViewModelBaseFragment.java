package com.gan.lib.frame.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import com.gan.lib.frame.viewmodel.AbstractViewModel;
import com.gan.lib.frame.viewmodel.IView;
import com.gan.lib.frame.viewmodel.ProxyViewHelper;
import com.gan.lib.frame.viewmodel.ViewModelHelper;
import com.gan.lib.frame.viewmodel.binding.ViewModelBindingConfig;
import me.yokeyword.fragmentation.SupportFragment;


public abstract class ViewModelBaseFragment<T extends IView, R extends AbstractViewModel<T>> extends SupportFragment implements IView{

    @NonNull
    private final ViewModelHelper<T, R> mViewModelHelper = new ViewModelHelper<>();


    @CallSuper
    @Override
    public void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Class<? extends AbstractViewModel<T>> viewModelClass = getViewModelClass();
        // try to extract the ViewModel class from the implementation
        if (viewModelClass == null) {
            //noinspection unchecked
            viewModelClass = (Class<? extends AbstractViewModel<T>>) ProxyViewHelper.getGenericType(getClass(), AbstractViewModel.class);
        }
        getViewModelHelper().onCreate(getActivity(), savedInstanceState, viewModelClass, getArguments());
    }

    @CallSuper
    @Override
    public void onSaveInstanceState(@NonNull final Bundle outState) {
        super.onSaveInstanceState(outState);
        getViewModelHelper().onSaveInstanceState(outState);
    }

    @CallSuper
    @Override
    public void onStart() {
        super.onStart();
        getViewModelHelper().onStart();
    }

    @CallSuper
    @Override
    public void onStop() {
        super.onStop();
        getViewModelHelper().onStop(this.getContext());
    }

    @CallSuper
    @Override
    public void onDestroyView() {
        getViewModelHelper().onDestroyView(this);
        super.onDestroyView();
    }

    @CallSuper
    @Override
    public void onDestroy() {
        getViewModelHelper().onDestroy(this);
        super.onDestroy();
    }

    @Nullable
    public Class<R> getViewModelClass() {
        return null;
    }

    /**
     * @see ViewModelHelper#getViewModel()
     */
    @NonNull
    @SuppressWarnings("unused")
    public R getViewModel() {
        return getViewModelHelper().getViewModel();
    }

    @Nullable
    @Override
    public ViewModelBindingConfig getViewModelBindingConfig() {
        return null;
    }

    @NonNull
    public ViewModelHelper<T, R> getViewModelHelper() {
        return mViewModelHelper;
    }

    @Override
    public void removeViewModel() {
        mViewModelHelper.removeViewModel(getActivity());
    }

    /**
     * Call this after your view is ready - usually on the end of {@link
     * Fragment#onViewCreated(View, Bundle)}
     *
     * @param view view
     */
    protected void setModelView(@NonNull final T view) {
        getViewModelHelper().setView(view);
    }

    @Nullable
    @Override
    public Context getViewContext() {
        return _mActivity;
    }

    @Override
    public void loadMultipleRootFragmentInView(int containerId, int showPosition, SupportFragment... toFragments) {
        this.loadMultipleRootFragment(containerId,showPosition,toFragments);
    }

    @Override
    public void loadRootFragmentInIView(int containerId, SupportFragment toFragment) {
        this.loadRootFragment(containerId,toFragment);
    }

    @Override
    public void replaceLoadRootFragmentInView(int containerId, SupportFragment toFragment, boolean addToBack) {
        this.replaceLoadRootFragment(containerId,toFragment,addToBack);
    }

    @Override
    public void startInIView(SupportFragment fragment) {
        this.start(fragment);
    }

    @Override
    public void startInView(SupportFragment toFragment, int launchMode) {
        this.start(toFragment, launchMode);
    }

    @Override
    public void startWithPopInIView(SupportFragment fragment) {
        this.startWithPop(fragment);
    }

    @Override
    public void popInIView() {
        this.pop();
    }

    @Override
    public void replaceFragmentInIView(SupportFragment toFragment, boolean addToBack) {
        this.replaceFragment(toFragment,addToBack);
    }
}
