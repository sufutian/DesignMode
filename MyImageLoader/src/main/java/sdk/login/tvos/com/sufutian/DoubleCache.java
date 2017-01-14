package sdk.login.tvos.com.sufutian;

import android.graphics.Bitmap;

/**
 * Created by sufutian on 2016/11/9/20:03.
 */

public class DoubleCache implements IImageCache {

    MemoryCache memoryCache=new MemoryCache();
    DiskCache diskCache=new DiskCache();
    IImageCache imageCache;
    @Override
    public void putBitmap(String urlkey, Bitmap bitmap) {
        memoryCache.putBitmap(urlkey,bitmap);
        diskCache.putBitmap(urlkey,bitmap);
    }

    @Override
    public Bitmap getBitmap(String urlKey) {
        Bitmap memoryCacheBitmap = memoryCache.getBitmap(urlKey);
        Bitmap diskCacheBitmap = diskCache.getBitmap(urlKey);
        if(memoryCacheBitmap!=null){
            return memoryCache.getBitmap(urlKey);
        }else if(diskCacheBitmap!=null){
            diskCache.getBitmap(urlKey);
        }else if(imageCache!=null){
            imageCache.getBitmap(urlKey);
        }
        return null;
    }
}
