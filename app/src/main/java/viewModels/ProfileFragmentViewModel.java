package viewModels;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.view.View;

import com.example.user.catrunner.R;

public class ProfileFragmentViewModel extends ViewModel {

    private MutableLiveData<Integer> mCurrentGender;

    public void setGender(View view)
    {
        int curFragment = 1;
        switch (view.getId()) {
            case R.id.rbtn_male:
                curFragment = 1;
                break;
            case R.id.rbtn_female:
                curFragment = 2;
                break;
            case R.id.rbtn_other:
                curFragment = 3;
                break;
        }
        mCurrentGender.setValue(curFragment);
    }

    public MutableLiveData<Integer> getGender() {
        if (mCurrentGender == null) {
            mCurrentGender = new MutableLiveData<Integer>();
            mCurrentGender.setValue(1);
        }
        return mCurrentGender;
    }
}
