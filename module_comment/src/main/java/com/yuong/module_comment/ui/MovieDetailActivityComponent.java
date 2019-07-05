package com.yuong.module_comment.ui;

import com.yuong.library_base.di.component.ActivityComponent;
import com.yuong.library_base.di.component.ApplicationComponent;
import com.yuong.library_base.di.module.ActivityModule;
import com.yuong.library_base.di.scope.PerActivity;
import com.yuong.module_comment.ui.ActorsDetail.ActorsDetailActivity;
import com.yuong.module_comment.ui.actor_experience.ActorExpriencesActivity;
import com.yuong.module_comment.ui.all_person.AllPersonActivity;
import com.yuong.module_comment.ui.movie_detail.MovieDetailActivity;
import com.yuong.module_comment.ui.photo.PhotoActivity;
import com.yuong.module_comment.ui.video.VideoActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface MovieDetailActivityComponent extends ActivityComponent {

    void inject(MovieDetailActivity activity);

    void inject(AllPersonActivity activity);

    void inject(ActorsDetailActivity activity);

    void inject(PhotoActivity activity);

    void inject(VideoActivity activity);

}
