# Dialog

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
                        
# ConfirmDialog
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
                                                      Toasty.normal(MainActivity.this, "kkkkkkkkk").show();
                                                      aaa();
                                                      dialog.dismiss();
                                                  }
                                              })
                                              .setMargin(60)
                                              .setOutCancel(false)
                                              .show(getSupportFragmentManager());
                        
# RxView
                  RxView.clicks(mButton)
                                  .throttleFirst(1, TimeUnit.SECONDS)
                                  .compose(bindUntilEvent(ActivityEvent.DESTROY))
                                  .subscribeOn(AndroidSchedulers.mainThread())
                                  .subscribe(new Consumer<Object>() {
                                      @Override
                                      public void accept(@NonNull Object o) throws Exception {
                                          Toasty.normal(MainActivity.this, "click").show();
                                      }
                                  });
                                  
# SuperButton
                                      <com.allen.library.SuperButton
                                          android:id="@+id/button"
                                          android:layout_width="100dp"
                                          android:layout_height="40dp"
                                          android:layout_margin="8dp"
                                          android:text="圆角边框"
                                          app:sCornersRadius="6dp"
                                          app:sSelectorDisableColor="@color/BlueGrey900"
                                          app:sSelectorNormalColor="@color/colorPrimary"
                                          app:sSelectorPressedColor="@color/colorAccent"
                                          app:sUseSelector="true" />
                                          
# SuperTextView
                                        <com.allen.library.SuperTextView
                                                android:layout_width="match_parent"
                                                android:layout_height="80dp"
                                                app:sCenterBottomTextColor="@color/colorAccent"
                                                app:sDividerLineColor="@color/BlueGrey900"
                                                app:sDividerLineType="bottom"
                                                app:sLeftIconRes="@mipmap/ic_launcher"
                                                app:sLeftTextString="限额说明"
                                                app:sRightIconRes="@mipmap/ic_launcher"
                                                app:sUseRipple="true" />
                                                
                                                