package com.enggdream.unitedway.ui.fragmet;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.enggdream.unitedway.R;
import com.enggdream.unitedway.modal.Constant;
import com.enggdream.unitedway.modal.Request;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CurrentDetailFragment extends Fragment {

    View view;
    @BindView(R.id.tv_req_no)
    public TextView reqNumber;
    @BindView(R.id.tv_req_status)
    public TextView reqStatus;
    @BindView(R.id.tv_req_type)
    public TextView reqType;
    @BindView(R.id.tv_created_on)
    public TextView createdOn;
    @BindView(R.id.tv_assigned_to)
    public TextView assignedTo;
    Bundle bundle;
    Request request;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_current_detail, container, false);
            ButterKnife.bind(this, view);
            bundle = getArguments();
            request = bundle.getParcelable(Constant.Key.BASE_KEY);
            reqNumber.setText(String.valueOf(request.getRequestNumber()));
            reqStatus.setText(request.getReqStatus());
            reqType.setText(request.getReqType());
            createdOn.setText(request.getCreatedOn());
            assignedTo.setText(request.getAssignedTo());

        }
        return view;
    }
}
