package com.enggdream.unitedway.ui.fragmet;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.enggdream.unitedway.R;
import com.enggdream.unitedway.adapter.ProviderAdapter;
import com.enggdream.unitedway.interfaces.ProviderOnClickListener;
import com.enggdream.unitedway.modal.Constant;
import com.enggdream.unitedway.modal.Provider;
import com.enggdream.unitedway.ui.activity.MainActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProviderFragment extends Fragment {

    View view;
    @BindView(R.id.rv_provider)
    RecyclerView rvProvider;
    ProviderAdapter adapter;
    List<Provider> providers;

    ProviderOnClickListener onClickListener = new ProviderOnClickListener() {
        @Override
        public void providerOnClick(Provider provider) {
            Bundle bundle = new Bundle();
            bundle.putParcelable(Constant.Key.PROVIDER_HOME, provider);
            ((MainActivity) getActivity()).displayFragment(MainActivity.FRAGMENT_PROVIDER_DETAIL, bundle, true);
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_provider, container, false);
            ButterKnife.bind(this, view);
            rvProvider.setLayoutManager(new LinearLayoutManager(getContext()));
            loadProviderData();
            adapter = new ProviderAdapter(onClickListener, providers, getContext());
            rvProvider.setAdapter(adapter);
        }
        return view;
    }

    private void loadProviderData() {
        providers = new ArrayList<>();

        providers.add(new Provider("Paresh", "9876543210", "xyz","xyz","xyz","Paresh","ElectricBill"));
        providers.add(new Provider("Parth", "7894561230", "xyz","xyz","xyz","Karan","WaterBill"));
        providers.add(new Provider("Karan", "8974563210", "xyz","xyz","xyz","Arjun","ElectricBill"));
        providers.add(new Provider("Arjun", "9586743210", "xyz","xyz","xyz","Mahesh","HouseRant"));
        providers.add(new Provider("Rajesh", "8745896213", "xyz","xyz","xyz","Mohan","WaterBill"));
        providers.add(new Provider("Paras", "9856321470", "xyz","xyz","xyz","Tejash","HoseRant"));
        providers.add(new Provider("Chirag", "9874563258", "xyz","xyz","xyz","Paras","ElectricBill"));

    }
}
