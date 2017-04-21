package com.gan.lib.frame.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.gan.lib.frame.viewmodel.AbstractViewModel;
import com.gan.lib.frame.viewmodel.IView;
import com.gan.lib.frame.viewmodel.ProxyViewHelper;
import com.gan.lib.frame.viewmodel.ViewModelHelper;
import com.gan.lib.frame.viewmodel.binding.ViewModelBindingConfig;

import me.yokeyword.fragmentation.SupportFragment;


public abstract class ViewModelBaseActivity<T extends IView, R extends AbstractViewModel<T>> extends ViewModelBaseEmptyActivity implements IView  {

    @NonNull
    private final ViewModelHelper<T, R> mViewModeHelper = new ViewModelHelper<>();

    @CallSuper
    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Class<? extends AbstractViewModel<T>> viewModelClass = getViewModelClass();
        // try to extract the ViewModel class from the implementation
        if (viewModelClass == null) {
            //noinspection unchecked
            viewModelClass = (Class<? extends AbstractViewModel<T>>) ProxyViewHelper.getGenericType(getClass(), AbstractViewModel.class);
        }
        mViewModeHelper.onCreate(this, savedInstanceState, viewModelClass, getIntent().getExtras());
    }

    /**
     * Call this after your view is ready - usually on the end of {@link android.app.Activity#onCreate(Bundle)}
     * @param view view
     */
    @SuppressWarnings("unused")
    public void setModelView(@NonNull final T view) {
        mViewModeHelper.setView(view);
    }

    @Nullable
    public Class<R> getViewModelClass() {
        return null;
    }

    @CallSuper
    @Override
    public void onSaveInstanceState(@NonNull final Bundle outState) {
        super.onSaveInstanceState(outState);
        mViewModeHelper.onSaveInstanceState(outState);
    }

    @CallSuper
    @Override
    public void onStart() {
        super.onStart();
        mViewModeHelper.onStart();
    }

    @CallSuper
    @Override
    public void onStop() {
        super.onStop();
        mViewModeHelper.onStop(this);
    }

    @CallSuper
    @Override
    public void onDestroy() {
        mViewModeHelper.onDestroy(this);
        super.onDestroy();
    }

    /**
     * @see ViewModelHelper#getViewModel()
     */
    @SuppressWarnings("unused")
    @NonNull
    public R getViewModel() {
        return mViewModeHelper.getViewModel();
    }

    @Override
    public void removeViewModel() {
        mViewModeHelper.removeViewModel(this);
    }

    @Nullable
    @Override
    public ViewModelBindingConfig getViewModelBindingConfig() {
        return null;
    }

    @Nullable
    @Override
    public Context getViewContext() {
        return this;
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
    public void replaceFragmentInIView(SupportFragment toFragment, boolean addToBack) {}
}
