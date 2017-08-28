package com.yltx.appcn.utils;

import android.app.ActivityManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.NotificationCompat;
import android.util.Log;


import com.yltx.appcn.MainActivity;
import com.yltx.appcn.R;
import com.yltx.appcn.base.SplashActivity;
import com.yltx.appcn.bean.JPush;
import com.yltx.appcn.bean.OrderDetail;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


/**
 * 功能描述:
 * Created by ixzus on 2017/5/5.
 */

public class NotificationUtil {
    /**
     * 显示一个普通的通知  可以点击的
     *
     * @param context 上下文
     */
    public static void showNotification(Context context, String ticker, String title, String content, String code) {
        int requestCode = (int) System.currentTimeMillis();
        Notification notification = new NotificationCompat.Builder(context)
                /**设置通知左边的大图标**/
                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher))
                /**设置通知右边的小图标**/
                .setSmallIcon(R.mipmap.ic_launcher)
                /**通知首次出现在通知栏，带上升动画效果的**/
                .setTicker(ticker)
                /**设置通知的标题**/
                .setContentTitle(title)
                /**设置通知的内容**/
                .setContentText(content)
                /**通知产生的时间，会在通知信息里显示**/
                .setWhen(System.currentTimeMillis())
                /**设置该通知优先级**/
                .setPriority(Notification.PRIORITY_DEFAULT)
                /**设置这个标志当用户单击面板就可以让通知将自动取消**/
                .setAutoCancel(true)
                /**设置他为一个正在进行的通知。他们通常是用来表示一个后台任务,用户积极参与(如播放音乐)或以某种方式正在等待,因此占用设备(如一个文件下载,同步操作,主动网络连接)**/
                .setOngoing(false)
                /**向通知添加声音、闪灯和振动效果的最简单、最一致的方式是使用当前的用户默认设置，使用defaults属性，可以组合：**/
                .setDefaults(Notification.DEFAULT_VIBRATE | Notification.DEFAULT_SOUND)
//                .setContentIntent(PendingIntent.getActivity(context, 1, new Intent(context, flag ? MainActivity.class : SplashActivity.class), PendingIntent.FLAG_CANCEL_CURRENT))
                .setContentIntent(getDefalutIntent(context,code))
                .build();
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
        /**发起通知**/
        notificationManager.notify(requestCode, notification);
    }






    /**
     * @todo:调用 Notification
     * @Params context 上下文
     * @Params ticker
     * @Params title
     * @Params jpush 推送回来的实体类数据
     * **/
    public static void showNotification(Context context, String ticker, String title, JPush jpush){
        int requestCode = (int) System.currentTimeMillis();
        Notification notification = new NotificationCompat.Builder(context)
                /**设置通知左边的大图标**/
                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher))
                /**设置通知右边的小图标**/
                .setSmallIcon(R.mipmap.ic_launcher)
                /**通知首次出现在通知栏，带上升动画效果的**/
                .setTicker(ticker)
                /**设置通知的标题**/
                .setContentTitle(title)
                /**设置通知的内容**/
                .setContentText(jpush.getMsg())
                /**通知产生的时间，会在通知信息里显示**/
                .setWhen(System.currentTimeMillis())
                /**设置该通知优先级**/
                .setPriority(Notification.PRIORITY_DEFAULT)
                /**设置这个标志当用户单击面板就可以让通知将自动取消**/
                .setAutoCancel(true)
                /**设置他为一个正在进行的通知。他们通常是用来表示一个后台任务,用户积极参与(如播放音乐)或以某种方式正在等待,因此占用设备(如一个文件下载,同步操作,主动网络连接)**/
                .setOngoing(false)
                /**向通知添加声音、闪灯和振动效果的最简单、最一致的方式是使用当前的用户默认设置，使用defaults属性，可以组合：**/
                .setDefaults(Notification.DEFAULT_VIBRATE | Notification.DEFAULT_SOUND)
