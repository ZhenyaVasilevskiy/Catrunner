package viewModels;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.view.View;

import com.example.user.catrunner.R;

public class HomeFragmentViewModel extends ViewModel {

    private MutableLiveData<Boolean> mMapOpened;

    public void setMapOpened(View view) {
        if (view.getId() == R.id.btn_start) {
            mMapOpened.setValue(true);
        } else {
            mMapOpened.setValue(false);
        }
    }

    public MutableLiveData<Boolean> getMapOpened() {
        if (mMapOpened == null) {
            mMapOpened = new MutableLiveData<>();
            mMapOpened.setValue(false);
        }
        return mMapOpened;
    }
}