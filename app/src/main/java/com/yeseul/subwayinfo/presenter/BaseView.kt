package com.yeseul.subwayinfo.presenter

interface BaseView<PresenterT : BasePresenter> {

    val presenter : PresenterT
}