package com.example.data.repository;

import com.example.data.datasource.ICurrencyInfoLocalDataSource;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CurrencyInfoRepository_Factory implements Factory<CurrencyInfoRepository> {
  private final Provider<ICurrencyInfoLocalDataSource> currencyInfoLocalDataSourceProvider;

  public CurrencyInfoRepository_Factory(
      Provider<ICurrencyInfoLocalDataSource> currencyInfoLocalDataSourceProvider) {
    this.currencyInfoLocalDataSourceProvider = currencyInfoLocalDataSourceProvider;
  }

  @Override
  public CurrencyInfoRepository get() {
    return provideInstance(currencyInfoLocalDataSourceProvider);
  }

  public static CurrencyInfoRepository provideInstance(
      Provider<ICurrencyInfoLocalDataSource> currencyInfoLocalDataSourceProvider) {
    return new CurrencyInfoRepository(currencyInfoLocalDataSourceProvider.get());
  }

  public static CurrencyInfoRepository_Factory create(
      Provider<ICurrencyInfoLocalDataSource> currencyInfoLocalDataSourceProvider) {
    return new CurrencyInfoRepository_Factory(currencyInfoLocalDataSourceProvider);
  }

  public static CurrencyInfoRepository newCurrencyInfoRepository(
      ICurrencyInfoLocalDataSource currencyInfoLocalDataSource) {
    return new CurrencyInfoRepository(currencyInfoLocalDataSource);
  }
}
