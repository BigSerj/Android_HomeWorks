package com.android.bigserj.homeWork13;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.bigserj.R;
import com.android.bigserj.base.BaseFragment;

public class HomeWork13V1Fragment extends BaseFragment {

    public static final String TEXT_KEY = "TEXT_KEY";
    private String text;

    public static HomeWork13V1Fragment newInstance(FragmentManager fragmentManager, String text) {

        Fragment fragment = fragmentManager.findFragmentByTag(HomeWork13V1Fragment.class.getName());
        HomeWork13V1Fragment homeWork13V1Fragment;

        if (fragment != null && fragment instanceof HomeWork13V1Fragment)
            homeWork13V1Fragment = (HomeWork13V1Fragment)fragment;
        else {
            homeWork13V1Fragment = new HomeWork13V1Fragment();
            Bundle bundle = new Bundle();
            bundle.putString(TEXT_KEY, text);
            fragment.setArguments(bundle);
        }

        return homeWork13V1Fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if(bundle != null)
            text = bundle.getString(TEXT_KEY);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_homework13v1, container,false);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }



    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity();

    }



    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    /**
     * Вызывается когда активити в которой лежит фрагмент создана.
     * После этого метода можно использовать метод getActivity().
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }





}