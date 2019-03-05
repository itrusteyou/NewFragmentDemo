package com.example.laowa.newfragmentdemo.FragmentMain;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;

import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.laowa.newfragmentdemo.R;
import com.example.laowa.newfragmentdemo.adapter.FragmentAdapter;
import com.example.laowa.newfragmentdemo.adapter.ListFragment_my_major;
import com.example.laowa.newfragmentdemo.adapter.ListFragment_not_my_major;
import com.example.laowa.newfragmentdemo.pic_roll.ImageCarousel;
import com.example.laowa.newfragmentdemo.pic_roll.ImageInfo;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import com.example.laowa.newfragmentdemo.activity.SearchActivity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by laowa on 2019/01/12.
 * 第二个页面，我的好友页面
 */
public class MyFragment_friend extends Fragment implements View.OnClickListener {



    public MyFragment_friend() {
    }


    // 图片轮播控件
    private ViewPager mViewPager;
    private TextView mTvPagerTitle;
    private LinearLayout mLineLayoutDot;
    private ImageCarousel imageCarousel;
    private List<View> dots;//小点pagerImageOnClick
    private String TAG = "Mainactivity";
    //recyclerview用
    private ViewPager mViewPager_friend;
    private TabLayout mTabLayout;



    // 图片数据，包括图片标题、图片链接、数据、点击要打开的网站（点击打开的网页或一些提示指令）
    private List<ImageInfo> imageInfoList;

    SimpleDraweeView simpleDraweeView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_friends, container, false);
//搜索开源项目点击
        TextView tv = view.findViewById(R.id.tv_search_bg);
        tv.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), SearchActivity.class);
                startActivity(intent);
            }
        });

//====================================================

