package com.example.cnsunrun.debugdemo.utils;

import android.text.TextUtils;

import java.io.File;


/**
 * Created by imRock on 15/6/30.
 * Under package la.juju.android.util.
 */
public class ImgUrlUtil {

    public static String TOPIC_DOWNLOAD_BASE_URL = "http://juju.inbbuy.cn";
    public static String COMMENT_DOWNLOAD_BASE_URL = "http://juju1.inbbuy.cn";
    public static String AVATAR_DOWNLOAD_BASE_URL = "http://juju2.inbbuy.cn";
    public static String PIC_QUALITY_KEY = "pic_quality";

    public static int quality;
    public static final int LOW_QUALITY = 40;
    public static final int MIDDLE_QUALITY = 60;
    public static final int HIGH_QUALITY = 90;

    public enum QUALITY {
        L, // 40Q
        M, // 60Q
        H, // 80Q
        X, // 90Q
        O, // 100Q
    }

    private ImgUrlUtil() {
    }

//    public synchronized boolean isValidUrl() {
//
//    }

    public enum AVATAR_NORMS {
        /**
         * <pre>0dp < size < 36dp</pre>
         */
        SMALL,
        /**
         * <pre>36dp <= size < 66dp</pre>
         */
        NORMAL,
        /**
         * <pre>66dp < size</pre>
         */
        LARGE
    }

    public synchronized static String getAvatarImgUrl(String urlOrOssKey, float dpSize) {
        final StringBuilder sb = ossKeyToUrl(urlOrOssKey, IMG_TYPE.AVATAR);
        if (sb.length() == 0) {
            return sb.toString(); // TODO should return a default failure pic url
        }
        float realToGetDpSize;
        if (0f < dpSize && dpSize < 36f) {
            realToGetDpSize = 24f; // small
        } else if (36f <= dpSize && dpSize < 66f) {
            realToGetDpSize = 48f; // normal
        } else if (66f < dpSize) {
            realToGetDpSize = 84f; // large
        } else {
            realToGetDpSize = 48f; //normal
        }
        final float sizeFloat = DisplayUtil.dpToPx(realToGetDpSize);
        int size = resizeQuality((int) Math.ceil(sizeFloat), quality);
        sb.append("@");
        sb.append(size);
        sb.append("w_");
        sb.append(size);
        sb.append("h_");
        sb.append(quality);
        sb.append("Q_");
        sb.append("2o_");
        sb.append("1e_1c.src");// 按短边缩放并自动中间裁减
        return sb.toString();
    }

    public synchronized static String getAvatarImgUrl(String urlOrOssKey) {
        final StringBuilder sb = ossKeyToUrl(urlOrOssKey, IMG_TYPE.AVATAR);
        if (sb.length() == 0) {
            return sb.toString(); // TODO should return a default failure pic url
        }
        return sb.toString();
    }


    public synchronized static String getTopicImgUrlInWaterFlow(String urlOrOssKey, int pxh) {
//        final StringBuilder sb = ossKeyToUrl(urlOrOssKey, IMG_TYPE.TOPIC);
//        if (sb.length() == 0) {
//            return sb.toString(); // TODO should return a default failure pic url
//        }
        final int screenWidth = DisplayUtil.getScreenWidth();
        final float gapsDp = 33.75f;
        final float gapsPx = DisplayUtil.dpToPx(gapsDp);
        final int pxw = (int) Math.ceil((screenWidth - gapsPx) / 2f);
        int heightC = (int) Math.ceil(((double) pxw * 1.5));
        if (pxh > 0)
            if (pxh > heightC) {
                pxh = heightC;
            }
        return getTopicImgUrl(urlOrOssKey, pxw, pxh);
//        sb.append("@");
//        sb.append(pxw);
//        sb.append("w_");
//        sb.append(quality);
//        sb.append("Q_");
//        sb.append("1l.jpg");// 如果目标缩略图大于原图不处理
//        return sb.toString();
    }

    public synchronized static String getTopicImgUrl(String urlOrOssKey) {
        final StringBuilder sb = ossKeyToUrl(urlOrOssKey, IMG_TYPE.TOPIC);
        if (sb.length() == 0) {
            return sb.toString(); // TODO should return a default failure pic url
        }
        return sb.toString();
    }

