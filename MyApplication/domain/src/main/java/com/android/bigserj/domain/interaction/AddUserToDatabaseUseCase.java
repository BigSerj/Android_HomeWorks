package com.android.bigserj.domain.interaction;

import com.android.bigserj.data.database.DatabaseManager;
import com.android.bigserj.domain.entity.AddUser;
import com.android.bigserj.domain.interaction.base.UseCase;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;

public class AddUserToDatabaseUseCase extends UseCase<AddUser, Void>{

    @Override
    protected Observable<Void> buildUseCase(final AddUser param) {

        return Observable.create(new ObservableOnSubscribe<Void>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Void> e) throws Exception {
                DatabaseManager databaseManager = new DatabaseManager(param.getContext());
                databaseManager.open(true);
                databaseManager.insertUser(convert(param.getUser()));
                databaseManager.close();
            }
        });
    }

    private com.android.bigserj.data.dbEntity.User convert(com.android.bigserj.domain.entity.User user) {
        com.android.bigserj.data.dbEntity.User userData = new com.android.bigserj.data.dbEntity.User();
        userData.setName(user.getName());
        userData.setAge(user.getAge());
        userData.setCountry(convertryCountry(user.getCountry()));
        return userData;
    }

    private com.android.bigserj.data.dbEntity.Country convertryCountry(com.android.bigserj.domain.entity.Country country) {
        com.android.bigserj.data.dbEntity.Country countryData = new com.android.bigserj.data.dbEntity.Country();
        countryData.setName(country.getName());
        countryData.setId(country.getId());
        return countryData;
    }


}
