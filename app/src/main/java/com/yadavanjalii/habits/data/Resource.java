package com.yadavanjalii.habits.data;


import static com.yadavanjalii.habits.data.Status.ERROR;
import static com.yadavanjalii.habits.data.Status.LOADING;
import static com.yadavanjalii.habits.data.Status.SUCCESS;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * Habit Development
 *
 * @author Anjali Yadav
 * @date 14/05/2022 6:30 PM
 */
public class Resource<T> {
    @NonNull
    public final Status status;
    @Nullable
    public final T data;
    @Nullable public final String message;
    private Resource(@NonNull Status status, @Nullable T data, @Nullable String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public static <T> Resource<T> success(@NonNull T data) {
        return new Resource<>(SUCCESS, data, null);
    }

    public static <T> Resource<T> error(String msg, @Nullable T data) {
        return new Resource<>(ERROR, data, msg);
    }

    public static <T> Resource<T> loading(@Nullable T data) {
        return new Resource<>(LOADING, data, null);
    }

    public boolean isSuccess() {
        return status == SUCCESS && data != null;
    }

    public boolean isLoading() {
        return status == LOADING;
    }

    public boolean isLoaded() {
        return status != LOADING;
    }
}