package com.example.collegeapp.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.collegeapp.R;

import java.util.ArrayList;


public class homeFragment extends Fragment {


    private ImageSlider imageSlider;
    private ImageView map;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        imageSlider = view.findViewById(R.id.image_slider);

        ArrayList<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel("https://www.wctmgurgaon.com/gallery-img/photo05071.png", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://www.wctmgurgaon.com/gallery-img/photo05073.png", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://www.wctmgurgaon.com/gallery-img/pan-india-ranking.jpeg", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://www.wctmgurgaon.com/gallery-img/ncw/1.jpeg", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://www.wctmgurgaon.com/gallery-img/photo05071.png", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://www.wctmgurgaon.com/gallery-img/farewell-2022/11.jpeg", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://scontent-del1-2.xx.fbcdn.net/v/t39.30808-6/366941498_674297161394880_5810633643675841240_n.jpg?stp=dst-jpg_p206x206&_nc_cat=100&ccb=1-7&_nc_sid=da31f3&_nc_ohc=yUZFPQ_Xq7gAX-yYuQM&_nc_ht=scontent-del1-2.xx&oh=00_AfALdp3KtlQ_gpfNR_zL2gWz8izC0m_Ied5T5D48dsv54g&oe=64EFD635", ScaleTypes.FIT));

        imageSlider.setImageList(slideModels, ScaleTypes.FIT);

        map=view.findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMap();
            }
        });

        return view;
    }

    private void openMap() {
        Uri uri=Uri.parse("geo:0,0?q=WCTM College Of Management And Technology Gurgaon Haryana");
        Intent intent=new Intent(Intent.ACTION_VIEW,uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }


}