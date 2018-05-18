package com.enggdream.unitedway.ui.fragmet;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.enggdream.unitedway.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.enggdream.unitedway.R.layout.support_simple_spinner_dropdown_item;

public class CreateRequestFragment extends Fragment {

    private View view;
    @BindView(R.id.sp_request)
    Spinner spRequest;
    @BindView(R.id.et_descriptions)
    EditText etDescription;
    @BindView(R.id.et_visited_date)
    EditText etVisitedDate;
    @BindView(R.id.et_visited_time)
    EditText etVisitedTime;

    private Context context;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_create_request, container, false);
            ButterKnife.bind(this, view);
            String[] item = new String[]{"Electricity Bill", "Water Bill", "House Rent"};
            ArrayAdapter<String> adapter = new ArrayAdapter<>(context, support_simple_spinner_dropdown_item, item);
            spRequest.setAdapter(adapter);
        }
        return view;
    }

    @OnClick(R.id.btn_back)
    public void onClickBack() {
        getActivity().getSupportFragmentManager().popBackStack();
    }

    @OnClick(R.id.btn_submit)
    public void onClickSubmit() {
        if (validateForm()) {
            Toast.makeText(getContext(), R.string.request_submited, Toast.LENGTH_SHORT).show();
            getActivity().getSupportFragmentManager().popBackStack();
        } else {
            Toast.makeText(getContext(), R.string.please_fill_all_the_details, Toast.LENGTH_SHORT).show();
        }
    }

    private boolean validateForm() {

        return !TextUtils.isEmpty(etDescription.getText().toString())
                && !TextUtils.isEmpty(etVisitedDate.getText().toString())
                && !TextUtils.isEmpty(etVisitedTime.getText().toString());
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.context = null;
    }
}
