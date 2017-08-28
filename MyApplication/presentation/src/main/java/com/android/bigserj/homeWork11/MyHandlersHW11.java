package com.android.bigserj.homeWork11;


import android.content.Intent;
import android.view.View;


public class MyHandlersHW11{

    private ProfileItemViewModelHW11 viewModel;
    public MyHandlersHW11(ProfileItemViewModelHW11 viewModel) {
        this.viewModel = viewModel;
    }

    public void onClick(View view) {

        Intent intent = new Intent(view.getContext(), HomeWork11Activity2.class); // объект, который выполняет для нас что-либо (намерения, наприме, перейти куда-либо или открыт что-то)
        intent.putExtra(HomeWork11ViewModel2.ID_NUMBER,viewModel.id.get());
        view.getContext().startActivity(intent);

    }

}