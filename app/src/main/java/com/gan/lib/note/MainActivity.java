package com.gan.lib.note;

import android.os.Bundle;

import com.gan.lib.frame.base.ViewModelBaseEmptyActivity;
import com.gan.lib.note.ui.fragment.MainFragment;
import com.gan.lib.note.ui.view.IMainView;
import me.yokeyword.fragmentation.SupportFragment;


public class MainActivity extends ViewModelBaseEmptyActivity implements IMainView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        if(savedInstanceState == null){
            loadFragmentById(MainFragment.instance());
        }
    }

    @Override
    public void loadFragmentById(SupportFragment fragment) {
        loadRootFragment(R.id.frame_layout,fragment);
    }

}
