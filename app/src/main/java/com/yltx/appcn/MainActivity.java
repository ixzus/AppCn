package com.yltx.appcn;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.launcher.ARouter;
import com.yltx.appcn.widget.dialog.AbsDialog;
import com.yltx.appcn.widget.dialog.ConfirmDialog;
import com.yltx.appcn.widget.dialog.ViewHolder;

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
                ConfirmDialog.newInstance("2")
                        .setConfirmCancelListener(new ConfirmDialog.ConfirmCancelListener() {
                            @Override
                            public void convertView(ViewHolder holder, AbsDialog dialog) {
                                Toast.makeText(MainActivity.this, "cancel", Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                            }
                        })
                        .setConfirmOkListener(new ConfirmDialog.ConfirmOkListener() {
                            @Override
                            public void convertView(ViewHolder holder, AbsDialog dialog) {
                                Toast.makeText(MainActivity.this, "ok", Toast.LENGTH_SHORT).show();
                                ARouter.getInstance().build("/login/loginActivity").navigation();
                                dialog.dismiss();
                            }
                        })
                        .setMargin(60)
                        .setOutCancel(false)
                        .show(getSupportFragmentManager());
            }
        });
    }

    private void initView() {
        mTextView = (TextView) findViewById(R.id.textView);
    }
}
