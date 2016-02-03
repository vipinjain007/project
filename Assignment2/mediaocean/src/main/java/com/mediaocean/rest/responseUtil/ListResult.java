package com.mediaocean.rest.responseUtil;

import com.mediaocean.rest.constant.Messages;

import java.util.List;

/**
 * Created by Mediaocean on 01-02-2016.
 */
public class ListResult<T> {
    private List<T> list;
    private int count;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
