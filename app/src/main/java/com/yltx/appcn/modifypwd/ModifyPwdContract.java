package com.yltx.appcn.modifypwd;

import android.content.Context;

import com.ixzus.applibrary.base.BaseContract;
import com.yltx.appcn.bean.ResetPwdBean;
import com.yltx.appcn.bean.ResetPwdRsBean;

/**
 * 功能描述:
 * Created by ixzus on 2017/8/3.
 *
 * 修改密码或者是重置密码的Contract
 *
 */

public class ModifyPwdContract {
    interface IModifyPwdView extends BaseContract.IBaseView {

        //@// TODO: 2017/8/22  获取旧密码
        String getOld();

        //@// TODO: 2017/8/22  获取新密码
        String getNew();

        //@// TODO: 2017/8/22  获取确认密码
        String getComfire();




        void onModifyPwdResult(String code);


        void onResetPwdResult(ResetPwdRsBean mResetPwdRsBean);

    }
    interface IModifyPwdPresenter extends BaseContract.IBasePresenter {

        void ModifyPwd(Context contex, String tag, String json);
        void  ModifyPwdResult(String resultJson);


        void ResetPwd(Context contex, String tag, ResetPwdBean mResetPwdBean);
        void  ResetPwdResult(ResetPwdRsBean mResetPwdRsBean);
    }
    interface IModifyPwdModel extends BaseContract.IBaseModel {

        void doModifyPwd(Context context, String tag, String postJson, IModifyPwdPresenter mPresenter);//发送验证码

        void doResetPwd(Context context, String tag, ResetPwdBean mResetPwdBean, IModifyPwdPresenter mPresenter);//发送验证码
    }
}
