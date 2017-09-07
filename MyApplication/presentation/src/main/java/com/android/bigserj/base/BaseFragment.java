package com.android.bigserj.base;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.bigserj.R;


abstract public class BaseFragment extends Fragment{

//    protected BaseViewModelFragment viewModelFragment;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        viewModelFragment.create();
    }

//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
//                             @Nullable Bundle savedInstanceState) {
//        return viewModelFragment.createView();;
//    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return null;
//        return inflater.inflate(R.layout.fragment_classwork13v2, container,false);
    }


    @Override
    public void onPause() {
        super.onPause();
//        viewModelFragment.onPause();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        viewModelFragment.destroyView();
    }



    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        viewModelFragment.viewCreated();
    }



    @Override
    public void onStart() {
        super.onStart();
//        viewModelFragment.start();
    }

    @Override
    public void onStop() {
        super.onStop();
//        viewModelFragment.stop();
    }

    /**
     * Вызывается когда активити в которой лежит фрагмент создана.
     * После этого метода можно использовать метод getActivity().
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        viewModelFragment.activityCreated();
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        viewModelFragment.attach();
    }

    @Override
    public void onDetach() {
        super.onDetach();
//        viewModelFragment.detach();
    }


}
