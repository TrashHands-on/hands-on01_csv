package com.briefing.trash.dev.competition;

import java.util.Comparator;

public interface ISort<T> {

    T[] sort(T[] array, Comparator<T> comparator);
}
