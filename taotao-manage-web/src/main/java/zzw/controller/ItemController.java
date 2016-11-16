package zzw.controller;

import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import zzw.bean.EasyUIResult;
import zzw.bean.MyList;
import zzw.po.Item;
import zzw.service.ItemService;

/**
 * Created by john on 2016/11/12.
 */
@Controller
@RequestMapping("item")
public class ItemController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ItemController.class);

    @Autowired
    private ItemService itemService;

    //新增商品
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> save(Item item, @RequestParam String desc) {
        try {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("新增商品! item={} desc={}", item, desc);
            }
            //新增商品数据
            itemService.saveItem(item, desc);
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("新增商品成功! item={} desc={}", item, desc);
            }
            return ResponseEntity.status(201).build();
        } catch (Exception e) {
            LOGGER.error("新增商品出错! item=" + item, e);
        }
        return ResponseEntity.status(500).build();
    }

    //返回所有商品列表
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<EasyUIResult> queryItemList(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "30") Integer rows) {
        PageInfo<Item> itemPageInfo = itemService.queryItemList(page, rows);
        return ResponseEntity.ok(new EasyUIResult(itemPageInfo.getTotal(), itemPageInfo.getList()));
    }

    //实现商品的逻辑删除
    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteItemByids(MyList list) {
//        itemService.deleteItemByids(ids);
        System.out.println(list);
        return ResponseEntity.status(204).build();
    }

    //实现商品的真正删除
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteItem(Long id) {
        Integer integer = itemService.deleteById(id);
        return ResponseEntity.status(204).build();
    }
}
