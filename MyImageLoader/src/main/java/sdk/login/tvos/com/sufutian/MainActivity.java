package sdk.login.tvos.com.sufutian;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.leakcanary.RefWatcher;

import java.util.ArrayList;

import 容器式单列.SingleDemoManager;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> urls;
    private MyImageLoader myImageLoader;
    private MyImageLoader2 loader2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         * 内存泄漏检测
         */
        RefWatcher refWatcher=MyApplication.getRefWatcher(this);
        refWatcher.watch(this);

        /**
         * 容器单列测试
         */
        SingleDemoManager.registerService("ImageLoader",new MyImageLoader2());
        loader2 = (MyImageLoader2) SingleDemoManager.getSystemServcie("ImageLoader");
        loader2.setImageCache(new MemoryCache());


        /**
         * imageloader第一次构建  单一职责  依赖倒置  开闭原则
         */
        myImageLoader = MyImageLoader.getInstance();
        myImageLoader.setImageCache(new DoubleCache()); /**依赖注入*/


        /**
         * Imageloader 第二次构建 builde模式
         */

        ImageLoaderConfig config=new ImageLoaderConfig.Builder()
                .setDefaultImage(R.drawable.leak_canary_icon)
                .setImageCache(new MemoryCache())
                .setThreadCount(4)
                .create();
        MyImageLoader.getInstance().initConfig(config);



       /* myImageLoader.setImageCache(new IImageCache() {//对外扩展
            @Override
            public void putBitmap(String urlkey, Bitmap bitmap) {
                Log.i("sufutian", "putBitmap: "+"其他");
            }

            @Override
            public Bitmap getBitmap(String urlKey) {
                Log.i("sufutian", "getBitmap: "+"其他");
                return null;
            }
        });*/










        urls = new ArrayList<>();
        for(int i=0;i<=50;i++){
            urls.add("http://file6.audiocn.org/web/images/leibo/7.jpg");
            urls.add("http://file6.audiocn.org/web/images/leibo/26.jpg");
            urls.add("http://fxcdn9.audiocn.com/upload_files/images/360_270/20160913/0e8f573e-f199-43f6-9dc3-06185588abf6.jpg");
        }

        RecyclerView recyclerView= (RecyclerView) findViewById(R.id.recycleView);
        //布局管理器
        GridLayoutManager layoutManager=new GridLayoutManager(this,2, LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        //设置adapter
        recyclerView.setAdapter(new MyRecycleAdapter());


    }

    private class MyRecycleAdapter extends RecyclerView.Adapter<MyViewHolder>{

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            MyViewHolder myViewHolder=new MyViewHolder(View.inflate(MainActivity.this,R.layout.item_recycle,null));

            return myViewHolder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {

            //myImageLoader.disPlayImage(urls.get(position),holder.imageView);

            //loader2.disPlayImage(urls.get(position),holder.imageView);

            MyImageLoader.getInstance().disPlayImage(urls.get(position),holder.imageView);

        }

        @Override
        public int getItemCount() {
            return urls.size();
        }
    }

    private class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        public MyViewHolder(View itemView) {
            super(itemView);
            imageView= (ImageView) itemView.findViewById(R.id.card_view);
        }
    }
}
