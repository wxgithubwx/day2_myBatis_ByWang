package wx.mapper;

import wx.pojo.Orders;
import wx.pojo.User;

import java.util.List;

public interface OrderMapper {
    /*一对一关联查询 以订单为中心 关联用户*/
    public List<Orders> selectOrders();

    /*一对多查询*/
    public List<User> selectUser();
}
