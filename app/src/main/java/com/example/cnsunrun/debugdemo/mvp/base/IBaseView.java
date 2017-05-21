package com.example.cnsunrun.debugdemo.mvp.base;

/**
 * view interface,所有View(此项目中的View主要是Fragment和自定义的ViewGroup)必须实现此接口
 */

public interface IBaseView<T> {
    void setPresenter(T presenter);
}
