package com.yuong.main.ui;

import android.support.annotation.IdRes;
import android.support.v4.view.ViewPager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabReselectListener;
import com.roughike.bottombar.OnTabSelectListener;
import com.yuong.library_base.base.BaseActivity;
import com.yuong.library_base.base.BaseFragment;
import com.yuong.library_base.router.RouterActivityPath;
import com.yuong.library_base.router.RouterFragmentPath;
import com.yuong.main.R;
import com.yuong.main.R2;
import com.yuong.main.ui.adapter.MyPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

@Route(path = RouterActivityPath.Main.PAGER_MAIN)
public class MainActivity extends BaseActivity {
    @BindView(R2.id.viewPager)
    ViewPager viewPager;
    @BindView(R2.id.bottomBar)
    BottomBar bottomBar;

    private List<BaseFragment> mFragments;
    private MyPagerAdapter adapter;

    @Override
    public int inflateContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        initFragment();
        initListener();
    }

    private void initListener() {
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                if (tabId == R.id.tab_hot) {
                    viewPager.setCurrentItem(0);
                } else if (tabId == R.id.tab_coming) {
                    viewPager.setCurrentItem(2);
                } else if (tabId == R.id.tab_ticket) {
                    viewPager.setCurrentItem(1);
                }
            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int position) {
                bottomBar.selectTabAtPosition(position);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    private void initFragment() {
        //ARouter拿到多Fragment(这里需要通过ARouter获取，不能直接new,因为在组件独立运行时，宿主app是没有依赖其他组件，所以new不到其他组件的Fragment)
        BaseFragment hotFragment = (BaseFragment) ARouter.getInstance().build(RouterFragmentPath.Hot.PAGER_HOT).navigation();
        BaseFragment ticketFragment = (BaseFragment) ARouter.getInstance().build(RouterFragmentPath.Ticket.PAGER_TICKET).navigation();
        BaseFragment comingFragment = (BaseFragment) ARouter.getInstance().build(RouterFragmentPath.Coming.PAGER_COMING).navigation();
        mFragments = new ArrayList<>();
        mFragments.add(hotFragment);
        mFragments.add(ticketFragment);
        mFragments.add(comingFragment);
        adapter = new MyPagerAdapter(getSupportFragmentManager(), mFragments);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(0);

    }

    @Override
    protected boolean isRegisterEventBus() {
        return false;
    }

    @Override
    protected boolean isNeedInject() {
        return false;
    }

}
