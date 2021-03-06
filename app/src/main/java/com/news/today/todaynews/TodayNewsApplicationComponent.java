package com.news.today.todaynews;


import com.news.today.todaynews.edgesys.dagger.IEdgesysModule;
import com.news.today.todaynews.homesys.dagger.IHomesysModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by anson on 2018/4/4.
 */
@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        IEdgesysModule.class,
        IHomesysModule.class,
})
public interface TodayNewsApplicationComponent {
    void inject(TodayNewsApplication application);
}
