package com.example.data.datasource;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\bH&\u00a8\u0006\t"}, d2 = {"Lcom/example/data/datasource/ICurrencyInfoLocalDataSource;", "", "addCurrencyInfoList", "", "currencyInfoList", "", "Lcom/example/data/model/CurrencyInfo;", "getLatest", "Lio/reactivex/Single;", "data"})
public abstract interface ICurrencyInfoLocalDataSource {
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<java.util.List<com.example.data.model.CurrencyInfo>> getLatest();
    
    public abstract void addCurrencyInfoList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.data.model.CurrencyInfo> currencyInfoList);
}