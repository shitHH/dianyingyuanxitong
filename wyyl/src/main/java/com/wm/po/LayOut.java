package com.wm.po;

import org.springframework.stereotype.Component;

/**
 * @author bilie
 * 影厅布局实体类
 */
@Component
public class LayOut {

    /**
     * 布局编号
     */
    private int loid;

    /**
     * 排
     */
    private int row;

    /**
     * 列
     */
    private int col;

    public LayOut() {
    }

    public LayOut(int loid, int row, int col) {
        this.loid = loid;
        this.row = row;
        this.col = col;
    }

    public int getLoid() {
        return loid;
    }

    public void setLoid(int loid) {
        this.loid = loid;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
}
