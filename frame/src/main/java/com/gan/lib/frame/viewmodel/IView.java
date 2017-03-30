package com.gan.lib.frame.viewmodel;

import android.app.Activity;
import android.support.annotation.Nullable;

import com.gan.lib.frame.base.ViewModelBaseActivity;
import com.gan.lib.frame.base.ViewModelBaseFragment;
import com.gan.lib.frame.viewmodel.binding.ViewModelBindingConfig;

import java.util.List;


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
}
