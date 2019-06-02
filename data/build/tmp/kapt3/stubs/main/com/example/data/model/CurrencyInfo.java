package com.example.data.model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0002\u0010\fJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003\u00a2\u0006\u0002\u0010\u0012JV\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH\u00c6\u0001\u00a2\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010#\u001a\u00020$H\u00d6\u0001J\t\u0010%\u001a\u00020\u0003H\u00d6\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000eR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000e\u00a8\u0006&"}, d2 = {"Lcom/example/data/model/CurrencyInfo;", "", "name", "", "platform", "Lcom/example/data/model/Platform;", "quote", "Lcom/example/data/model/Quote;", "slug", "symbol", "price", "", "(Ljava/lang/String;Lcom/example/data/model/Platform;Lcom/example/data/model/Quote;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;)V", "getName", "()Ljava/lang/String;", "getPlatform", "()Lcom/example/data/model/Platform;", "getPrice", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getQuote", "()Lcom/example/data/model/Quote;", "getSlug", "getSymbol", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Lcom/example/data/model/Platform;Lcom/example/data/model/Quote;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;)Lcom/example/data/model/CurrencyInfo;", "equals", "", "other", "hashCode", "", "toString", "data"})
public final class CurrencyInfo {
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String name = null;
    @org.jetbrains.annotations.Nullable()
    private final com.example.data.model.Platform platform = null;
    @org.jetbrains.annotations.Nullable()
    private final com.example.data.model.Quote quote = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String slug = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String symbol = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Double price = null;
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getName() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.data.model.Platform getPlatform() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.data.model.Quote getQuote() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getSlug() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getSymbol() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double getPrice() {
        return null;
    }
    
    public CurrencyInfo(@org.jetbrains.annotations.Nullable()
    java.lang.String name, @org.jetbrains.annotations.Nullable()
    com.example.data.model.Platform platform, @org.jetbrains.annotations.Nullable()
    com.example.data.model.Quote quote, @org.jetbrains.annotations.Nullable()
    java.lang.String slug, @org.jetbrains.annotations.Nullable()
    java.lang.String symbol, @org.jetbrains.annotations.Nullable()
    java.lang.Double price) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.data.model.Platform component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.data.model.Quote component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.data.model.CurrencyInfo copy(@org.jetbrains.annotations.Nullable()
    java.lang.String name, @org.jetbrains.annotations.Nullable()
    com.example.data.model.Platform platform, @org.jetbrains.annotations.Nullable()
    com.example.data.model.Quote quote, @org.jetbrains.annotations.Nullable()
    java.lang.String slug, @org.jetbrains.annotations.Nullable()
    java.lang.String symbol, @org.jetbrains.annotations.Nullable()
    java.lang.Double price) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
        return false;
    }
}