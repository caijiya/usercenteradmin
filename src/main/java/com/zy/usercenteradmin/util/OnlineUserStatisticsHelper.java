package com.zy.usercenteradmin.util;

import com.zy.usercenteradmin.common.Constants;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.Duration;
import java.time.Instant;


/**
 * @Author: ZhaoYang
 * @Date: 2022/1/16
 */
@Component
public class OnlineUserStatisticsHelper {
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 添加在线用户信息
     *
     * @param userId
     * @return
     */
    public Boolean online(Integer userId) {
        return this.stringRedisTemplate.opsForZSet().add(Constants.REDIS_KEY_ONLINE_USERS, userId.toString(),
                Instant.now().toEpochMilli());
    }

    /**
     * 获取一定时间内，在线的用户数量
     *
     * @param duration
     * @return
     */
    public Long count(Duration duration) {
        Instant now = Instant.now();
        return this.stringRedisTemplate.opsForZSet().count(Constants.REDIS_KEY_ONLINE_USERS,
                now.minus(duration).toEpochMilli(),
                now.toEpochMilli());
    }

    /**
     * 获取所有在线过的用户数量，不论时间
     *
     * @return
     */
    public Long count() {
        return this.stringRedisTemplate.opsForZSet().zCard(Constants.REDIS_KEY_ONLINE_USERS);
    }

    /**
     * 清除超过一定时间没在线的用户数据
     *
     * @param duration
     * @return
     */
    public Long clear(Duration duration) {
        return this.stringRedisTemplate.opsForZSet().removeRangeByScore(Constants.REDIS_KEY_ONLINE_USERS, 0,
                Instant.now().minus(duration).toEpochMilli());
    }

    /**
     * 获取指定用户最后一次在线的时间差
     *
     * @param userId
     * @return
     */
    public Duration last(Integer userId) {
        Double result = this.stringRedisTemplate.opsForZSet().score(Constants.REDIS_KEY_ONLINE_USERS, userId.toString());
        return result == null ? null : Duration.ofMillis(result.longValue());
    }
}
