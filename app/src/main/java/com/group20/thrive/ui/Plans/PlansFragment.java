package com.group20.thrive.ui.Plans;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.group20.thrive.databinding.FragmentPlansBinding;

public class PlansFragment extends Fragment {

    private PlansViewModel PlansViewModel;
    private FragmentPlansBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        PlansViewModel =
                new ViewModelProvider(this).get(PlansViewModel.class);

        binding = FragmentPlansBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textPlans;
        PlansViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}