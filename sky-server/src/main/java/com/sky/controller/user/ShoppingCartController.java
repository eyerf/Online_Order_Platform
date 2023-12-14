package com.sky.controller.user;

import com.sky.dto.ShoppingCartDTO;
import com.sky.entity.ShoppingCart;
import com.sky.result.Result;
import com.sky.service.ShoppingCartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user/shoppingCart")
@Slf4j
@Api(tags = "C-suite shopping cart related interfaces")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @PostMapping("/add")
    @ApiOperation("add cart items")
    public Result add(@RequestBody ShoppingCartDTO shoppingCartDTO) {
        log.info("add cart items:{}", shoppingCartDTO);
        shoppingCartService.addShoppingCart(shoppingCartDTO);
        return Result.success();
    }

    @GetMapping("/list")
    @ApiOperation("View Cart")
    public Result<List<ShoppingCart>> list() {
        List<ShoppingCart> list = shoppingCartService.showShoppingCart();
        return Result.success(list);
    }
}
