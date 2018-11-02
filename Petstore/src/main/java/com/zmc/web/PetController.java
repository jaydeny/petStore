package com.zmc.web;

import com.zmc.model.ApiResponse;
import com.zmc.model.Pet;
import com.zmc.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping(path = "/pet")
public class PetController {
    @Autowired
    private PetService petService;

    /**
     * 添加一只宠物
     * */
    @RequestMapping(path = "",method = RequestMethod.POST)
    public Object add(@RequestBody Pet pet){

        if( pet == null ) {
            return  new ApiResponse(500,"error","错误的格式");
        }
        if( petService.insert(pet) > 0 )
            return  new ApiResponse(200,"success","添加成功");
        return new ApiResponse(514,"error","未知错误");
    }


}
