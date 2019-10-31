package com.gavinandre.mvpsocketclient.mvp.model;

import android.util.Log;

import com.gavinandre.mvpsocketclient.mvp.presenter.ChildPresenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by gavinandre on 18-1-7.
 */
public class ChildModel extends BaseSocketModel<ChildPresenter> {

    private static final String TAG = ChildModel.class.getSimpleName();

    public ChildModel(ChildPresenter presenter) {
        super(presenter);
        EventBus.getDefault().register(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public <T> void onMessageEvent(T event) {
        Log.i(TAG, "onMessageEvent: " + event);
        if (mPresenter != null) {
            mPresenter.showData((String) event);
        }
    }

    @Override
    public void detachModel() {
        EventBus.getDefault().unregister(this);
        super.detachModel();
    }
}
