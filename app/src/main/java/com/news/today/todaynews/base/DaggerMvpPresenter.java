package com.news.today.todaynews.base;

import android.content.Intent;
import android.os.Bundle;

import com.news.today.mvp.base.BaseMvpPresenter;
import com.news.today.mvp.lf.view.IMvpView;
import com.news.today.task.AbsTask;
import com.news.today.task.AsyncTaskInstance;
import com.news.today.task.helper.TaskHelper;
import com.news.today.task.lf.IGroup;
import com.todaynews.mvp.MvpEmptyViewFactory;

import java.lang.reflect.ParameterizedType;

/**
 * Created by anson on 2018/4/6.
 */

public abstract class DaggerMvpPresenter<T extends IMvpView> extends BaseMvpPresenter<T> implements IGroup{

    public DaggerMvpPresenter(T view) {
        super(view);
    }


    @Override
    public void initParam(Bundle var1) {

    }

    @Override
    public void onCreate(Bundle var1, Bundle var2) {

    }

    @Override
    public void onViewCreate(Bundle var1, Bundle var2) {

    }

    @Override
    public void onViewDestroy() {

    }

    @Override
    public void onDestroy() {
        TaskHelper.cancelGroup(groupName());
    }

    @Override
    public void onPause() {
        TaskHelper.onPause(groupName());
    }

    @Override
    public void onResume() {
        TaskHelper.onResume(groupName());
    }

    @Override
    public void onSaveInstanceState(Bundle var1) {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onNewIntent(Intent var1) {

    }

    @Override
    public void onActivityResult(int var1, int var2, Intent var3) {

    }

    @Override
    public String groupName() {
        T view = getView();
        return ((IGroup) view).groupName();
    }

    //网络请求的快捷方式
    public <k,v> AsyncTaskInstance<k> submitTask(AbsTask<k,v> task) {
        return TaskHelper.submitTask(groupName(),task,task );
    }

    @Override
    protected T getEmptyView() {
        Class mViewClass = (Class) ((ParameterizedType) (this.getClass().getGenericSuperclass())).getActualTypeArguments()[0];
        try {
            return (T) MvpEmptyViewFactory.create(mViewClass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
