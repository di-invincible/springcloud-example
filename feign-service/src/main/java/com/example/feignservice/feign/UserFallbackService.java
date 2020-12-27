package com.example.feignservice.feign;

import com.example.common.result.CommonResult;
import com.example.common.result.ErrorCode;
import com.example.feignservice.entity.dto.User;
import org.springframework.stereotype.Component;

/**
 * @author aaron
 * @since 2020-12-26
 */
@Component
public class UserFallbackService implements UserService {
    @Override
    public CommonResult create(User user) {
        User defaultUser = new User(-1L, "defaultUser", "123456");
        return CommonResult.failed(ErrorCode.B0100);
    }

    @Override
    public CommonResult<User> getUser(Long id) {
        User defaultUser = new User(-1L, "defaultUser", "123456");
        return CommonResult.failed(ErrorCode.B0100);
    }

    @Override
    public CommonResult<User> getByUsername(String username) {
        User defaultUser = new User(-1L, "defaultUser", "123456");
        return CommonResult.failed(ErrorCode.B0100);
    }

    @Override
    public CommonResult update(User user) {
//        return new CommonResult("调用失败，服务被降级", 500);
        return CommonResult.failed(ErrorCode.B0100);
    }

    @Override
    public CommonResult delete(Long id) {
//        return new CommonResult("调用失败，服务被降级", 500);
        return CommonResult.failed(ErrorCode.B0100);
    }
}
