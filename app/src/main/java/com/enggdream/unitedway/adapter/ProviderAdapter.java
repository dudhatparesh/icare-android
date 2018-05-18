package com.enggdream.unitedway.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.enggdream.unitedway.R;
import com.enggdream.unitedway.interfaces.ProviderOnClickListener;
import com.enggdream.unitedway.modal.Provider;
import com.enggdream.unitedway.viewHolder.ProviderViewHolder;

import java.util.List;

public class ProviderAdapter extends RecyclerView.Adapter<ProviderViewHolder> {

    private ProviderOnClickListener onClickListener;
    private List<Provider> providers;
    private Context context;

    public ProviderAdapter(ProviderOnClickListener onClickListener, List<Provider> providers,Context context) {
        this.onClickListener = onClickListener;
        this.providers = providers;
        this.context = context;
    }

    @NonNull
    @Override
    public ProviderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_holder_provider,parent,false);
        return new ProviderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProviderViewHolder holder, int position) {
        final Provider provider = providers.get(position);
        holder.tvCustomerName.setText(provider.getCustomerName());
        holder.tvCustomerMoNumber.setText(provider.getCustomerMoNumber());
        holder.tvCustomerAddress.setText(provider.getCustomerAddress());
        holder.tvRequestNumber.setText(provider.getRequestNumber());
        holder.tvRequestType.setText(provider.getRequestType());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickListener.providerOnClick(provider);
            }
        });

    }

    @Override
    public int getItemCount() {
        return providers.size();
    }
}