    public synchronized static String getTopicImgUrl(String urlOrOssKey, int pxw) {
        final StringBuilder sb = ossKeyToUrl(urlOrOssKey, IMG_TYPE.TOPIC);
        if (sb.length() == 0) {
            return sb.toString(); // TODO should return a default failure pic url
        }
        sb.append("@");
        sb.append(resizeQuality(pxw, quality));
        sb.append("w_");
        sb.append(quality);
        sb.append("Q_");
        sb.append("2o_");
        sb.append("1l.src");// 如果目标缩略图大于原图不处理
        return sb.toString();
    }

    public synchronized static String getTopicSourceImgUrl(String urlOrOssKey) {
        final StringBuilder sb = ossKeyToUrl(urlOrOssKey, IMG_TYPE.TOPIC);
        if (sb.length() == 0) {
            return sb.toString(); // TODO should return a default failure pic url
        }
        sb.append("@");
        sb.append(DisplayUtil.getScreenWidth());
        sb.append("w_");
        sb.append(100);
        sb.append("Q_");
        sb.append("2o_");
        sb.append("1l.src");// 如果目标缩略图大于原图不处理
        return sb.toString();
    }

    public synchronized static String getAvatarSourceImgUrl(String urlOrOssKey) {
        final StringBuilder sb = ossKeyToUrl(urlOrOssKey, IMG_TYPE.AVATAR);
        if (sb.length() == 0) {
            return sb.toString(); // TODO should return a default failure pic url
        }
        sb.append("@");
        sb.append(DisplayUtil.getScreenWidth());
        sb.append("w_");
        sb.append(100);
        sb.append("Q_");
        sb.append("2o_");
        sb.append("1l.src");// 如果目标缩略图大于原图不处理
        return sb.toString();
    }

    public synchronized static String getCommentSourceImgUrl(String urlOrOssKey) {
        final StringBuilder sb = ossKeyToUrl(urlOrOssKey, IMG_TYPE.COMMENT);
        if (sb.length() == 0) {
            return sb.toString(); // TODO should return a default failure pic url
        }
        sb.append("@");
        sb.append(DisplayUtil.getScreenWidth());
        sb.append("w_");
        sb.append(100);
        sb.append("Q_");
        sb.append("2o_");
        sb.append("1l.src");// 如果目标缩略图大于原图不处理
        return sb.toString();
    }

    public synchronized static String getEventImgUrl(String urlOrOssKey, int pxw, int pxh) {
        final StringBuilder sb = ossKeyToUrl(urlOrOssKey, IMG_TYPE.AVATAR);
        if (sb.length() == 0) {
            return sb.toString(); // TODO should return a default failure pic url
        }
        sb.append("@");
        sb.append(resizeQuality(pxw, quality));
        sb.append("w_");
        sb.append(resizeQuality(pxh, quality));
        sb.append("h_");
        sb.append(quality);
        sb.append("Q_");
        sb.append("2o_");
        sb.append("1l_1c.src");// 自动中间裁减, 如果目标缩略图大于原图不处理
        return sb.toString();
    }


    public synchronized static String getTopicImgUrl(String urlOrOssKey, int pxw, int pxh) {
        final StringBuilder sb = ossKeyToUrl(urlOrOssKey, IMG_TYPE.TOPIC);
        if (sb.length() == 0) {
            return sb.toString(); // TODO should return a default failure pic url
        }
        sb.append("@");
        sb.append(resizeQuality(pxw, quality));
        sb.append("w_");
        sb.append(resizeQuality(pxh, quality));
        sb.append("h_");
        sb.append(quality);
        sb.append("Q_");
        sb.append("2o_");
        sb.append("1l_1c.src");// 自动中间裁减, 如果目标缩略图大于原图不处理
        return sb.toString();
    }

