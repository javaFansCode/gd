package com.airmcl.air.comments.service.impl;

import com.airmcl.air.app.entity.IndexOutColumnAndModel;
import com.airmcl.air.comments.dao.CommentsMapper;
import com.airmcl.air.comments.entity.Comments;
import com.airmcl.air.comments.entity.CommentsExample;
import com.airmcl.air.comments.entity.CommentsExt;
import com.airmcl.air.comments.entity.CommentsExtExample;
import com.airmcl.air.comments.service.CommentsService;
import com.airmcl.air.goods.dao.GoodsMapper;
import com.airmcl.air.goods.entity.Goods;
import com.airmcl.air.goods.entity.GoodsExample;
import com.airmcl.air.order.dao.OrderMapper;
import com.airmcl.air.order.entity.Order;
import com.airmcl.air.order.entity.OrderExample;
import com.airmcl.air.service.dao.ServiceMapper;
import com.airmcl.air.service.entity.ServiceExample;
import com.els.base.core.entity.PageView;
import com.airmcl.air.comments.dao.ext.CommentsExtMapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("defaultCommentsService")
public class CommentsServiceImpl implements CommentsService{
    @Resource
    protected CommentsMapper commentsMapper;

    @Resource
    protected  CommentsExtMapper commentsExtMapper;
    @Resource
    protected OrderMapper orderMapper;
    @Resource
    protected ServiceMapper serviceMapper;
    @Resource
    protected GoodsMapper goodsMapper;

    @CacheEvict(value={"comments"}, allEntries=true)
    @Override
    public void addObj(Comments t) {
        this.commentsMapper.insertSelective(t);
    }

    @CacheEvict(value={"comments"}, allEntries=true)
    @Override
    public void deleteObjById(Integer id) {
        this.commentsMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value={"comments"}, allEntries=true)
    @Override
    public void modifyObj(Comments t) {
        if (t.getId() == null || t.getId() ==0) {
            throw new NullPointerException("id 为空，无法更新");
        }
        this.commentsMapper.updateByPrimaryKeySelective(t);
    }

    @Cacheable(value="comments", keyGenerator="redisKeyGenerator")
    @Override
    public Comments queryObjById(Integer id) {
        return this.commentsMapper.selectByPrimaryKey(id);
    }

    @Cacheable(value="comments", key="'CommentsService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public List<Comments> queryAllObjByExample(CommentsExample example) {
        return this.commentsMapper.selectByExample(example);
    }

    @Cacheable(value="comments", key="'CommentsService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public PageView<Comments> queryObjByPage(CommentsExample example) {
        PageView<Comments> pageView = example.getPageView();
        pageView.setQueryResult(this.commentsMapper.selectByExampleByPage(example));
        return pageView;
    }

    /**
     * 批量修改状态
     * @param ids
     * @param state
     */
    @Override
    @Transactional
    public void updateState(int[] ids, Integer state) {

        this.commentsMapper.updateState(ids,state);
        //更新评论次数
        for (int id : ids) {
            Comments comments = commentsMapper.selectByPrimaryKey(id);
            Integer orderId = comments.getOrderId();
            //审核通过
            if (comments.getState() == 1){
                OrderExample orderExample = new OrderExample();
                orderExample.createCriteria().andOrderIdEqualTo(orderId);
                List<Order> orders = orderMapper.selectByExample(orderExample);
                Byte orderType = orders.get(0).getOrderType();

                if (orderType == (byte)1 || orderType == (byte)2 || orderType == (byte)3 ){
                    ServiceExample servicesExample = new ServiceExample();
                    servicesExample.createCriteria().andIdEqualTo(Integer.valueOf(comments.getServiceId()));
                    List<com.airmcl.air.service.entity.Service> services = serviceMapper.selectByExample(servicesExample);
                    com.airmcl.air.service.entity.Service service = services.get(0);
                    Short commentTotal = service.getCommentTotal();
                    int comm = commentTotal.intValue();
                    Integer integer = Integer.valueOf(comm);
                    Integer in = integer + 1 ;
                    service.setCommentTotal(in.shortValue());
                    serviceMapper.updateByPrimaryKeySelective(service);
                }else {
                    GoodsExample goodsExample = new GoodsExample();
                    goodsExample.createCriteria().andIdEqualTo(Integer.valueOf(comments.getServiceId()));
                    List<Goods> goods = goodsMapper.selectByExample(goodsExample);
                    Goods goods1 = goods.get(0);
                    Integer comment_total = goods1.getCommentTotal();
                    goods1.setCommentTotal(comment_total+1);
                    goodsMapper.updateByPrimaryKeySelective(goods1);
                }
            }else if (comments.getState() == 3){
                OrderExample orderExample = new OrderExample();
                orderExample.createCriteria().andOrderIdEqualTo(orderId);
                List<Order> orders = orderMapper.selectByExample(orderExample);
                Byte orderType = orders.get(0).getOrderType();

                if (orderType == (byte)1 || orderType == (byte)2 || orderType == (byte)3 ){
                    ServiceExample servicesExample = new ServiceExample();
                    servicesExample.createCriteria().andIdEqualTo(Integer.valueOf(comments.getServiceId()));
                    List<com.airmcl.air.service.entity.Service> services = serviceMapper.selectByExample(servicesExample);
                    com.airmcl.air.service.entity.Service service = services.get(0);
                    Short commentTotal = service.getCommentTotal();
                    int comm = commentTotal.intValue();
                    Integer integer = Integer.valueOf(comm);
                    Integer in = integer - 1 ;
                    service.setCommentTotal(in.shortValue());
                    serviceMapper.updateByPrimaryKeySelective(service);
                }else {
                    GoodsExample goodsExample = new GoodsExample();
                    goodsExample.createCriteria().andIdEqualTo(Integer.valueOf(comments.getServiceId()));
                    List<Goods> goods = goodsMapper.selectByExample(goodsExample);
                    Goods goods1 = goods.get(0);
                    Integer comment_total = goods1.getCommentTotal();
                    goods1.setCommentTotal(comment_total-1);
                    goodsMapper.updateByPrimaryKeySelective(goods1);
                }
            }
        }
    }

    /**
     * 连表查询评论数据
     * @param example
     * @return
     */
    public PageView<CommentsExt> queryCommentsByparams(CommentsExt params,int pageNo,int pageSize) {

        // 设置返回对象
        PageView<CommentsExt> resultData = new PageView<CommentsExt>();
        // 分页数据
        params.setPageNo((pageNo - 1) * pageSize);
        params.setPageSize(pageSize);

        List<CommentsExt> commentsExts = this.commentsExtMapper.selectCommentsByParams(params);

        Integer count = commentsExtMapper.countCommentByParams(params);

        resultData.setPageSize(pageSize);
        resultData.setRowCount(count);
        resultData.setPageNo(pageNo);

        resultData.setQueryResult(commentsExts);
        return resultData;
    }
}