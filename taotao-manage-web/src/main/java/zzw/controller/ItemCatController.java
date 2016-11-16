package zzw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import zzw.po.ItemCat;
import zzw.service.ItemCatService;

import java.util.List;

/**
 * Created by john on 2016/11/11.
 */
@Controller
@RequestMapping("/item/cat")
public class ItemCatController {

    @Autowired
    private ItemCatService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ItemCat>> queryItemCatList(@RequestParam(defaultValue = "0") Long id) {
        try {
            ItemCat itemCat = new ItemCat();
            itemCat.setParentId(id);
            List<ItemCat> itemCatList = service.queryByWhere(itemCat);
            if (itemCatList == null || itemCatList.isEmpty()) {
                return ResponseEntity.status(404).body(null);
            }
            return ResponseEntity.ok(itemCatList);//200
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return ResponseEntity.status(500).body(null);
    }

}
