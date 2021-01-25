package ma.zs.generated.ws.rest.provided.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.zs.generated.bean.User;
import ma.zs.generated.service.facade.UserService;
import ma.zs.generated.ws.rest.provided.converter.UserConverter;
import ma.zs.generated.ws.rest.provided.vo.UserVo;

@Api("Manages user services")
@RestController
@RequestMapping("generated/user")
public class UserRest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserConverter userConverter;

    @ApiOperation("Saves the specified user")
    @PostMapping("/")
    public UserVo save(@RequestBody UserVo userVo) {
        User user = userConverter.toItem(userVo);
        user = userService.save(user);
        return userConverter.toVo(user);
    }

    @ApiOperation("Delete the specified user")
    @DeleteMapping("/")
    public int delete(@RequestBody UserVo userVo) {
        User user = userConverter.toItem(userVo);
        return userService.delete(user);
    }

    @ApiOperation("Updates the specified user")
    @PutMapping("/")
    public UserVo update(@RequestBody UserVo userVo) {
        User user = userConverter.toItem(userVo);
        user = userService.update(user);
        return userConverter.toVo(user);
    }

    @ApiOperation("Finds a list of all users")
    @GetMapping("/")
    public List<UserVo> findAll() {
        return userConverter.toVo(userService.findAll());
    }

    @ApiOperation("Finds a user by id")
    @GetMapping("/id/{id}")
    public UserVo findById(@PathVariable Long id) {
        return userConverter.toVo(userService.findById(id));
    }

    @ApiOperation("Deletes a user by id")
    @DeleteMapping("/id/{id}")
    public void deleteById(@PathVariable Long id) {
        userService.deleteById(id);
    }


    @ApiOperation("Search user by a specific criterion")
    @PostMapping("/search")
    public List<UserVo> findByCriteria(@RequestBody UserVo userVo) {
        return userConverter.toVo(userService.findByCriteria(userVo));
    }

    public UserConverter getUserConverter() {
        return userConverter;
    }

    public void setUserConverter(UserConverter userConverter) {
        this.userConverter = userConverter;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }


}