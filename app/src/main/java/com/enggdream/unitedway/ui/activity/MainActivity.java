package com.enggdream.unitedway.ui.activity;


import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.enggdream.unitedway.R;
import com.enggdream.unitedway.modal.Constant;
import com.enggdream.unitedway.ui.fragmet.CreateRequestFragment;
import com.enggdream.unitedway.ui.fragmet.CurrentDetailFragment;
import com.enggdream.unitedway.ui.fragmet.CurrentRequestFragment;
import com.enggdream.unitedway.ui.fragmet.PastRequestFragment;
import com.enggdream.unitedway.ui.fragmet.ProviderDetailFragment;
import com.enggdream.unitedway.ui.fragmet.ProviderFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.app_bar)
    Toolbar toolbar;
    String userType;


    public static final int FRAGMENT_USER_HOME = 0;
    public static final int FRAGMENT_PAST_REQUEST = 1;
    public static final int FRAGMENT_CREATE_REQUEST = 2;
    public static final int FRAGMENT_CURRENT_DETAIL = 3;
    public static final int FRAGMENT_PAST_DETAIL = 4;
    public static final int FRAGMENT_PROVIDER_HOME = 5;
    public static final int FRAGMENT_PROVIDER_DETAIL = 6;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        userType = getIntent().getStringExtra(Constant.Key.MOBILE_NUMBER);
        setSupportActionBar(toolbar);
        if (userType.startsWith("1")){
            displayFragment(FRAGMENT_PROVIDER_HOME, null, false);
        }else{
            displayFragment(FRAGMENT_USER_HOME,null,false);
        }
    }

    public void displayFragment(int fragmentId, Bundle bundle, boolean addToBackStack) {
        Fragment fragment = null;
        switch (fragmentId) {
            case FRAGMENT_USER_HOME:
                fragment = new CurrentRequestFragment();
                break;
            case FRAGMENT_PAST_REQUEST:
                fragment = new PastRequestFragment();
                break;
            case FRAGMENT_CREATE_REQUEST:
                fragment = new CreateRequestFragment();
                break;
            case FRAGMENT_CURRENT_DETAIL:
                fragment = new CurrentDetailFragment();
                break;
            case FRAGMENT_PROVIDER_HOME:
                fragment = new ProviderFragment();
                break;
            case FRAGMENT_PROVIDER_DETAIL:
                fragment = new ProviderDetailFragment();
                break;
            default:
        }
        assert fragment != null;
        fragment.setArguments(bundle);
        FragmentManager manager = this.getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fl_container, fragment, "");
        if (addToBackStack) {
            transaction.addToBackStack("");
        }
        transaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_about_us:
                Dialog dialog = new Dialog(this);
                dialog.setTitle(R.string.app_name);
                dialog.setTitle(R.string.app_version);
                dialog.setContentView(R.layout.about_us_dialog);
                TextView aboutUsText = dialog.findViewById(R.id.tv_about_us);
                aboutUsText.setText(R.string.about_us_text);
                dialog.show();
                return true;
            case R.id.action_log_out:
                finish();
                startActivity(new Intent(this, LoginActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
