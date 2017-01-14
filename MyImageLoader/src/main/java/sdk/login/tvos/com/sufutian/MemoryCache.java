package sdk.login.tvos.com.sufutian;

import android.graphics.Bitmap;
import android.util.Log;
import android.util.LruCache;

/**
 * Created by sufutian on 2016/11/9/14:59.
 */

public class MemoryCache implements IImageCache {


    LruCache<String,Bitmap> memoryCache;

    public MemoryCache() {
        initCache();
    }

    private void initCache() {
        long maxMemory = Runtime.getRuntime().maxMemory();
        final int  cacheSize= (int) (maxMemory/4);
        memoryCache=new LruCache<String,Bitmap>(cacheSize){
            @Override
            protected int sizeOf(String urlkey, Bitmap bitmap) {
                return bitmap.getRowBytes()*bitmap.getHeight();//dont forget
            }
        };
    }

    @Override
    public void putBitmap(String urlkey, Bitmap bitmap) {
        memoryCache.put(urlkey,bitmap);
    }

    @Override
    public Bitmap getBitmap(String urlKey) {
        Log.i("getBitmap", "memory: ");
        return memoryCache.get(urlKey);
    }
}
