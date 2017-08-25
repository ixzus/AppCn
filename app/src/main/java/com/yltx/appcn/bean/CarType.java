package com.yltx.appcn.bean;

/**
 * Author：Wq
 * Date：2017/8/24 17:07
 * Description：//todo
 */

public enum CarType {


//    <!--<li onclick="clickCarType('1','小型汽车')">小型汽车<>-->
//    <!--<li onclick="clickCarType('2','大型客车(A1)')">大型客车(A1)<>-->
//    <!--<li onclick="clickCarType('3','索引货车(A2)')">索引货车(A2)<>-->
//    <!--<li onclick="clickCarType('4','中型客车(B1)')">中型客车(B1)<>-->
//    <!--<li onclick="clickCarType('5','大型货车(B2)')">大型货车(B2)<>-->
//    <!--<li onclick="clickCarType('6','两/三轮摩托车')">两/三轮摩托车<>-->

    MIMIBUG("小型汽车", "1"), LARGEBUG("大型客车(A1)", "2"), INDEXTRUCK("索引货车(A2)", "3"), MIDDLEBUS("中型客车(B1)", "4"),BIGBUS("大型货车(B2)", "5"),MOTORCYLE("两/三轮摩托车", "6");
    // 成员变量
    private String name;
    private String index;
    // 构造方法
    private CarType (String name, String index) {
        this.name = name;
        this.index = index;
    }
    // 普通方法
    public static String getName(String index) {
        for (CarType c : CarType .values()) {
            if (c.getIndex().equals(index)) {
                return c.name;
            }
        }
        return null;
    }
    // get set 方法
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getIndex() {
        return index;
    }
    public void setIndex(String index) {
        this.index = index;
    }
}
