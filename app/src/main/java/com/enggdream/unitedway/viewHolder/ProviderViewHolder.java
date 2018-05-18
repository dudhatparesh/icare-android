package com.enggdream.unitedway.viewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.enggdream.unitedway.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProviderViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tv_request_no)
    public TextView tvRequestNumber;
    @BindView(R.id.tv_request_type)
    public TextView tvRequestType;
    @BindView(R.id.tv_customer_name)
    public TextView tvCustomerName;
    @BindView(R.id.tv_mo_number)
    public TextView tvCustomerMoNumber;
    @BindView(R.id.tv_customer_address)
    public TextView tvCustomerAddress;

    public ProviderViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
