package com.jc.param;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import java.util.Date;

/**
 * FileName: FormatPojo
 *
 * @author: haichaoyang3
 * @date: 2020/7/17 18:22
 * Description:
 * History:
 * since: 1.0.0
 */

public class FormatPojo {

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date date1;
    @NumberFormat(pattern = "#,###.00")
    private double amount;
    //TODO


    public Date getDate1() {
        return date1;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
