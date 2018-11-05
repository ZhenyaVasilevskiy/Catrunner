package com.example.user.catrunner;

import android.arch.lifecycle.ViewModelProviders;
import android.arch.lifecycle.Observer;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton;

import com.example.user.catrunner.databinding.ActivityMainBinding;

import fragments.HistoryFragment;
import fragments.HomeFragment;
import fragments.InfoFragment;
import fragments.ProfileFragment;
import fragments.SettingsFragment;
import viewModels.ProfileFragmentViewModel;

public class MainActivity extends AppCompatActivity {

    private MainViewModel mainViewModel;

    public ImageButton btnHome;
    public ImageButton btnProfile;
    public ImageButton btnHistory;
    public ImageButton btnSettings;
    public ImageButton btnInfo;
    public HomeFragment homeFragment;
    public HistoryFragment historyFragment;
    public FragmentTransaction fragmentTransaction;
    public ProfileFragment profileFragment;
    public SettingsFragment settingsFragment;
    public InfoFragment infoFragment;

    private ProfileFragmentViewModel profileFragmentViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnHistory = findViewById(R.id.btn_history);
        btnHome = findViewById(R.id.btn_home);
        btnProfile = findViewById(R.id.btn_profile);
        btnSettings = findViewById(R.id.btn_settings);
        btnInfo = findViewById(R.id.btn_info);
        homeFragment = new HomeFragment();
        historyFragment = new HistoryFragment();
        profileFragment = new ProfileFragment();
        settingsFragment = new SettingsFragment();
        infoFragment = new InfoFragment();
        profileFragmentViewModel = ViewModelProviders.of(this).get(ProfileFragmentViewModel.class);

        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.frgmCont, homeFragment);
        btnHome.setImageDrawable(getResources().getDrawable(R.drawable.ic_home_25dp_selected));
        fragmentTransaction.commit();

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        binding.setViewModel(mainViewModel);
        mainViewModel.getCurrentFragment().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {
                onChangeFragment();
            }
        });
    }

    public ProfileFragmentViewModel getProfileFragmentViewModel() {
        return profileFragmentViewModel;
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        onChangeFragment();
    }

    private void onChangeFragment() {
        int currentFragment = mainViewModel.getCurrentFragment().getValue();
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        switch (currentFragment) {
            case 1:
                btnHome.setImageDrawable(getResources().getDrawable(R.drawable.ic_home_25dp));
                fragmentTransaction.replace(R.id.frgmCont, profileFragment);
                setTitle(getResources().getString(R.string.title_profile));
                break;
            case 2:
                btnHome.setImageDrawable(getResources().getDrawable(R.drawable.ic_home_25dp));
                fragmentTransaction.replace(R.id.frgmCont, historyFragment);
                setTitle(getResources().getString(R.string.title_history));
                break;
            case 3:
                fragmentTransaction.replace(R.id.frgmCont, homeFragment);
                btnHome.setImageDrawable(getResources().getDrawable(R.drawable.ic_home_25dp_selected));
                setTitle(getResources().getString(R.string.app_name));
                break;
            case 4:
                btnHome.setImageDrawable(getResources().getDrawable(R.drawable.ic_home_25dp));
                fragmentTransaction.replace(R.id.frgmCont, settingsFragment);
                setTitle(getResources().getString(R.string.title_settings));
                break;
            case 5:
                btnHome.setImageDrawable(getResources().getDrawable(R.drawable.ic_home_25dp));
                fragmentTransaction.replace(R.id.frgmCont, infoFragment);
                setTitle(getResources().getString(R.string.title_info));
                break;
        }
//        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}