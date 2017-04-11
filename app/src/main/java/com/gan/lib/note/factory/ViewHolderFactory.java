package com.gan.lib.note.factory;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.gan.lib.note.INewViewHolder;
import com.gan.lib.note.databinding.HolderEthermeticItemBinding;
import com.gan.lib.note.databinding.HolderFifteenWordArticleBinding;
import com.gan.lib.note.ui.holder.EthermeticItemVH;
import com.gan.lib.note.ui.holder.FifteenWordVH;

/**
 *
 * Created by tangjun on 2017/3/30.
 */

public class ViewHolderFactory implements INewViewHolder {

    private static INewViewHolder factory= null;

    public static INewViewHolder instance(){
        if(factory == null){
            synchronized (ViewHolderFactory.class){
                if(factory == null){
                    factory = new ViewHolderFactory();
                }
            }
        }

        return factory;
    }

    private LayoutInflater getLayoutInflater(ViewGroup viewGroup){
        return LayoutInflater.from(viewGroup.getContext());
    }

    @Override
    public FifteenWordVH getFifteenVH(ViewGroup viewGroup) {
        return new FifteenWordVH(HolderFifteenWordArticleBinding.inflate(getLayoutInflater(viewGroup),viewGroup,false));
    }

    @Override
    public EthermeticItemVH getEthermeticItemVH(ViewGroup viewGroup) {
        return new EthermeticItemVH(HolderEthermeticItemBinding.inflate(getLayoutInflater(viewGroup),viewGroup,false));
    }
}
