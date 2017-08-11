package com.yltx.appcn;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.ixzus.applibrary.widget.AbsDialog;
import com.ixzus.applibrary.widget.BaseDialog;
import com.ixzus.applibrary.widget.ViewConvertListener;
import com.ixzus.applibrary.widget.ViewHolder;
import com.yltx.appcn.widget.dialog.ConfirmDialog;

import es.dmoral.toasty.Toasty;
@Route(path = "/app/MainActivity")
public class MainActivity extends AppCompatActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                ConfirmDialog.newInstance("2")
//                        .setConfirmCancelListener(new ConfirmDialog.ConfirmCancelListener() {
//                            @Override
//                            public void convertView(ViewHolder holder, AbsDialog dialog) {
//                                Toast.makeText(MainActivity.this, "cancel", Toast.LENGTH_SHORT).show();
//                                dialog.dismiss();
//                            }
//                        })
//                        .setConfirmOkListener(new ConfirmDialog.ConfirmOkListener() {
//                            @Override
//                            public void convertView(ViewHolder holder, AbsDialog dialog) {
//                                Toasty.normal(MainActivity.this, "kkkkkkkkk").show();
//                                aaa();
//                                dialog.dismiss();
//                            }
//                        })
//                        .setMargin(60)
//                        .setOutCancel(false)
//                        .show(getSupportFragmentManager());

                BaseDialog.init()
                        .setLayoutId(R.layout.dialog_confirm)
                        .setConvertListener(new ViewConvertListener() {
                            @Override
                            public void convertView(ViewHolder holder, final AbsDialog dialog) {
                                holder.setOnClickListener(R.id.cancel, new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        dialog.dismiss();
                                    }
                                });
                                holder.setOnClickListener(R.id.ok, new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        aaa();
                                        dialog.dismiss();
                                    }
                                });
                            }
                        })
                        .setMargin(40)
                        .setDimAmount(0.3f)
                        .setAnimStyle(R.style.DialogAnimation)
                        .show(getSupportFragmentManager());

            }
        });
    }

    private void aaa() {
        ARouter.getInstance().build("/login/loginActivity").navigation(this, new NavCallback() {
            @Override
            public void onFound(Postcard postcard) {
                Log.e("ARouter", "找到了");
            }

            @Override
            public void onLost(Postcard postcard) {
                Log.e("ARouter", "找不到了");
            }

            @Override
            public void onArrival(Postcard postcard) {
                Log.e("ARouter", "跳转完了");
            }

            @Override
            public void onInterrupt(Postcard postcard) {
                Log.e("ARouter", "被拦截了");
            }
        });
    }

    private void initView() {
        mTextView = (TextView) findViewById(R.id.textView);
    }
}
