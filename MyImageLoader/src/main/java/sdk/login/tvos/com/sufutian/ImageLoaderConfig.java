package sdk.login.tvos.com.sufutian;

/**
 * Created by sufutian on 2016/11/10/14:38.
 */

/**
 * builder模式
 */
public class ImageLoaderConfig {

    private ImageLoaderConfig() {};

    IImageCache imageCache = new MemoryCache();

    int threadCount = Runtime.getRuntime().availableProcessors();

    int defaultImageId;

    public static class Builder {

        IImageCache imageCache = new MemoryCache();

        int threadCount = Runtime.getRuntime().availableProcessors();

        int defaultImageId;

        public Builder setThreadCount(int count) {
            threadCount = count;
            return this;
        }

        public Builder setImageCache(IImageCache cache) {
            imageCache = cache;
            return this;
        }

        public Builder setDefaultImage(int id) {
            defaultImageId = id;
            return this;
        }


        /**
         * 创建
         * @return
         */
        public ImageLoaderConfig create(){
            ImageLoaderConfig loaderConfig=new ImageLoaderConfig();
            applyConfig(loaderConfig);
            return  loaderConfig;
        }

        /**
         * 配置
         * @param config
         */
        public void applyConfig(ImageLoaderConfig config) {
            config.imageCache = this.imageCache;
            config.threadCount = this.threadCount;
            config.defaultImageId = this.defaultImageId;
        }


    }



}
