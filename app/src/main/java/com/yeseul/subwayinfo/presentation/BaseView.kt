package com.yeseul.subwayinfo.presentation

interface BaseView<PresenterT : BasePresenter> {

    val presenter : PresenterT
}