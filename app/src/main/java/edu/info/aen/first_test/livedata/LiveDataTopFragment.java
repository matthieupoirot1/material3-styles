package edu.info.aen.first_test.livedata;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.internal.TextWatcherAdapter;

import edu.info.aen.first_test.R;
import edu.info.aen.first_test.databinding.FragmentLiveDataTopBinding;

public class LiveDataTopFragment extends Fragment {

    private SharedLiveDataViewModel mViewModel;
    private FragmentLiveDataTopBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        this.binding = FragmentLiveDataTopBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.mViewModel =
                new ViewModelProvider(requireActivity())
                        .get(SharedLiveDataViewModel.class);

        this.binding.livedataFrgmtTopEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override
            public void afterTextChanged(Editable s) {
                mViewModel.setmText(s.toString());
            }
        });
    }
}