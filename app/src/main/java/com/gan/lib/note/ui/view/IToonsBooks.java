package com.gan.lib.note.ui.view;

import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

import com.gan.lib.frame.viewmodel.IView;

import me.yokeyword.fragmentation.SupportFragment;

/**
 *
 * Created by tangjun on 2017/4/19.
 */

public interface IToonsBooks extends IView{

    Toolbar getToolbar();

    FrameLayout getFrameLayout();

    void setToolbarTitle(String title);

    void addFragmentInFrame(SupportFragment fragment);
}
