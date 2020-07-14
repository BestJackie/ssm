package com.jc.param;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * FileName: ValidationParams
 *
 * @author: haichaoyang3
 * @date: 2020/7/13 9:59
 * Description:
 * History:
 * since: 1.0.0
 */

public class ValidationParams {

    /**
     * 产品编号
     */
    @NotNull
    private Long productId;
    /**
     * 用户编号
     */
    @NotNull
    private Long userId;
    /**
     * 交易日期
     */
    @Future
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private Date date;
    /**
     * 价格
     */
    @NotNull
    @DecimalMin("0.1")
    private BigDecimal price;
    /**
     * 数量
     */
    @Min(1)
    @Max(100)
    @NotNull
    private Integer quantity;
    /**
     * 交易金额
     */
    @NotNull
    @DecimalMin("1.00")
    @DecimalMax("500000.00")
    private BigDecimal amount;
    /**
     * 邮件
     */
    @Pattern(regexp = "^([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)*@([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)+[\\.][A-Za-z]{2,3}([//.][A-Za-z]{2})?$", message = "邮件格式错误")
    private String email;
    /**
     * 备注
     */
    @Size(min = 0, max = 256, message = "备注过长")
    private String note;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
