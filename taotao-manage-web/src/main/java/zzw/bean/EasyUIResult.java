package zzw.bean;

import java.util.List;

/**
 * Created by john on 2016/11/8.
 */
public class EasyUIResult {

    private Long total;

    private List<?> rows;

    public EasyUIResult() {
    }

    public EasyUIResult(Long total, List<?> rows) {
        this.total = total;
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "EasyUIResult{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}
