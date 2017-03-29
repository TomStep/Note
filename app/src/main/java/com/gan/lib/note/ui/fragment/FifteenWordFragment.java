package com.gan.lib.note.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.gan.lib.frame.base.ViewModelBaseBindingFragment;
import com.gan.lib.frame.base.ViewModelBaseFragment;
import com.gan.lib.frame.viewmodel.binding.ViewModelBindingConfig;
import com.gan.lib.note.R;
import com.gan.lib.note.databinding.FragmentFifteenWordBinding;
import com.gan.lib.note.ui.view.IFifteenWordView;
import com.gan.lib.note.viewmodel.fragment.FifteenWordVM;

/**
 *  http://www.15yan.com/
 *
 *
 * Created by tangjun on 2017/3/29.
 */

public class FifteenWordFragment
        extends ViewModelBaseBindingFragment<IFifteenWordView,FifteenWordVM,FragmentFifteenWordBinding>
        implements IFifteenWordView {

    public static ViewModelBaseFragment newInstance() {
        return new FifteenWordFragment();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setModelView(this);
    }


    @Nullable
    @Override
    public ViewModelBindingConfig getViewModelBindingConfig() {
        return new ViewModelBindingConfig(R.layout.fragment_fifteen_word,_mActivity);
    }
}
