package com.android.bigserj.classWork13;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.bigserj.R;

public class ClassWork13V1Fragment extends Fragment{

    public static final String TEXT_KEY = "TEXT_KEY";
    private String text;

    public static ClassWork13V1Fragment newInstance(FragmentManager fragmentManager, String text) {

        Fragment fragment = fragmentManager.findFragmentByTag(ClassWork13V1Fragment.class.getName());
        ClassWork13V1Fragment classWork13V1Fragment;

        if (fragment != null && fragment instanceof ClassWork13V1Fragment)
            classWork13V1Fragment = (ClassWork13V1Fragment)fragment;
        else {
            classWork13V1Fragment = new ClassWork13V1Fragment();
            Bundle bunde = new Bundle();
            bunde.putString(TEXT_KEY, text);
            fragment.setArguments(bunde);
        }

        return classWork13V1Fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if(bundle != null){
            text = bundle.getString(TEXT_KEY);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_classwork13v1, container,false);
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