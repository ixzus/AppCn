package com.yltx.appcn.modifypwd;

import android.content.Context;

import com.ixzus.applibrary.base.BasePresenter;
import com.yltx.appcn.bean.ResetPwdBean;
import com.yltx.appcn.bean.ResetPwdRsBean;

/**
 * Author：Wq
 * Date：2017/8/22 9:49
 * Description：//todo
 */

public class ModifyPwdPersenter extends BasePresenter<ModifyPwdModel,ModifyPwdActivity> implements ModifyPwdContract.IModifyPwdPresenter{
    @Override
    public void ModifyPwd(Context contex, String tag, String json) {

    }

    @Override
    public void ModifyPwdResult(String resultJson) {

    }

    @Override
    public void ResetPwd(Context contex, String tag, ResetPwdBean mResetPwdBean) {

        model.doResetPwd(contex,tag,mResetPwdBean,this);

    }

    @Override
    public void ResetPwdResult(ResetPwdRsBean mResetPwdRsBean) {
        view.onResetPwdResult(mResetPwdRsBean);

    }
}
