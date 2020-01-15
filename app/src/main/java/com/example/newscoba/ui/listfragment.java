package com.example.newscoba.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newscoba.R;
import com.example.newscoba.adapterlist.adapter;
import com.example.newscoba.model.beritakonten;
import com.example.newscoba.repo.reponews;
import com.example.newscoba.viewmodel.NewsModel;



import java.util.ArrayList;
import java.util.List;

public class listfragment extends Fragment {

    View view;
    String category = "technology";
    NewsModel viewModel;
    RecyclerView rc_list;
    adapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.list_news_fragment, container, false);
        this.getPassedData();
        this.initComponent();
        this.initList();
        return view;
    }
    public void getPassedData(){
        Bundle bundle = this.getArguments();
        try {
            category = bundle.getString("category");
        }catch (NullPointerException ex){

        }

    }
    public void initComponent(){
        rc_list = view.findViewById(R.id.rc_list);
        // Assign View Model from beritakonten View Model
        viewModel = ViewModelProviders.of(this).get(NewsModel.class);
        ((NewsModel) viewModel).init(new reponews());
        //instantiate news adapter
        adapter = new adapter(getContext(),new ArrayList<beritakonten>());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL,
                false);
        rc_list.setLayoutManager(layoutManager);
        rc_list.setAdapter(adapter);
    }

    public void initList(){
        // put observer when news data is downloaded
        viewModel.getNewsByCategory(this.category).observe(getViewLifecycleOwner(), new Observer<List<beritakonten>>() {
            @Override
            public void onChanged(List<beritakonten> beritakontens) {
                adapter.setData(beritakontens);
                adapter.notifyDataSetChanged();
            }
        });
    }
}
