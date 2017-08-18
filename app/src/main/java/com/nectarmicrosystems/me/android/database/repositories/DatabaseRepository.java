package com.nectarmicrosystems.me.android.database.repositories;

import java.util.UUID;
import java.util.ArrayList;

/**
 * Created by Tobi Adeyinka on 2017. 08. 18..
 */

interface DatabaseRepository<T> {

    void insert(T data);
    void update(T data);
    void delete(UUID dataId);
    ArrayList<T> getAll();
    T getById(UUID dataId);

}