//轮播图片

        initView(view);
        initEvent();
        imageStart(view);

        mTabLayout = view.findViewById(R.id.tabs_friend);
        //setSupportActionBar(toolbar);
        mViewPager_friend =  view.findViewById(R.id.viewPager_friend);
        initViewPager(view);

        return view;
    }

    @Override
    public void onClick(View v) {
        Log.i(TAG, "onClick: 点击了第"+v.getId()+"张");
        switch (v.getId()) {
            case R.id.pager_image1:
                Toast.makeText(getContext(), "图片1被点击", Toast.LENGTH_SHORT).show();
                break;
            case R.id.pager_image2:
                Toast.makeText(getContext(), "图片2被点击", Toast.LENGTH_SHORT).show();
                break;
            case R.id.pager_image3:
                Toast.makeText(getContext(), "图片3被点击", Toast.LENGTH_SHORT).show();
                break;
            case R.id.pager_image4:
                Toast.makeText(getContext(), "图片4被点击", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    /**
     * 用于展示图片初始化事件
     */
    private void initEvent() {
        imageInfoList = new ArrayList<>();
        imageInfoList.add(new ImageInfo(1, "图片1", "",
                "http://www.51pptmoban.com/d/file/2014/01/23/f03220aa5cc066bea0d4d2d355365f18.jpg",
                "http://www.baidu.com"));
        imageInfoList.add(new ImageInfo(1, "图片2", "",
                "http://t2.hddhhn.com/uploads/tu/201610/198/1oei3krh4ix.jpg",
                "http://www.baidu.com"));
        imageInfoList.add(new ImageInfo(1, "图片3", "",
                "http://e.hiphotos.baidu.com/image/pic/item/6a600c338744ebf85ed0ab2bd4f9d72a6059a705.jpg",
                "http://www.baidu.com"));
        imageInfoList.add(new ImageInfo(1, "图片4", "仅展示",
                "http://b.hiphotos.baidu.com/image/h%3D300/sign=8ad802f3801001e9513c120f880e7b06/a71ea8d3fd1f4134be1e4e64281f95cad1c85efa.jpg",
                "http://www.baidu.com"));
        //  imageInfoList.add(new ImageInfo(1, "图片5，公告5啦啦啦啦，陆欢博客", "仅展示", "http://e.hiphotos.baidu.com/image/h%3D300/sign=73443062281f95cab9f594b6f9177fc5/72f082025aafa40fafb5fbc1a664034f78f019be.jpg", ""));

    }

    /**
     * 初始化控件
     */
    private void initView(View view) {

        mViewPager = view.findViewById(R.id.viewPager);
        mTvPagerTitle = view.findViewById(R.id.tv_pager_title);
        mLineLayoutDot = view.findViewById(R.id.lineLayout_dot);

    }

    private void imageStart(View view) {
        //设置图片轮播
        int[] imgaeIds = new int[]{R.id.pager_image1, R.id.pager_image2, R.id.pager_image3, R.id.pager_image4,
                R.id.pager_image5, R.id.pager_image6, R.id.pager_image7, R.id.pager_image8};
        String[] titles = new String[imageInfoList.size()];
        List<SimpleDraweeView> simpleDraweeViewList = new ArrayList<>();
        for (int i = 0; i < imageInfoList.size(); i++) {
            titles[i] = imageInfoList.get(i).getTitle();
            Fresco.initialize(getContext());
           simpleDraweeView = new SimpleDraweeView(getContext());
            simpleDraweeView.setAspectRatio(1.78f);
            // 设置一张默认的图片
            GenericDraweeHierarchy hierarchy = new GenericDraweeHierarchyBuilder(this.getResources())
                    .setPlaceholderImage(ContextCompat.getDrawable(getContext(), R.mipmap.pic_roll_defult), ScalingUtils.ScaleType.CENTER_CROP).build();
            simpleDraweeView.setHierarchy(hierarchy);
            simpleDraweeView.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.WRAP_CONTENT));

            //加载高分辨率图片;
            ImageRequest imageRequest = ImageRequestBuilder.newBuilderWithSource(Uri.parse(imageInfoList.get(i).getImage()))
                    .setResizeOptions(new ResizeOptions(1280, 720))
                    .build();
            PipelineDraweeController controller = (PipelineDraweeController) Fresco.newDraweeControllerBuilder()
                    //.setLowResImageRequest(ImageRequest.fromUri(Uri.parse(listItemBean.test_pic_low))) //在加载高分辨率图片之前加载低分辨率图片
                    .setImageRequest(imageRequest)
                    .setOldController(simpleDraweeView.getController())
                    .build();
            simpleDraweeView.setController(controller);

            simpleDraweeView.setId(imgaeIds[i]);//给view设置id
            simpleDraweeView.setTag(imageInfoList.get(i));
            simpleDraweeView.setOnClickListener(this);
            titles[i] = imageInfoList.get(i).getTitle();
            simpleDraweeViewList.add(simpleDraweeView);

        }

        dots = addDots(view, mLineLayoutDot, fromResToDrawable(getContext(), R.drawable.ic_dot_focused), simpleDraweeViewList.size());
        imageCarousel = new ImageCarousel(getContext(), mViewPager, mTvPagerTitle, dots, 5000);
        imageCarousel.init(simpleDraweeViewList, titles)
                .startAutoPlay();
        imageCarousel.start();

    }

    /**
     * 动态添加一个点
     *
     * @param linearLayout 添加到LinearLayout布局
     * @param backgount    设置
     * @return 小点的Id
     */
    private int addDot(final LinearLayout linearLayout, Drawable backgount) {
        final View dot = new View(getContext());
        LinearLayout.LayoutParams dotParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        dotParams.width = 16;
        dotParams.height = 16;
        dotParams.setMargins(4, 0, 4, 0);
        dot.setLayoutParams(dotParams);
        dot.setBackground(backgount);
        dot.setId(View.generateViewId());
        (getActivity()).runOnUiThread(new Runnable() {
            @Override
            public void run() {
                linearLayout.addView(dot);
            }
        });

        return dot.getId();
    }


    /**
     * 资源图片转Drawable
     *
     * @param context 上下文
     * @param resId   资源ID
     * @return 返回Drawable图像
     */
    public static Drawable fromResToDrawable(Context context, int resId) {
        return ContextCompat.getDrawable(context, resId);
        //return context.getResources().getDrawable(resId);
    }

    /**
     * 添加多个轮播小点到横向线性布局
     *
     * @param linearLayout 线性横向布局
     * @param backgount    小点资源图标
     * @param number       数量
     * @return 返回小点View集合
     */
    private List<View> addDots(View view,final LinearLayout linearLayout, Drawable backgount, int number) {
        List<View> dots = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            int dotId = addDot(linearLayout, backgount);
            dots.add(view.findViewById(dotId));

        }
        return dots;
    }

    //我的朋友页面上部fragment
    private void initViewPager(View view) {

        List<String> titles = new ArrayList<>();
        titles.add("本专业的");
        titles.add("非本专业的");


        for (int i = 0; i < titles.size(); i++) {
            mTabLayout.addTab(mTabLayout.newTab().setText(titles.get(i)));
            //       Log.i(TAG, "消息页面顶部两个fragment=: " + i);
        }
        List<Fragment> fragments = new ArrayList<>();
        for (int i = 0; i < titles.size(); i++) {
            if (i == 0) {
                fragments.add(new ListFragment_my_major());
            } else {
                fragments.add(new ListFragment_not_my_major());
            }
        }
        FragmentAdapter mFragmentAdapteradapter =
                new FragmentAdapter(getFragmentManager(), fragments, titles);
        //给ViewPager设置适配器
        mViewPager_friend.setAdapter(mFragmentAdapteradapter);
        //将TabLayout和ViewPager关联起来。
        mTabLayout.setupWithViewPager(mViewPager_friend);
        //给TabLayout设置适配器
        mTabLayout.setTabsFromPagerAdapter(mFragmentAdapteradapter);
    }

}
