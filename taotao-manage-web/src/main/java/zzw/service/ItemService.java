package zzw.service;

import com.github.abel533.entity.Example;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import zzw.po.Item;
import zzw.po.ItemDesc;

import java.util.List;

/**
 * Created by john on 2016/11/12.
 * service中千万不要进行try-catch,否则事务不会回滚
 */
@Service
public class ItemService extends BaseService<Item> {

    //事务的传播性
    @Autowired
    private ItemDescService itemDescService;

    @RequestMapping(method = RequestMethod.POST)
    public void saveItem(Item item, String desc) {
        item.setStatus(1);//初始状态
        item.setId(null);//防止用户的改变
        //新增商品
        super.save(item);
        ItemDesc itemDesc = new ItemDesc();
        itemDesc.setItemId(item.getId());
        itemDesc.setItemDesc(desc);
        itemDescService.save(itemDesc);
    }

    /**
     * 查询商品
     */
    public PageInfo<Item> queryItemList(Integer page, Integer rows) {
        Example example = new Example(Item.class);
        example.setOrderByClause("updated DESC");
        example.createCriteria().andNotEqualTo("status", 3);
        return querypageListByExample(example, page, rows);
    }

    public int deleteItemByids(List<Object> ids) {
        Example example = new Example(Item.class);
        example.createCriteria().andIn("id", ids);
        Item item = new Item();
        item.setStatus(3);//更改商品状态为3表明删除该商品
        int i = getMapper().updateByExampleSelective(item, example);
        return i;
    }
}
