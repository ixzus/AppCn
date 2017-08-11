package com.yltx.appcn.login;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yltx.appcn.R;

/**
 * 功能描述:
 * Created by ixzus on 2017/8/11.
 */

public class QuickAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public QuickAdapter() {
        super(R.layout.rv_item);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.text, item);
    }
}
