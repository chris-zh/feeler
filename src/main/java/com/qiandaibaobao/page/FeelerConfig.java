package com.qiandaibaobao.page;

/**
 * Created by chris.zhang on 16-6-27.
 */
public class FeelerConfig {
//    public final String avatarPath = "/home/xh/java/feeler/userfiles/";
    public static final String avatarPath = "src/main/webapp/resources/";

    public static final String userImageRelativeBasePath = "resources//userImage//";

    private  final String smallPrefix = "small_";
    private  final String bigPrefix = "big_";

    private  final int[] smallAvatar = {35, 35};

    private  final int[] bigAvatar = {250, 250};

    public  String getAvatarPath() {
        return avatarPath;
    }

    public  String getUserImageRelativeBasePath() {
        return userImageRelativeBasePath;
    }

    public  String getSmallPrefix() {
        return smallPrefix;
    }

    public  String getBigPrefix() {
        return bigPrefix;
    }

    public  int[] getSmallAvatar() {
        return smallAvatar;
    }

    public  int[] getBigAvatar() {
        return bigAvatar;
    }




}