//                .setContentIntent(PendingIntent.getActivity(context, 1, new Intent(context, flag ? MainActivity.class : SplashActivity.class), PendingIntent.FLAG_CANCEL_CURRENT))
                               .setContentIntent(getDefalutIntent(context,jpush))

                .build();
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
        /**发起通知**/
//        notificationManager.notify(0, notification);
        notificationManager.notify(requestCode, notification);

    }



    /**
     * @todo: 判断是否是正常的推送
     * return true  表示返回的Type是定义的常规类型
     * return false 表示返回的Type是定义的非常规类型
     *
     * */
    private static boolean isNormalJpush(JPush jpush) {
//        if(jpush.getType().equals(Consta.JPushType.ORDER_PAY_SUCCESS)
//                ||jpush.getType().equals(Consta.JPushType.ORDER_PAY_FAIL)
//                ||jpush.getType().equals(Consta.JPushType.ORDER_PAY_BACK)
//                ||jpush.getType().equals(Consta.JPushType.ORDER_PAY_PREMIUM)
//                ||jpush.getType().equals(Consta.JPushType.ORDER_OFFER_SUCCESS)
//                ||jpush.getType().equals(Consta.JPushType.ORDER_OFFER_FAIL)
//                ){
//            return true;
//        }else{
//            return false;
//        }
        return true;
    }


    /**
     * 显示一个下载带进度条的通知
     *
     * @param context 上下文
     */
    public static void showNotificationProgress(Context context) {
        //进度条通知
        final NotificationCompat.Builder builderProgress = new NotificationCompat.Builder(context);
        builderProgress.setContentTitle("下载中");
        builderProgress.setSmallIcon(R.mipmap.ic_launcher);
        builderProgress.setTicker("进度条通知");
        builderProgress.setProgress(100, 0, false);
        final Notification notification = builderProgress.build();
        final NotificationManager notificationManager = (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
        //发送一个通知
        notificationManager.notify(2, notification);
        /**创建一个计时器,模拟下载进度**/
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            int progress = 0;

            @Override
            public void run() {
                Log.i("progress", progress + "");
                while (progress <= 100) {
                    progress++;
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    //更新进度条
                    builderProgress.setProgress(100, progress, false);
                    //再次通知
                    notificationManager.notify(2, builderProgress.build());
                }
                //计时器退出
                this.cancel();
                //进度条退出
                notificationManager.cancel(2);
                return;//结束方法
            }
        }, 0);
    }

    /**
     * 悬挂式，支持6.0以上系统
     *
     * @param context
     */
    public static void showFullScreen(Context context) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, mIntent, 0);
        builder.setContentIntent(pendingIntent);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher));
        builder.setAutoCancel(true);
        builder.setContentTitle("悬挂式通知");
        //设置点击跳转
        Intent hangIntent = new Intent();
        hangIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        hangIntent.setClass(context, MainActivity.class);
        //如果描述的PendingIntent已经存在，则在产生新的Intent之前会先取消掉当前的
        PendingIntent hangPendingIntent = PendingIntent.getActivity(context, 0, hangIntent, PendingIntent.FLAG_CANCEL_CURRENT);
        builder.setFullScreenIntent(hangPendingIntent, true);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
        notificationManager.notify(3, builder.build());
    }

    /**
     * 折叠式
     *
     * @param context
     */
    public static void shwoNotify(Context context) {
//        //先设定RemoteViews
//        RemoteViews view_custom = new RemoteViews(context.getPackageName(), R.layout.view_custom);
//        //设置对应IMAGEVIEW的ID的资源图片
//        view_custom.setImageViewResource(R.id.custom_icon, R.mipmap.icon);
//        view_custom.setTextViewText(R.id.tv_custom_title, "今日头条");
//        view_custom.setTextColor(R.id.tv_custom_title, Color.BLACK);
//        view_custom.setTextViewText(R.id.tv_custom_content, "金州勇士官方宣布球队已经解雇了主帅马克-杰克逊，随后宣布了最后的结果。");
//        view_custom.setTextColor(R.id.tv_custom_content, Color.BLACK);
//        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context);
//        mBuilder.setContent(view_custom)
//                .setContentIntent(PendingIntent.getActivity(context, 4, new Intent(context, MainActivity.class), PendingIntent.FLAG_CANCEL_CURRENT))
//                .setWhen(System.currentTimeMillis())// 通知产生的时间，会在通知信息里显示
//                .setTicker("有新资讯")
//                .setPriority(Notification.PRIORITY_HIGH)// 设置该通知优先级
//                .setOngoing(false)//不是正在进行的   true为正在进行  效果和.flag一样
//                .setSmallIcon(R.mipmap.icon);
//        Notification notify = mBuilder.build();
//        NotificationManager notificationManager = (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
//        notificationManager.notify(4, notify);
//    }
    }



    /**
     * @todo：判断app状态获得PendingIntent
     * @Params : code 跳转订单详情页面的OrderId
     *
     * **/
    public static PendingIntent getDefalutIntent(Context context, String code){
        // PendingIntent pendingIntent=PendingIntent.getActivity(context, 1, new Intent(context, flag ? MainActivity.class : SplashActivity.class), PendingIntent.FLAG_CANCEL_CURRENT)
        Log.d("NotificationReceiver", "==========getDefalutIntent");
        int requestIntCode = (int) System.currentTimeMillis();//创建一个随机的不重复的整数
        Intent intent = new Intent( context, OrderDetail.class);
        intent.putExtra("orderId", code);
        PendingIntent pendingIntent= PendingIntent.getActivity(context, requestIntCode,intent, PendingIntent.FLAG_CANCEL_CURRENT);
        return pendingIntent;
    }






    /**
     * @todo：通过推送回来的jpush内容来获取获得PendingIntent
     * @Params : jpush 推送返回的实体类
     *
     *
     * **/
    public static PendingIntent getDefalutIntent(Context context, JPush jpush){
        // PendingIntent pendingIntent=PendingIntent.getActivity(context, 1, new Intent(context, flag ? MainActivity.class : SplashActivity.class), PendingIntent.FLAG_CANCEL_CURRENT)
        Log.d("NotificationReceiver", "==========getDefalutIntent");
        int requestIntCode = (int) System.currentTimeMillis();//创建一个随机的不重复的整数
        //判断是否是正常的推送，
        if(isNormalJpush(jpush)){
            //跳转到订单详情页面
            Intent intent = new Intent( context, OrderDetail.class);
            intent.putExtra("orderId", jpush.getCode());
            Log.d("NotificationReceiver", "==========orderId::"+jpush.getCode());
            return PendingIntent.getActivity(context, requestIntCode,intent, PendingIntent.FLAG_CANCEL_CURRENT);//第二个参数为随机整数,
        }else{
            //跳转到启动页面
            Intent otherIntent = new Intent( context, SplashActivity.class);
            return PendingIntent.getActivity(context, requestIntCode,otherIntent, PendingIntent.FLAG_CANCEL_CURRENT);
        }

    }





    /**
     * 判断应用是否已经启动
     * @param context 一个context
     * @param packageName 要判断应用的包名
     * @return boolean
     */
    public static boolean isAppAlive(Context context, String packageName){
        ActivityManager activityManager =
                (ActivityManager)context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> processInfos
                = activityManager.getRunningAppProcesses();
        for(int i = 0; i < processInfos.size(); i++){
            if(processInfos.get(i).processName.equals(packageName)){
                Log.i("NotificationLaunch",
                        String.format("the %s is running, isAppAlive return true", packageName));
                return true;
            }
        }
        Log.i("NotificationLaunch",
                String.format("the %s is not running, isAppAlive return false", packageName));
        return false;
    }

}
