package com.yltx.appcn.modifypwd;

import android.content.Context;

import com.ixzus.applibrary.base.BasePresenter;
import com.yltx.appcn.bean.ModifyPwdBean;
import com.yltx.appcn.bean.ResetPwdBean;
import com.yltx.appcn.bean.ResetPwdRsBean;

/**
 * Author：Wq
 * Date：2017/8/22 9:49
 * Description：//todo
 */

public class ModifyPwdPersenter extends BasePresenter<ModifyPwdModel,ModifyPwdActivity> implements ModifyPwdContract.IModifyPwdPresenter{
    @Override
    public void ModifyPwd(Context contex, String tag, ModifyPwdBean mModifyPwdBean) {

        model.doModifyPwd(contex,tag,mModifyPwdBean,this);

    }

    @Override
    public void ModifyPwdResult(ResetPwdRsBean mResetPwdRsBean) {

        view.onModifyPwdResult(mResetPwdRsBean);

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
