package com.group20.thrive.ui.profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import com.group20.thrive.R;
import com.group20.thrive.SettingsActivity;
import com.group20.thrive.databinding.FragmentProfileBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class ProfileFragment extends Fragment {

    private com.group20.thrive.ui.profile.ProfileViewModel ProfileViewModel;
    private FragmentProfileBinding binding;
    private ViewPager2 mViewPager;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ProfileViewModel =
                new ViewModelProvider(this).get(com.group20.thrive.ui.profile.ProfileViewModel.class);

        binding = FragmentProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TabLayout tabLayout = view.findViewById(R.id.tabLayout);

        mViewPager = view.findViewById(R.id.viewPager);
        mViewPager.setAdapter(new com.group20.thrive.ui.profile.ViewPagerAdapter(getActivity()));

        new TabLayoutMediator(tabLayout, mViewPager,
                (tab, position) -> tab.setText(((com.group20.thrive.ui.profile.ViewPagerAdapter) (mViewPager.getAdapter())).mFragmentNames[position])
        ).attach();

        ImageButton btn = view.findViewById(R.id.imageButton);

        btn.setOnClickListener(view1 -> {
            Intent intent = new Intent (getActivity(), SettingsActivity.class);
            startActivity(intent);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}