package edu.info.aen.first_test.livedata;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Observable;
import java.util.Observer;

import edu.info.aen.first_test.R;
import edu.info.aen.first_test.databinding.FragmentLiveDataBottomBinding;

public class LiveDataBottomFragment extends Fragment {

    SharedLiveDataViewModel mViewModel;
    FragmentLiveDataBottomBinding binding;
    public LiveDataBottomFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.binding = FragmentLiveDataBottomBinding.inflate(inflater, container, false);
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.mViewModel = new ViewModelProvider(requireActivity()).get(SharedLiveDataViewModel.class);
        this.mViewModel.getmText().observe(getViewLifecycleOwner(), s -> this.binding.livedataFrgmtBottomTv.setText(s));
    }
}