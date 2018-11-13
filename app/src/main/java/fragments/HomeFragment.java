package fragments;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.SharedElementCallback;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.user.catrunner.R;
import com.example.user.catrunner.databinding.HomeFragmentBinding;

import viewModels.HomeFragmentViewModel;
import viewModels.ProfileFragmentViewModel;

public class HomeFragment extends Fragment {

    public FragmentTransaction fragmentTransaction;
    public ImageButton btnStart;
    public MapFragment mapFragment;
    private HomeFragmentBinding binding;
    private HomeFragmentViewModel homeFragmentViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        mapFragment = new MapFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        View v = inflater.inflate(R.layout.home_fragment, null);
//        btnStart = v.findViewById(R.id.btn_start);
//        return v;
//        return inflater.inflate(R.layout.home_fragment, null);
        binding = DataBindingUtil.inflate(inflater,
                R.layout.home_fragment, container, false);
        homeFragmentViewModel = ViewModelProviders.of(this.getActivity()).get(HomeFragmentViewModel.class);
        binding.setViewModel(homeFragmentViewModel);
        homeFragmentViewModel.getMapOpened().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                onChangeMapState();
            }
        });
        return binding.getRoot();
    }

    public int onChangeMapState() {
        boolean mapOpened = homeFragmentViewModel.getMapOpened().getValue();
        int curFragment;
        if (mapOpened) {
            curFragment = 6;
        } else {
            curFragment = 3;
        }
        return curFragment;
    }

    //    @Override
//    public void onStart() {
//        super.onStart();
//        btnStart.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////
//            }
//        });
//    }
}
