package com.example.netflex;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class SliderPagerAdapter extends PagerAdapter {

    private Context mContext;
    private List<slide> mList;

    public SliderPagerAdapter(Context mContext, List<slide> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View sliderLayout = inflater.inflate(R.layout.slide_item, null);

        ImageView slideImg = sliderLayout.findViewById(R.id.slide_img);
        TextView slideText = sliderLayout.findViewById(R.id.slide_title);
        slideImg.setImageResource(mList.get(position).getImage());
        slideText.setText(mList.get(position).getTitle());

        container.addView(sliderLayout);
        return sliderLayout;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
