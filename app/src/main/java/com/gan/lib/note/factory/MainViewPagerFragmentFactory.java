package com.gan.lib.note.factory;

import com.gan.lib.frame.base.ViewModelBaseFragment;
import com.gan.lib.note.ui.fragment.FifteenWordFragment;

import java.util.HashMap;
import java.util.Map;

/**
 * main view pager fragment factory
 * 管理main viewPager中需要的所有fragment
 * Created by tangjun on 2017/3/29.
 */

public class MainViewPagerFragmentFactory {

    public enum MainFragments {
        FifteenWord("15言"),           //15言
        Ethermetic("Ethermetic")      //Ethermetic
        ;

        private String title;

        public String getTitle() {
            return title;
        }

        MainFragments(String title) {
            this.title = title;
        }
    }

    private Map<String,ViewModelBaseFragment> mFragments;

    private MainViewPagerFragmentFactory() {
        mFragments = new HashMap<>();
    }

    private static MainViewPagerFragmentFactory mInstance;

    public static MainViewPagerFragmentFactory getInstance(){
        if(mInstance == null){
            synchronized (MainViewPagerFragmentFactory.class){
                if(mInstance == null){
                    mInstance = new MainViewPagerFragmentFactory();
                }
            }
        }
        return mInstance;
    }

    /**
     *
     * @param index MainFragments enum
     * @return return ViewModelBaseFragment if mFragments != null,else
     *         return null
     */
    public ViewModelBaseFragment getFragment(MainFragments index){
        ViewModelBaseFragment fragment;

        if(mFragments == null)
            mFragments = new HashMap<>();

        if(mFragments.containsKey(index.name())) {
            fragment = mFragments.get(index.name());
        }else {
            fragment = addFragment(index);
        }

        return fragment;
    }

    /**
     * 给工厂添加fragment
     */
    private ViewModelBaseFragment addFragment(MainFragments index){
        ViewModelBaseFragment fragment = null;
        switch (index){
            case FifteenWord:
                fragment = FifteenWordFragment.newInstance();
                break;

            case Ethermetic:
                break;

            default:
                break;
        }

        mFragments.put(index.name(),fragment);
        return fragment;
    }

    /**
     * @return mFragments number
     */
    public int getFragmentsSize(){
        if(mFragments != null){
           return mFragments.size();
        }
        return 0;
    }

}
