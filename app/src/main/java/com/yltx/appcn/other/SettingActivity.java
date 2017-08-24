package com.yltx.appcn.other;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.allen.library.SuperTextView;
import com.ixzus.applibrary.impl.IToolbar;
import com.ixzus.applibrary.widget.AbsDialog;
import com.ixzus.applibrary.widget.ViewHolder;
import com.yltx.appcn.R;
import com.yltx.appcn.widget.dialog.ConfirmDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;

import static com.yltx.appcn.utils.Consta.sendSmsData.ModifyType;
import static com.yltx.appcn.utils.Consta.sendSmsData.ModifyType_Modify;

/**
 * Author：Wq
 * Date：2017/8/21 19:50
 * Description：//todo
 */

@Route(path = "/other/SettingActivity")
public class SettingActivity extends AppCompatActivity implements IToolbar {

    @BindView(R.id.toolbar_back)
    ImageView toolbarBack;
    @BindView(R.id.toolbar_back_text)
    TextView toolbarBackText;
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.st_modifypwd)
    SuperTextView stModifypwd;
    @BindView(R.id.st_close)
    SuperTextView stClose;
    @BindView(R.id.st_shock)
    SuperTextView stShock;
    @BindView(R.id.tv_quit)
    TextView tvQuit;
    @BindView(R.id.tv_msgshock)
    TextView tvMsgshock;
    @BindView(R.id.st_toclose)
    Switch stToclose;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ButterKnife.bind(this);

        initView();
        initEvent();
        initData();
    }

    private void initData() {


    }

    private void initEvent() {
        stModifypwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toNext();
            }
        });
        tvQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toQuit();
            }
        });
        stClose.setRightTvClickListener(new SuperTextView.OnRightTvClickListener() {
            @Override
            public void onClickListener() {
                Toast.makeText(SettingActivity.this, "关闭消息通知", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void toQuit() {
        ConfirmDialog.newInstance("3")
                .setConfirmCancelListener(new ConfirmDialog.ConfirmCancelListener() {
                    @Override
                    public void convertView(ViewHolder holder, AbsDialog dialog) {
                        Toast.makeText(SettingActivity.this, "cancel", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                })
                .setConfirmOkListener(new ConfirmDialog.ConfirmOkListener() {
                    @Override
                    public void convertView(ViewHolder holder, AbsDialog dialog) {
                        Toasty.normal(SettingActivity.this, "kkkkkkkkk").show();
                        dialog.dismiss();
                    }
                })
                .setMargin(34)
                .setOutCancel(false)
                .setAnimStyle(R.style.DialogAnimation)
                .show(getSupportFragmentManager());
    }


    private void toNext() {
        ARouter.getInstance().build("/modifypwd/ModifyPwdActivity")
                .withInt(ModifyType, ModifyType_Modify)
                .navigation(SettingActivity.this);
        finish();
    }

    private void initView() {
        toolbar("首页", true, null);


        stToclose.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                } else {

                }
            }
        });
    }


    protected void toolbar(String centerText, boolean isBack, String backText) {
        if (isBack) {
            findViewById(com.ixzus.applibrary.R.id.toolbar_back).setVisibility(View.VISIBLE);
        }
        if (!TextUtils.isEmpty(backText)) {
            ((TextView) findViewById(com.ixzus.applibrary.R.id.toolbar_back_text)).setText(backText);
        }
        if (!TextUtils.isEmpty(centerText)) {
            ((TextView) findViewById(com.ixzus.applibrary.R.id.toolbar_title)).setText(centerText);
        }

    }
}