    public synchronized static String getMomentTopicImgUrl(String urlOrOssKey, int pxw, int pxh) {
        final StringBuilder sb = ossKeyToUrl(urlOrOssKey, IMG_TYPE.TOPIC);
        if (sb.length() == 0) {
            return sb.toString(); // TODO should return a default failure pic url
        }
        sb.append("@");
        sb.append(resizeQuality(pxw, quality));
        sb.append("w_");
        sb.append(resizeQuality(pxh, quality));
        sb.append("h_");
        sb.append(quality);
        sb.append("Q_");
        sb.append("2o_");
        sb.append("1l.src");// 如果目标缩略图大于原图不处理
        return sb.toString();
    }


    public synchronized static String getCommentImgUrl(String urlOrOssKey, int pxw, int pxh) {
        final StringBuilder sb = ossKeyToUrl(urlOrOssKey, IMG_TYPE.COMMENT);
        if (sb.length() == 0) {
            return sb.toString(); // TODO should return a default failure pic url
        }
        sb.append("@");
        sb.append(resizeQuality(pxw, quality));
        sb.append("w_");
        sb.append(resizeQuality(pxh, quality));
        sb.append("h_");
        sb.append(quality);
        sb.append("Q_");
        sb.append("2o_");
        sb.append("1l_1c.src");// 自动中间裁减, 如果目标缩略图大于原图不处理
        return sb.toString();
    }

    public synchronized static String getCommentImgUrl(String urlOrOssKey, int pxw) {
        final StringBuilder sb = ossKeyToUrl(urlOrOssKey, IMG_TYPE.COMMENT);
        if (sb.length() == 0) {
            return sb.toString(); // TODO should return a default failure pic url
        }
        sb.append("@");
        sb.append(resizeQuality(pxw, quality));
        sb.append("w_");
        sb.append(quality);
        sb.append("Q_");
        sb.append("2o_");
        sb.append("1l.src");// 如果目标缩略图大于原图不处理
        return sb.toString();
    }

    public synchronized static String getCommentImgUrl(String urlOrOssKey) {
        final StringBuilder sb = ossKeyToUrl(urlOrOssKey, IMG_TYPE.COMMENT);
        if (sb.length() == 0) {
            return sb.toString(); // TODO should return a default failure pic url
        }
        return sb.toString();
    }

    public enum IMG_TYPE {
        AVATAR, TOPIC, COMMENT
    }

    private static int resizeQuality(int size, int quality) {
        switch (quality) {
            case LOW_QUALITY:
                size = size / 2;
                break;
            case MIDDLE_QUALITY:
                size = (int) (size / 1.5);
                break;
            case HIGH_QUALITY:
                break;
        }
        return size;
    }


    public synchronized static String getImgUrl(String urlOrOssKey, IMG_TYPE type, boolean isOrigin) {
        if (type==null){
            return urlOrOssKey;
        }
        switch (type) {
            case AVATAR:
                return isOrigin ? getAvatarImgUrl(urlOrOssKey) : getAvatarSourceImgUrl(urlOrOssKey);
            case TOPIC:
                return isOrigin ? getTopicImgUrl(urlOrOssKey) : getTopicSourceImgUrl(urlOrOssKey);
            case COMMENT:
                return isOrigin ? getCommentImgUrl(urlOrOssKey) : getCommentSourceImgUrl(urlOrOssKey);
            default:
                return "";
        }
    }

    // 兼容老板版数据
    public synchronized static StringBuilder ossKeyToUrl(String urlOrOssKey, IMG_TYPE type) {
        final StringBuilder sb = new StringBuilder();
        if (TextUtils.isEmpty(urlOrOssKey)) {
            return sb;
        }
        if (urlOrOssKey.startsWith("http")) {
            sb.append(urlOrOssKey);
        } else {
            switch (type) {
                case AVATAR:
                    sb.append(AVATAR_DOWNLOAD_BASE_URL);
                    break;
                case TOPIC:
                    sb.append(TOPIC_DOWNLOAD_BASE_URL);
                    break;
                case COMMENT:
                    sb.append(COMMENT_DOWNLOAD_BASE_URL);
                    break;
            }
            final String fs = File.separator;
            final int p = urlOrOssKey.indexOf(fs);
            if (0 != p) {
                sb.append(fs);
            }
            sb.append(urlOrOssKey);
        }
        return sb;
    }

}
