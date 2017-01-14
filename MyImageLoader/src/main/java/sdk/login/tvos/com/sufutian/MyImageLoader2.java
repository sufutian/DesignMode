package sdk.login.tvos.com.sufutian;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by sufutian on 2016/11/9/15:28.
 */

public class MyImageLoader2 {

    public MyImageLoader2(){};
    IImageCache imageCache = new MemoryCache(); //默认实现 可以通过依赖注入重新赋值
    ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());//线程池

    public void setImageCache(IImageCache cache) {
        imageCache = cache;
    }

    public void disPlayImage(String url, ImageView imageView) {
        if (imageCache != null) {
            Bitmap bitmap = imageCache.getBitmap(url);
            if (bitmap != null) {
                imageView.setImageBitmap(bitmap);
                return;
            } else {
                submitLoadFromNet(url, imageView);
            }
        }
    }

    /**
     * 开启线程池下载
     *
     * @param url
     * @param image
     */
    private void submitLoadFromNet(final String url, final ImageView image) {
        image.setTag(url);
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                //下载
                Bitmap bitmap = downLoadImage(url);
                if (bitmap != null) {
                    if (image.getTag().equals(url)) {
                        image.setImageBitmap(bitmap);
                    }
                    imageCache.putBitmap(url, bitmap);
                } else {
                    return;
                }
            }
        });

    }

    /**
     * 下载文件
     *
     * @param url
     * @return
     */
    private Bitmap downLoadImage(String url) {
        Bitmap bitmap = null;
        try {
            URL url1 = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) url1.openConnection();
            conn.connect();
            bitmap = BitmapFactory.decodeStream(conn.getInputStream());
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }
}
