package com.gan.lib.note;

import android.view.ViewGroup;

import com.gan.lib.note.ui.holder.EthermeticItemVH;
import com.gan.lib.note.ui.holder.FifteenWordVH;
import com.gan.lib.note.ui.holder.ToonsBookVH;
import com.gan.lib.note.ui.holder.ToonsHotVH;
import com.gan.lib.note.viewmodel.fragment.EthermeticVM;

/**
 * new view holder
 * Created by tangjun on 2017/3/30.
 */
public interface INewViewHolder {

    /**
     * 获取HolderFifteenWordArticleBinding
     */
    FifteenWordVH getFifteenVH(ViewGroup viewGroup);


    /**
     * 获取holder EthermeticItemVH
     */
    EthermeticItemVH getEthermeticItemVH(ViewGroup viewGroup);

    /**
     * 获取holder ToonsHotVH
     */
    ToonsHotVH getToonsHotItemVH(ViewGroup viewGroup);

    /**
     * 获取holder ToonsBookVH
     */
    ToonsBookVH getToonsBookItemVH(ViewGroup viewGroup);

}
