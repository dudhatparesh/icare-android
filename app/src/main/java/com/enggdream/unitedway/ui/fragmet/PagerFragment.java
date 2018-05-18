package com.enggdream.unitedway.ui.fragmet;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.enggdream.unitedway.R;
import com.enggdream.unitedway.adapter.PageAdapter;

import butterknife.BindView;

public class PagerFragment extends Fragment {

    View view;
    @BindView(R.id.viewPager)
    public ViewPager viewPager;
    @BindView(R.id.tabLayout)
    public TabLayout tabLayout;
    @BindView(R.id.toolbar)
    public Toolbar toolbar;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null){
            view = inflater.inflate(R.layout.fragment_pager,container,false);
            PageAdapter pageAdapter = new PageAdapter(getChildFragmentManager());
            viewPager.setAdapter(pageAdapter);
            tabLayout.setupWithViewPager(viewPager);
        }
        return view;
    }
}
