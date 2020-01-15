package com.example.newscoba.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.newscoba.R;


public class fragment1 extends Fragment implements View.OnClickListener {

    View view;
    CardView technology_panel;
    CardView business_panel;
    CardView health_panel;
    CardView entertainment_panel;
    CardView scince_panel;
    CardView sport_panel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.fregmen_1, container, false);
        initComponent();
        return view;
    }
    public void initComponent(){
        technology_panel = this.view.findViewById(R.id.categ_technology);
        business_panel = this.view.findViewById(R.id.categ_business);
        health_panel = this.view.findViewById(R.id.categ_health);
        entertainment_panel = this.view.findViewById(R.id.categ_entertainment);
        scince_panel = this.view.findViewById(R.id.categ_scince);
        sport_panel = this.view.findViewById(R.id.categ_sport);
        technology_panel.setOnClickListener(this);
        business_panel.setOnClickListener(this);
        health_panel.setOnClickListener(this);
        entertainment_panel.setOnClickListener(this);
        scince_panel.setOnClickListener(this);
        sport_panel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.categ_technology:
                Bundle category_tech = new Bundle();
                category_tech.putString("category","technology");
                Navigation.findNavController(v).navigate(R.id.action_homeFragment_to_listNewsFragment,category_tech);
                break;
            case R.id.categ_business:
                Bundle category_business = new Bundle();
                category_business.putString("category","business");
                Navigation.findNavController(v).navigate(R.id.action_homeFragment_to_listNewsFragment,category_business);
                break;
                case R.id.categ_health:
                Bundle catagory_health = new Bundle();
                catagory_health.putString("category","health");
                Navigation.findNavController(v).navigate(R.id.action_homeFragment_to_listNewsFragment,catagory_health);
                break;
            case R.id.categ_entertainment:
                Bundle catagory_entertainment = new Bundle();
                catagory_entertainment.putString("category","entertainment");
                Navigation.findNavController(v).navigate(R.id.action_homeFragment_to_listNewsFragment,catagory_entertainment);
                break;
            case R.id.categ_scince:
                Bundle catagory_scince = new Bundle();
                catagory_scince.putString("category","science");
                Navigation.findNavController(v).navigate(R.id.action_homeFragment_to_listNewsFragment,catagory_scince);
                break;
            case R.id.categ_sport:
                Bundle catagory_sport= new Bundle();
                catagory_sport.putString("category","sport");
                Navigation.findNavController(v).navigate(R.id.action_homeFragment_to_listNewsFragment,catagory_sport);
                break;

        }
    }
}
