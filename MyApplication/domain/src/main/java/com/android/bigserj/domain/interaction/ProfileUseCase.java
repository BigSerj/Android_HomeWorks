package com.android.bigserj.domain.interaction;


import com.android.bigserj.domain.entity.Profile;
import com.android.bigserj.domain.entity.ProfileId;
import com.android.bigserj.domain.interaction.base.UseCase;

public class ProfileUseCase extends UseCase<ProfileId, Profile>{
    @Override
    protected Profile buildUseCase() {


        Profile profile = new Profile();

        profile.setName("Name");
        profile.setSurName("Surname");
        profile.setAge(20);

        return profile;
    }
}
