package org.example.bookpurchase.repository;


import org.example.bookpurchase.domain.OrderList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderListRepository extends JpaRepository<OrderList,Long> {
    @Query("select m from OrderList m where m.order.order_id = :orderId")
    List<OrderList> findOrderListByOrder(Long orderId);

    @Query("select m from OrderList m join fetch m.book join fetch m.order join fetch m.order.user where m.order.user.user_id = :userId order by m.orderList_id desc")
    List<OrderList> findOrderList(@Param("userId") Long userId);
    @Query("select m from OrderList m where m.orderList_id = :orderId")
    OrderList findByOrderList_id(Long orderId);
}
