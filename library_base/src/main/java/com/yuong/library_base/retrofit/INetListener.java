package com.yuong.library_base.retrofit;

/**监听网络返回
 * Created by Administrator on 2017/12/8.
 */

public interface INetListener<T, M, N> {
    public void success(T t);
    public void failed(M m);
    public void loading(N n);
}
