package com.springboot.validator.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class Order implements Serializable {
  public static interface Update {};

  public static interface Create {};

  //  @NotNull(message = "订单ID不能为空")
  //  private Long orderId;

  @NotBlank(
      message = "订单号不能为空",
      groups = {Create.class})
  private String orderNo;

  /* @NotBlank(message = "商品不能为空", groups = Update.class)
  private String orderGoods;

  @NotBlank(message = "商品数量不能为空", groups = Update.class)
  private Integer goodsNum;

  @NotBlank(message = "商品单价不能为空", groups = Update.class)
  @Digits(message = "商品单价只能为数字", integer = 10, fraction = 2, groups = Update.class)
  private Integer price;

  @NotBlank(message = "联系人不能为空", groups = Update.class)
  private String contact;

  @NotBlank(message = "手机不能为空", groups = Update.class)
  @Pattern(regexp = "^[1][3,4,5,6,7,8,9][0-9]{9}$", message = "手机号格式不正确", groups = Update.class)
  private String phone;

  @NotBlank(message = "地址不能为空", groups = Update.class)
  @Length(max = 50, message = "地址不能超过50个文字", groups = Update.class)
  private String address;

  @NotBlank(message = "邮箱不能为空", groups = Update.class)
  @Email(message = "邮箱格式不对", groups = Update.class)
  private String email;*/

  //  @Future(message = "创建时间必须是将来的时间", groups = Update.class)
  //  private Date createTime;

  /* public Long getOrderId() {
      return orderId;
    }

    public void setOrderId(Long orderId) {
      this.orderId = orderId;
    }

    public String getOrderNo() {
      return orderNo;
    }

    public void setOrderNo(String orderNo) {
      this.orderNo = orderNo;
    }

    public String getOrderGoods() {
      return orderGoods;
    }

    public void setOrderGoods(String orderGoods) {
      this.orderGoods = orderGoods;
    }

    public Integer getGoodsNum() {
      return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
      this.goodsNum = goodsNum;
    }

    public Integer getPrice() {
      return price;
    }

    public void setPrice(Integer price) {
      this.price = price;
    }

    public String getContact() {
      return contact;
    }

    public void setContact(String contact) {
      this.contact = contact;
    }

    public String getPhone() {
      return phone;
    }

    public void setPhone(String phone) {
      this.phone = phone;
    }

    public String getAddress() {
      return address;
    }

    public void setAddress(String address) {
      this.address = address;
    }

    public String getEmail() {
      return email;
    }

    public void setEmail(String email) {
      this.email = email;
    }
  */
  //  public Date getCreateTime() {
  //    return createTime;
  //  }
  //
  //  public void setCreateTime(Date createTime) {
  //    this.createTime = createTime;
  //  }
}
