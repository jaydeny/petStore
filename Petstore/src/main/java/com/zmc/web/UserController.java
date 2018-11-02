package com.zmc.web;

import com.zmc.model.ApiResponse;
import com.zmc.model.User;
import com.zmc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RestControllerAdvice
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 添加一位用户
     */
    @RequestMapping(path = "", method = RequestMethod.POST)
    //@ResponseBody
    public ApiResponse createUser(@RequestBody User user) {
        if (user == null)
            return new ApiResponse(414, "error", "参数错误");
        return new ApiResponse(200, "success", "添加成功");
    }

    /**
     * 添加多位用户
     */
    @RequestMapping(path = "/createWithList", method = RequestMethod.POST)
    //@ResponseBody
    public ApiResponse createWithList(@RequestBody List<User> userList) {
        boolean flag = false;

        for (User user : userList) {
            if (userService.insert(user) > 0) {
                flag = true;
            } else {
                return new ApiResponse(414, "error", "参数格式有错误");
            }
        }

        if (flag)
            return new ApiResponse(200, "success", "添加成功");

        return new ApiResponse(414, "error", "参数格式有错误");
    }

    /**
     * 判断用户是否存在
     */
    @RequestMapping(path = "/login",method = RequestMethod.GET)
    public ApiResponse login(User user, HttpSession session){

        User login = userService.login(user);

        if( user.getUserName().isEmpty() || user.getPassword().isEmpty()  ){
            return new ApiResponse(500,"error","账号或者密码为空。");
        }

        if( login != null ) {
            session.setAttribute("user",login);
            return new ApiResponse(200, "success", "登陆成功");
        }

        return new ApiResponse(414,"error","未知错误");
    }

    /**
    * 用户注销
     *
    * */
    @RequestMapping(path = "/logout",method = RequestMethod.GET)
    public ApiResponse logout(User user, HttpSession session){
        session.removeAttribute("user");
        return new ApiResponse(200,"success","注销成功");
    }

    /**
     * 根据账号寻找用户信息
     *
     * */
    @RequestMapping(path = "/{username}",method = RequestMethod.GET)
    public Object getUserName(@PathVariable String username){

        if( username.isEmpty() )
            return new ApiResponse(500,"error","请输入账号");
        User user = userService.selectByUserNumber(username);

        if( user == null){
            return new ApiResponse(500,"error","此账号，不存在信息");
        }

        return user;
    }

    /**
     * 根据账号修改信息
     *
     * */
    @RequestMapping(path = "/{username}",method = RequestMethod.PUT)
    public Object update(@RequestBody User user){

        if( user.getUserName().isEmpty() )
            return new ApiResponse(500,"error","请输入账号");



        return user;
    }

    /**
     * 根据账号删除用户
     *
     * */
    @RequestMapping(path = "/{username}",method = RequestMethod.DELETE)
    public Object delete(@PathVariable String username){

        if( username.isEmpty() )
            return new ApiResponse(500,"error","请输入账号");

        if( userService.deleteByPrimaryKey(username) > 0 )
            return new ApiResponse(200,"success","删除成功");

        return new ApiResponse(414,"error","未知错误");
    }


}
