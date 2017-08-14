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
                                                
# Refresh
                                                 <com.scwang.smartrefresh.layout.SmartRefreshLayout
                                                        android:id="@+id/refreshLayout"
                                                        android:layout_width="0dp"
                                                        android:layout_height="0dp"
                                                        app:layout_constraintBottom_toBottomOf="parent"
                                                        app:layout_constraintLeft_toLeftOf="parent"
                                                        app:layout_constraintRight_toRightOf="parent"
                                                        app:layout_constraintTop_toTopOf="parent"
                                                        app:srlEnablePreviewInEditMode="true">
                                                
                                                        <com.scwang.smartrefresh.layout.header.ClassicsHeader
                                                            android:layout_width="match_parent"
                                                            android:layout_height="48dp" />
                                                
                                                        <android.support.v7.widget.RecyclerView
                                                            android:id="@+id/recyclerView"
                                                            android:layout_width="match_parent"
                                                            android:layout_height="match_parent"
                                                            android:background="#fff"
                                                            android:overScrollMode="never" />
                                                
                                                    </com.scwang.smartrefresh.layout.SmartRefreshLayout>
                                                    
                                                    private void initView() {
                                                            refreshLayout = (SmartRefreshLayout) findViewById(R.id.refreshLayout);
                                                            recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
                                                            viewNoData = getLayoutInflater().inflate(R.layout.view_no_data, (ViewGroup) recyclerView.getParent(), false);
                                                            viewErr = getLayoutInflater().inflate(R.layout.view_err, (ViewGroup) recyclerView.getParent(), false);
                                                            viewNoData.setOnClickListener(new View.OnClickListener() {
                                                                @Override
                                                                public void onClick(View view) {
                                                                    quickAdapter.setNewData(listData);
                                                                }
                                                            });
                                                            viewErr.setOnClickListener(new View.OnClickListener() {
                                                                @Override
                                                                public void onClick(View view) {
                                                                    quickAdapter.setNewData(listData);
                                                                }
                                                            });
                                                    
                                                            refreshLayout.autoRefresh();
                                                            refreshLayout.setOnRefreshListener(new OnRefreshListener() {
                                                                @Override
                                                                public void onRefresh(RefreshLayout refreshlayout) {
                                                                    quickAdapter.setNewData(listData);
                                                                    refreshlayout.finishRefresh(2000);
                                                    //                quickAdapter.setNewData(null);
                                                    //                quickAdapter.setEmptyView(viewNoData);
                                                                }
                                                            });
                                                    
                                                    
                                                            recyclerView.setHasFixedSize(true);
                                                            recyclerView.setItemAnimator(new DefaultItemAnimator());
                                                            recyclerView.setLayoutManager(new LinearLayoutManager(this));
                                                            recyclerView.addItemDecoration(new DividerItemDecoration(this, VERTICAL));
                                                    
                                                            quickAdapter = new QuickAdapter();
                                                            quickAdapter.addHeaderView(viewErr);
                                                            quickAdapter.setEmptyView(viewNoData);
                                                            quickAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
                                                    
                                                            quickAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                                                                @Override
                                                                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                                                    Toasty.normal(MainActivity.this, "click " + position).show();
                                                                }
                                                            });
                                                    
                                                            quickAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
                                                                @Override
                                                                public void onLoadMoreRequested() {
                                                                    List<String> list = new ArrayList<>();
                                                                    for (int i = 0; i < 2; ++i) {
                                                                        list.add("" + i);
                                                                    }
                                                                    quickAdapter.addData(list);
                                                    //                quickAdapter.loadMoreComplete();
                                                    //                quickAdapter.loadMoreEnd();
                                                    //                quickAdapter.loadMoreFail();
                                                                }
                                                            }, recyclerView);
                                                    
                                                            quickAdapter.setLoadMoreView(new CustomLoadMoreView());
                                                            quickAdapter.isFirstOnly(false);
                                                            recyclerView.setAdapter(quickAdapter);
                                                    
                                                            for (int i = 0; i < 20; ++i) {
                                                                listData.add("" + i);
                                                            }
                                                        }
                                                