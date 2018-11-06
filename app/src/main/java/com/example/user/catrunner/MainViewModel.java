package com.example.user.catrunner;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.view.View;

import viewModels.HomeFragmentViewModel;
import viewModels.ProfileFragmentViewModel;

public class MainViewModel extends ViewModel {

    private MutableLiveData<Integer> mCurrentFragment;
    private MutableLiveData<ProfileFragmentViewModel> profileFragmentViewModel;
    private MutableLiveData<HomeFragmentViewModel> homeFragmentViewModelMutableLiveData;
    private MutableLiveData<Boolean> mMapOpened;

    public MutableLiveData<ProfileFragmentViewModel> getProfileFragmentViewModel() {
        return profileFragmentViewModel;
    }

    public void setProfileFragmentViewModel(MutableLiveData<ProfileFragmentViewModel> profileFragmentViewModel) {
        this.profileFragmentViewModel = profileFragmentViewModel;
    }

    public  void setMapOpened() {
//
    }

//    public MutableLiveData<Boolean> getMapOpened() {
//        if (homeFragmentViewModelMutableLiveData == null) {
//            mMapOpened = new MutableLiveData<>();
//            mMapOpened.setValue(false);
//            return mMapOpened;
//        }
//        return homeFragmentViewModelMutableLiveData.getValue().getMapOpened();
//    }

    public boolean MapOpened() {
        if (homeFragmentViewModelMutableLiveData == null) {
            mMapOpened = new MutableLiveData<>();
            mMapOpened.setValue(false);
            return mMapOpened.getValue();
        }
        return homeFragmentViewModelMutableLiveData.getValue().getMapOpened().getValue();
    }

    public void setFragmentNumber(View view) {
        int curFragment = 3;
        switch (view.getId()) {
            case R.id.btn_profile:
                curFragment = 1;
                break;
            case R.id.btn_history:
                curFragment = 2;
                break;
            case R.id.btn_home:
//                curFragment = 3;
                if (MapOpened()) {
                    curFragment = 3;
                } else {
                    curFragment = 6;
                }
                break;
            case R.id.btn_settings:
                curFragment = 4;
                break;
            case R.id.btn_info:
                curFragment = 5;
                break;
        }
        mCurrentFragment.setValue(curFragment);
    }

    public MutableLiveData<Integer> getCurrentFragment() {
        if (mCurrentFragment == null) {
            mCurrentFragment = new MutableLiveData<Integer>();
        }
        return mCurrentFragment;
    }

}
