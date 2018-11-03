package fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.user.catrunner.R;

public class HomeFragment extends Fragment {

    public FragmentTransaction fragmentTransaction;
    public ImageButton btnStart;
    public MapFragment mapFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mapFragment = new MapFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.home_fragment, null);
        btnStart = v.findViewById(R.id.btn_start);
        return v;
    }

    @Override
    public void onStart() {
        super.onStart();
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frgmCont, mapFragment);
                fragmentTransaction.commit();
            }
        });
    }
}
