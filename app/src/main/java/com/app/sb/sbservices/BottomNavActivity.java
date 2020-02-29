package com.app.sb.sbservices;
import android.content.DialogInterface;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.app.sb.sbservices.Menu.BlankFragment;
import com.app.sb.sbservices.Orders.OrdersMainFragment;

import com.app.sb.sbservices.Profile.ProfileFragment;

public class BottomNavActivity extends AppCompatActivity {
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = item -> {
        Fragment fragment = null;
        switch (item.getItemId()) {
            case R.id.home:
              fragment = new HomeFragment();
                break;
            case R.id.myOrders:
                fragment=new OrdersMainFragment();
                break;

            case R.id.action_cart:
                fragment=new EarnCreditsFragment();
                break;

            case R.id.profile:
                fragment=new ProfileFragment();
                break;
            case R.id.menu:
                fragment=new BlankFragment();
                break;

        }
        return loadFragment(fragment);
    };


    private static final int GRANT_LOC_ACCESS = 124;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_nav);
        // Call the function callInstamojo to start payment here
        BottomNavigationView navigation = findViewById(R.id.navigation);

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        loadFragment(new HomeFragment());
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        BottomNavActivity.this.finish();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }
}
