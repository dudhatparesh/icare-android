package com.enggdream.unitedway.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.enggdream.unitedway.R;
import com.enggdream.unitedway.interfaces.BaseOnClickListener;
import com.enggdream.unitedway.modal.Request;
import com.enggdream.unitedway.viewHolder.BaseViewHolder;

import java.util.List;

public class BaseRequestAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private BaseOnClickListener onClickListener;
    private List<Request> requests;
    private Context context;

    public BaseRequestAdapter(BaseOnClickListener onClickListener, List<Request> request, Context context) {
        this.onClickListener = onClickListener;
        this.requests = request;
        this.context = context;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_holder_base, parent, false);
        return new BaseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        final Request request = requests.get(position);
        holder.tvReqNumber.setText(String.valueOf(request.getRequestNumber()));
        holder.tvReqType.setText(request.getReqType());
        holder.tvReqStatus.setText(request.getReqStatus());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickListener.baseOnClick(request);
            }
        });
    }

    @Override
    public int getItemCount() {
        return requests.size();
    }
}
