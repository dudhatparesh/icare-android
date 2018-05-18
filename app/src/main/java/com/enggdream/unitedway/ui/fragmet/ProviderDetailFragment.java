package com.enggdream.unitedway.ui.fragmet;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.enggdream.unitedway.R;
import com.enggdream.unitedway.modal.Constant;
import com.enggdream.unitedway.modal.Provider;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class ProviderDetailFragment extends Fragment {

    View view;
    @BindView(R.id.tv_customer_name)
    public TextView tvCustomerName;
    @BindView(R.id.tv_mo_number)
    public TextView tvMoNumber;
    @BindView(R.id.tv_customer_address)
    public TextView tvCustomerAddress;
    @BindView(R.id.tv_description)
    public TextView tvDescription;
    @BindView(R.id.sp_status)
    public Spinner spStatus;
    @BindView(R.id.tv_request_number)
    public TextView tvRequestNumber;
    @BindView(R.id.tv_request_type)
    public TextView tvRequestType;

    Bundle bundle;
    Provider provider;
    private Context context;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_provider_detail, container, false);
            ButterKnife.bind(this, view);
            bundle = getArguments();

            String[] item = new String[]{"Pending", "Completed", "InProgress"};
            ArrayAdapter<String> adapter = new ArrayAdapter<>(context, R.layout.support_simple_spinner_dropdown_item, item);
            spStatus.setAdapter(adapter);
            provider = bundle.getParcelable(Constant.Key.PROVIDER_HOME);
            assert provider != null;
            tvRequestNumber.setText(provider.getRequestNumber());
            tvRequestType.setText(provider.getRequestType());
            tvCustomerName.setText(provider.getCustomerName());
            tvMoNumber.setText(provider.getCustomerMoNumber());
            tvCustomerAddress.setText(provider.getCustomerAddress());
            tvDescription.setText(provider.getDescription());
        }
        return view;
    }

    @OnClick(R.id.btn_update)
    public void updateOnClick() {
        Toast.makeText(getContext(), "Update", Toast.LENGTH_SHORT).show();
        getActivity().getSupportFragmentManager().popBackStack();
    }

    @OnClick(R.id.btn_direction)
    public void onClickDirection() {
        Uri gmmIntentUri = Uri.parse("geo:22.327334, 73.160462?q=" +
                Uri.encode("United Way of Baroda"));
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(context.getPackageManager()) != null) {
            startActivity(mapIntent);
        }else{
            Toast.makeText(context,R.string.can_not_find_google_map_installed,Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onDetach() {
        this.context = null;
        super.onDetach();
    }
}
