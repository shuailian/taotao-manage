package zzw.bean;

import java.util.List;

/**
 * Created by john on 2016/11/16.
 */
public class MyList {
    private List<Object> list;


    @Override
    public String toString() {
        return "MyList{" +
                "list=" + list +
                '}';
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }
}
