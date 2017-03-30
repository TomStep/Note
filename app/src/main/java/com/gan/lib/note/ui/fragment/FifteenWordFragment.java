package com.gan.lib.note.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import com.gan.lib.frame.base.ViewModeRecyclerFragment;
import com.gan.lib.frame.base.ViewModelBaseFragment;
import com.gan.lib.note.viewmodel.fragment.FifteenWordVM;

/**
 *  http://www.15yan.com/
 *
 *
 * Created by tangjun on 2017/3/29.
 */

public class FifteenWordFragment extends ViewModeRecyclerFragment<FifteenWordVM>{

    public static ViewModelBaseFragment newInstance() {
        return new FifteenWordFragment();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        setModelView(this);
    }
}
