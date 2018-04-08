package hu.balpo.rategp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import hu.balpo.rategp.presenter.TopListPresenter;
import hu.balpo.rategp.screen.TopListScreen;

public class TopListFragment extends Fragment implements TopListScreen {

    private TopListPresenter topListPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        topListPresenter = new TopListPresenter();
        topListPresenter.attachView(this);
    }

    @Override
    public void onDestroy() {
        topListPresenter.detachView();
        super.onDestroy();
    }

    @Override
    public void showTopList() {

    }
}
