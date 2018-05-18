package com.enggdream.unitedway.viewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.enggdream.unitedway.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BaseViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tv_req_no)
    public TextView tvReqNumber;
    @BindView(R.id.tv_req_status)
    public TextView tvReqStatus;
    @BindView(R.id.tv_req_type)
    public TextView tvReqType;

    public BaseViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
