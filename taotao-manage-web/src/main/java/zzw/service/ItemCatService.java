package zzw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zzw.mapper.ItemCatMapper;
import zzw.po.ItemCat;

import java.util.List;

/**
 * Created by john on 2016/11/11.
 */
@Service
public class ItemCatService {

    @Autowired
    private ItemCatMapper mapper;

    public List<ItemCat> queryItemCatList(Long parentId) {
        ItemCat itemCat = new ItemCat();
        itemCat.setParentId(parentId);
        List<ItemCat> itemCatList = mapper.select(itemCat);
        return itemCatList;
    }
}
