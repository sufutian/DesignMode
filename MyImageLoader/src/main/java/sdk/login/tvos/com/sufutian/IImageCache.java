package sdk.login.tvos.com.sufutian;

import android.graphics.Bitmap;

/**
 * Created by sufutian on 2016/11/9/14:55.
 * 对外扩展
 */

public interface IImageCache {
    /**
     * 设置缓存
     * @param urlkey
     * @param bitmap
     */
     void putBitmap(String urlkey, Bitmap bitmap);

    /**
     * 获取缓存
     * @param urlKey
     * @return
     */
     Bitmap getBitmap(String urlKey);
}
