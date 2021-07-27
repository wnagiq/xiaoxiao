package com.lollipop.star.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lollipop.star.common.service.CacheService;
import com.lollipop.star.common.service.RedisService;


@Service("cacheService")
public class CacheServiceImpl implements CacheService {

    @Value("${spring.application.name}")
    private String serverName;
    
    @Autowired
    private RedisService redisService;

//    @Autowired
//    private ObjectMapper mapper;

    @Override
    public void testConnect() throws Exception {
        this.redisService.exists("test");
    }

//    @Override
//    public User getUser(String username) throws Exception {
//        String userString = this.redisService.get(serverName+DataAnalyConstant.USER_CACHE_PREFIX + username);
//        if (StringUtils.isBlank(userString)) {
//            return null;
//        } else {
//            return this.mapper.readValue(userString, User.class);
//        }
//    }
//
//    @Override
//    public void saveUser(User user) throws Exception {
//        String username = user.getUsername();
//        this.deleteUser(username);
//        redisService.set(serverName+DataAnalyConstant.USER_CACHE_PREFIX + username, mapper.writeValueAsString(user));
//    }
//
//    @Override
//    public void saveUser(String username) throws Exception {
//        User user = userMapper.findDetail(username);
//        this.deleteUser(username);
//        redisService.set(serverName+DataAnalyConstant.USER_CACHE_PREFIX + username, mapper.writeValueAsString(user));
//    }
//
//    @Override
//    public void deleteUser(String username) throws Exception {
//        username = username.toLowerCase();
//        redisService.del(serverName+DataAnalyConstant.USER_CACHE_PREFIX + username);
//    }
//
//    @Override
//    public void removeCache(User user) throws Exception {
//        String now = DateUtil.formatFullTime(LocalDateTime.now());
//        Set<String> userOnlineStringSet = redisService.zrangeByScore(serverName+DataAnalyConstant.ACTIVE_USERS_ZSET_PREFIX, now, "+inf");
//        for (String userOnlineString : userOnlineStringSet) {
//            ActiveUser kickoutUser = null;
//            String kickoutUserString = "";
//            ActiveUser activeUser = mapper.readValue(userOnlineString, ActiveUser.class);
//            if (StringUtils.equals(activeUser.getUsername(), user.getUsername())) {
//                kickoutUser = activeUser;
//                kickoutUserString = userOnlineString;
//            }
//            if (kickoutUser != null && StringUtils.isNotBlank(kickoutUserString)) {
//                // 删除 zset中的记录
//                redisService.zrem(serverName+DataAnalyConstant.ACTIVE_USERS_ZSET_PREFIX, kickoutUserString);
//                // 删除对应的 token缓存
//                redisService.del(serverName+DataAnalyConstant.TOKEN_CACHE_PREFIX + kickoutUser.getToken() + "." + kickoutUser.getIp());
//            }
//        }
//
//    }
}
