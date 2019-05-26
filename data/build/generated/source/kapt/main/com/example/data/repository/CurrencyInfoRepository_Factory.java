package com.example.data.repository;

import com.example.data.datasource.ICurrencyInfoRemoteDataSource;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CurrencyInfoRepository_Factory implements Factory<CurrencyInfoRepository> {
  private final Provider<ICurrencyInfoRemoteDataSource> currencyInfoRemoteDataSourceProvider;

  public CurrencyInfoRepository_Factory(
      Provider<ICurrencyInfoRemoteDataSource> currencyInfoRemoteDataSourceProvider) {
    this.currencyInfoRemoteDataSourceProvider = currencyInfoRemoteDataSourceProvider;
  }

  @Override
  public CurrencyInfoRepository get() {
    return provideInstance(currencyInfoRemoteDataSourceProvider);
  }

  public static CurrencyInfoRepository provideInstance(
      Provider<ICurrencyInfoRemoteDataSource> currencyInfoRemoteDataSourceProvider) {
    return new CurrencyInfoRepository(currencyInfoRemoteDataSourceProvider.get());
  }

  public static CurrencyInfoRepository_Factory create(
      Provider<ICurrencyInfoRemoteDataSource> currencyInfoRemoteDataSourceProvider) {
    return new CurrencyInfoRepository_Factory(currencyInfoRemoteDataSourceProvider);
  }

  public static CurrencyInfoRepository newCurrencyInfoRepository(
      ICurrencyInfoRemoteDataSource currencyInfoRemoteDataSource) {
    return new CurrencyInfoRepository(currencyInfoRemoteDataSource);
  }
}
