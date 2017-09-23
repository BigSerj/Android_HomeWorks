package com.android.bigserj.domain.interaction;


import com.android.bigserj.data.database.DatabaseManager;
import com.android.bigserj.domain.entity.AddUser;
import com.android.bigserj.domain.entity.GetUser;
import com.android.bigserj.domain.entity.User;
import com.android.bigserj.domain.interaction.base.UseCase;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;

public class GetUserFromDatabaseUseCase extends UseCase<GetUser, User> {

    @Override
    protected Observable<User> buildUseCase(final GetUser param) {

        return Observable.create(new ObservableOnSubscribe<User>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<User> e) throws Exception {
                DatabaseManager databaseManager = new DatabaseManager(param.getContext());
                databaseManager.open(false);
                com.android.bigserj.data.dbEntity.User user = databaseManager.getUserById(param.getUser().getName());
                databaseManager.close();
                if (user != null) {
                    e.onNext(convert(user));
                    e.onComplete();

                } else {
                    e.onError(new Throwable("user with id = " + param.getUser().getName() + " is not found"));
                }
            }
        });
    }

    private com.android.bigserj.domain.entity.User convert(com.android.bigserj.data.dbEntity.User user) {
        com.android.bigserj.domain.entity.User userDomain = new com.android.bigserj.domain.entity.User();
        userDomain.setName(user.getName());
        userDomain.setAge(user.getAge());
        userDomain.setCountry(convertryCountry(user.getCountry()));
        return userDomain;
    }

    private com.android.bigserj.domain.entity.Country convertryCountry(com.android.bigserj.data.dbEntity.Country country) {
        com.android.bigserj.domain.entity.Country countryData = new com.android.bigserj.domain.entity.Country();
        countryData.setName(country.getName());
        countryData.setId(country.getId());
        return countryData;
    }

}
