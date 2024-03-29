package iss.workshop.adproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import iss.workshop.adproject.Adapters.MyHomeAdapter;

public class HomeActivity extends AppCompatActivity {//viewPager也需要适配器，这里用的是homeAdapter
    ViewPager2 viewPager2;
    TabLayout tabLayout;

    private ImageView homeImage, searchImage, historyImage, uploadImage ,imageViewCurrent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        viewPager2 = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tab_layout);
        initViewpager2(viewPager2);
        initImages();
    }

    public void initViewpager2(ViewPager2 viewPager2){
        MyHomeAdapter myHomeAdapter = new MyHomeAdapter(getSupportFragmentManager(),getLifecycle());

        List<Fragment>fragments = new ArrayList<>();
        myHomeAdapter.setFragments(fragments);
        fragments.add(new ItemFragment());
        fragments.add(new BlankFragment2());
        fragments.add(new BlankFragment3());
        fragments.add(new BlankFragment4());
        viewPager2.setAdapter(myHomeAdapter);

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                changePager(position);//通过这个方法来使得图片跟随页面一起变化
            }
        });//监听页面变化的消息，当页面变化时传递当前页面的位置，也就是当前页面对应的fragment在集合中的索引
    }

    public void initImages(){
        homeImage = findViewById(R.id.homeImage);
        searchImage = findViewById(R.id.searchImage);
        historyImage = findViewById(R.id.historyImage);
        uploadImage = findViewById(R.id.uploadImage);

        imageViewCurrent = homeImage;
        imageViewCurrent.setSelected(true);
    }

    public void changeClick(View view){
        imageViewCurrent.setSelected(false);//如果当前是在第二个，点击第三个的话，就让第二个为false，第三个为true
        if (view.getId()==R.id.homeImage){
            viewPager2.setCurrentItem(0,true);//使得页面切换具有平滑效果
            imageViewCurrent = homeImage;
            imageViewCurrent.setSelected(true);
        } else if (view.getId()==R.id.historyImage) {
            viewPager2.setCurrentItem(2,true);
            imageViewCurrent = historyImage;
            imageViewCurrent.setSelected(true);
        } else if (view.getId()==R.id.searchImage) {
            viewPager2.setCurrentItem(1,true);
            imageViewCurrent = searchImage;
            imageViewCurrent.setSelected(true);
        }else if (view.getId()==R.id.uploadImage){
            viewPager2.setCurrentItem(3,true);
            imageViewCurrent = uploadImage;
            imageViewCurrent.setSelected(true);
        }
    }

    public void changePager(int position){
        if (position==0){
            imageViewCurrent.setSelected(false);
            imageViewCurrent = homeImage;
            imageViewCurrent.setSelected(true);
        } else if (position==1) {
            imageViewCurrent.setSelected(false);
            imageViewCurrent = searchImage;
            imageViewCurrent.setSelected(true);
        } else if (position==2) {
            imageViewCurrent.setSelected(false);
            imageViewCurrent = historyImage;
            imageViewCurrent.setSelected(true);
        }else if (position==3){
            imageViewCurrent.setSelected(false);
            imageViewCurrent = uploadImage;
            imageViewCurrent.setSelected(true);
        }
    }
}