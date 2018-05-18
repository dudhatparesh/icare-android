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
import com.enggdream.unitedway.adapter.BaseRequestAdapter;
import com.enggdream.unitedway.interfaces.BaseOnClickListener;
import com.enggdream.unitedway.modal.Constant;
import com.enggdream.unitedway.modal.Request;
import com.enggdream.unitedway.ui.activity.MainActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.enggdream.unitedway.ui.activity.MainActivity.FRAGMENT_CREATE_REQUEST;

public class CurrentRequestFragment extends Fragment {

    private View view;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    BaseRequestAdapter adapter;
    List<Request> requests;

    BaseOnClickListener onClickListener = new BaseOnClickListener() {
        @Override
        public void baseOnClick(Request request) {
            Bundle bundle = new Bundle();
            bundle.putParcelable(Constant.Key.BASE_KEY, request);
            ((MainActivity)getActivity()).displayFragment(MainActivity.FRAGMENT_CURRENT_DETAIL,bundle,true);
        }
    };


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_current_request, container, false);
            ButterKnife.bind(this, view);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            loadStaticData();
            adapter = new BaseRequestAdapter(onClickListener, requests,getContext());
            recyclerView.setAdapter(adapter);

        }
        return view;
    }

    private void loadStaticData() {
        requests = new ArrayList<>();
        requests.add(new Request(1,"Electric bill","Completed","14 jan","No"));
        requests.add(new Request(2,"Phone bill","Pending","18 jan","Yes"));
        requests.add(new Request(3,"Water bill","Completed","14 jan","Yes"));
        requests.add(new Request(4,"Electric bill","Pending","4 jan","No"));
        requests.add(new Request(5,"Phone bill","Completed","25 jan","Yes"));
        requests.add(new Request(6,"Water bill","Pending","14 jan","No"));
        requests.add(new Request(7,"Tax bill","Completed","22 jan","No"));
    }

    @OnClick(R.id.fab)
    public void onClick() {
        ((MainActivity) getActivity()).displayFragment(FRAGMENT_CREATE_REQUEST, null, true);
    }

}
