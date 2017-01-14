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

public class MyImageLoader {


    private ImageLoaderConfig loaderConfig;
    private IImageCache imageCache=new MemoryCache(); //默认实现 可以通过依赖注入重新赋值
    private int threadCount=Runtime.getRuntime().availableProcessors();
    private int defaultImageId;

    /*private MyImageLoader() { //静态内部类单列 推荐使用
    }
    public static MyImageLoader getInstance() {
        return MyImageLoaderHolder.sInstance;
    }

    private static class MyImageLoaderHolder {
        private static final MyImageLoader sInstance = new MyImageLoader();
    }*/


    private MyImageLoader(){};  //懒汉式
    private static MyImageLoader instance;
    public static  synchronized MyImageLoader getInstance(){
        if(instance==null){
            instance=new MyImageLoader();
        }
        return instance;
    }

    public void initConfig(ImageLoaderConfig config){
        this.loaderConfig=config;
        if(loaderConfig!=null){
            imageCache= loaderConfig.imageCache;
            threadCount=loaderConfig.threadCount;
            defaultImageId=loaderConfig.defaultImageId;
        }

    }


    ExecutorService executorService = Executors.newFixedThreadPool(threadCount);//线程池


    public void setImageCache(IImageCache cache) {
        imageCache = cache;
    }

    public void disPlayImage(String url, ImageView imageView) {
        imageView.setImageResource(defaultImageId);
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
