package com.android.bigserj.homeWork11;


import android.app.Activity;
import android.databinding.ObservableField;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.bigserj.R;
import com.android.bigserj.base.BaseViewModel;
import com.android.bigserj.domain.entity.ProfileModel;
import com.android.bigserj.domain.interaction.HomeWork11.EditProfileUseCaseHomeWork11;
import com.android.bigserj.domain.interaction.HomeWork11.SaveProfileUseCaseHomeWork11;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

import static com.android.bigserj.homeWork11.HomeWork11ViewModel2.ID_NUMBER;

public class HomeWork11ViewModel3 implements BaseViewModel {

    SaveProfileUseCaseHomeWork11 saveProfileUseCaseHomeWork11 = new SaveProfileUseCaseHomeWork11();
    EditProfileUseCaseHomeWork11 editProfileUseCaseHomeWork11 = new EditProfileUseCaseHomeWork11();

    public Activity activity;

    private boolean isPressedSaveButton=false;
    private boolean isPressedAddButton=false;


    public HomeWork11ViewModel3(Activity activity) {
        this.activity = activity;
    }

    public static final String NAME_NUMBER = "NAME_NUMBER";
    public static final String SURNAME_NUMBER = "SURNAME_NUMBER";
    public static final String AGE_NUMBER = "AGE_NUMBER";


    public ObservableField<String> name = new ObservableField<>();
    public ObservableField<String> sureName = new ObservableField<>();
    public ObservableField<Integer> age = new ObservableField<>();


    @Override
    public void init() {

    }

    @Override
    public void release() {

    }

    @Override
    public void resume() {

        name.set(activity.getIntent().getStringExtra(NAME_NUMBER));
        sureName.set(activity.getIntent().getStringExtra(SURNAME_NUMBER));
        age.set(Integer.valueOf(activity.getIntent().getStringExtra(AGE_NUMBER)));

        final String id = activity.getIntent().getStringExtra(ID_NUMBER);
        final EditText editTextName = (EditText) activity.findViewById(R.id.editTextHW11Name);
        final EditText editTextSurName = (EditText) activity.findViewById(R.id.editTextHW11SurName);
        final EditText editTextAge = (EditText) activity.findViewById(R.id.editTextHW11Age);


        Button saveButton = (Button) activity.findViewById(R.id.saveButtonHW11);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ProfileModel profileModel = new ProfileModel();
                profileModel.setName(editTextName.getText().toString());
                profileModel.setSurName(editTextSurName.getText().toString());
                profileModel.setId(id);

                try {
                    profileModel.setAge(Integer.valueOf(editTextAge.getText().toString()));
                } catch (Exception e) {
                    Log.e("AAA", "Введите целое число");
                }

                isPressedSaveButton = !isPressedSaveButton;

                editProfileUseCaseHomeWork11.execute(profileModel, new DisposableObserver<Void>() {
                    @Override
                    public void onNext(@NonNull Void aVoid) {
                        Log.e("AAA", "SaveOK");
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.e("AAAA itemsSaveError = ", e.toString());
                    }

                    @Override
                    public void onComplete() {
                        Log.e("AAAA item", "onComplete");
                    }
                });

//                Intent intent = new Intent(view.getContext(), HomeWork11Activity2.class); // объект, который выполняет для нас что-либо (намерения, наприме, перейти куда-либо или открыт что-то)
//                intent.putExtra(ID_NUMBER,id);
//                activity.startActivity(intent);
            }
        });


        Button addButton = (Button) activity.findViewById(R.id.add);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ProfileModel profileModel = new ProfileModel();
                profileModel.setName(editTextName.getText().toString());
                profileModel.setSurName(editTextSurName.getText().toString());
                profileModel.setId(id);

                try {
                    profileModel.setAge(Integer.valueOf(editTextAge.getText().toString()));
                } catch (Exception e) {
                    Log.e("AAA", "Введите целое число");
                }

                isPressedAddButton = !isPressedAddButton;

                saveProfileUseCaseHomeWork11.execute(profileModel, new DisposableObserver<Void>() {
                    @Override
                    public void onNext(@NonNull Void aVoid) {
                        Log.e("AAA", "AddOK");
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.e("AAAA itemsEditError = ", e.toString());
                    }

                    @Override
                    public void onComplete() {
                        Log.e("AAAA item", "onComplete");
                    }
                });

            }
        });


    }

    @Override
    public void pause() {

        if (isPressedSaveButton)
            saveProfileUseCaseHomeWork11.dispose();
        if (isPressedAddButton)
            editProfileUseCaseHomeWork11.dispose();


    }
}