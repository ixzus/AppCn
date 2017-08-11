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