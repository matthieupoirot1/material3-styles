package edu.info.aen.first_test.livedata;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedLiveDataViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public LiveData<String> getmText() {
        if (this.mText == null) {
            this.mText = new MutableLiveData<>();
        }
        return this.mText;
    }

    public void setmText(String s) {
        if(s.length() <5){
            return;
        }
        this.mText.postValue(s);
    }
}