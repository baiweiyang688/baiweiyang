package com.xzsd.app.shopcart.dao;

import com.xzsd.app.goodsdetails.entity.GoodsDetailsInfo;
import com.xzsd.app.home.entity.RegisterInfo;
import com.xzsd.app.home.entity.ViewPageAppInfo;
import com.xzsd.app.shopcart.entity.GoodsMes;
import com.xzsd.app.shopcart.entity.ShopCartInfo;
import com.xzsd.app.shopcart.entity.ShopCartList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopCartDao {
    /**
     * 新增商品到购物车
     * @param shopCartInfo
     * @return
     */
    int addShopCart(ShopCartInfo shopCartInfo);

    /**
     * 查询商品信息
     * @param goodsCode
     * @return 修改结果
     */
     GoodsMes findGoodsDe(@Param("goodsCode") String goodsCode);

    /**
     * 获取app端购物车列表信息
     * @param shopCartList
     * @return 所有用户信息
     */
    List<ShopCartList> listShopCart(ShopCartList shopCartList);

    /**
     * 删除对应的购物车清单
     * @param
     * @param shopCartCode
     * @return
     */
    int deleteShopCart(@Param("listCode") List<String> listCode, @Param("userId") String shopCartCode);

    /**
     * 修改购物车清单数量
     * @param shopCartInfo
     * @return
     */
    int updateShopCart(ShopCartInfo shopCartInfo);



}
