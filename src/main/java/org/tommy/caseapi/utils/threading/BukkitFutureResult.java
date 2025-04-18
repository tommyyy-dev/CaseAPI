package org.tommy.caseapi.utils.threading;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.Consumer;
import java.util.function.Function;

public class BukkitFutureResult<T> {

    private final CompletableFuture<T> future;

    private BukkitFutureResult(CompletableFuture<T> future) {
        this.future = future;
    }

    public static <T> BukkitFutureResult<T> of(CompletableFuture<T> future) {
        return new BukkitFutureResult<>(future);
    }

    public void whenComplete(@NotNull Plugin plugin, @NotNull Consumer<? super T> callback, @NotNull Consumer<Throwable> throwableConsumer) {
        var executor = (Executor) r -> Bukkit.getScheduler().runTask(plugin, r);
        this.future.thenAcceptAsync(callback, executor).exceptionally(throwable -> {
            throwableConsumer.accept(throwable);
            return null;
        });
    }

    public void whenComplete(@NotNull Plugin plugin, @NotNull Consumer<? super T> callback) {
        var executor = (Executor) r -> Bukkit.getScheduler().runTask(plugin, r);
        this.future.thenAcceptAsync(callback, executor);
    }

    public @Nullable T join() {
        return this.future.join();
    }

    public @NotNull CompletableFuture<T> asFuture() {
        return this.future.thenApply(Function.identity());
    }
}