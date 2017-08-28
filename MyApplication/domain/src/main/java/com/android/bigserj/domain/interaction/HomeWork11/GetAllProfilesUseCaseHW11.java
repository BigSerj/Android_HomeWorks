package com.android.bigserj.domain.interaction.HomeWork11;



import com.android.bigserj.data.entity.Profile;
import com.android.bigserj.data.net.RestService;
import com.android.bigserj.domain.entity.ProfileModel;
import com.android.bigserj.domain.interaction.base.UseCase;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

public class GetAllProfilesUseCaseHW11 extends UseCase<Void, List<ProfileModel>> {

    @Override
    protected Observable<List<ProfileModel>> buildUseCase(Void aVoid) {
        return RestService
                .getInstance()
                .getProfiles()
                .map(new Function<List<Profile>, List<ProfileModel>>() {
                    @Override
                    public List<ProfileModel> apply(@NonNull List<Profile> profiles) throws Exception {
                        List<ProfileModel> list = new ArrayList<>();
                        for (Profile profile : profiles)
                            list.add(convert(profile));
                        return list;
                    }
                });
    }

    private ProfileModel convert(Profile dataModel) {
        ProfileModel profileModel = new ProfileModel();
        profileModel.setId(dataModel.getId());
        profileModel.setName(dataModel.getName());
        profileModel.setSurName(dataModel.getSurName());
        profileModel.setAge(dataModel.getAge());
        return profileModel;
    }
}
