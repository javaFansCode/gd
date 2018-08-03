package com.airmcl.air.service.service.impl;

import com.airmcl.air.service.dao.ProductMapper;
import com.airmcl.air.service.entity.Product;
import com.airmcl.air.service.entity.ProductExample;
import com.airmcl.air.service.service.ProductService;
import com.els.base.core.entity.PageView;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.lang.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("defaultProductService")
public class ProductServiceImpl implements ProductService {
    @Resource
    protected ProductMapper productMapper;

    @CacheEvict(value={"product"}, allEntries=true)
    @Override
    public void addObj(Product t) {
        this.productMapper.insertSelective(t);
    }

    @CacheEvict(value={"product"}, allEntries=true)
    @Override
    public void deleteObjById(Integer id) {
        this.productMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value={"product"}, allEntries=true)
    @Override
    public void modifyObj(Product t) {
        if (t.getId() == null || t.getId() ==0) {
            throw new NullPointerException("id 为空，无法更新");
        }
        this.productMapper.updateByPrimaryKeySelective(t);
    }

    @Cacheable(value="product", keyGenerator="redisKeyGenerator")
    @Override
    public Product queryObjById(Integer id) {
        return this.productMapper.selectByPrimaryKey(id);
    }

    @Cacheable(value="product", key="'ProductService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public List<Product> queryAllObjByExample(ProductExample example) {
        return this.productMapper.selectByExample(example);
    }

    @Cacheable(value="product", key="'ProductService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public PageView<Product> queryObjByPage(ProductExample example) {
        PageView<Product> pageView = example.getPageView();
        pageView.setQueryResult(this.productMapper.selectByExampleByPage(example));
        return pageView;
    }
}