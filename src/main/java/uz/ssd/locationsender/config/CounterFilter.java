package uz.ssd.locationsender.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import uz.ssd.locationsender.domain.entity.locsender.User;

import javax.servlet.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: Khumoyun Khujamov
 * Date: 9/11/20
 * Time: 5:27 PM
 */
public class CounterFilter implements Filter {
    private static final Logger LOGGER = LoggerFactory.getLogger(CounterFilter.class);
    public static Map<Long, Long> counter = new HashMap<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (user != null) {
            Long userId = user.getId();
            counter.put(userId, counter.containsKey(userId) ? counter.get(userId) + 1 : 1);
            LOGGER.info("Request Count : {} with userId : {}", counter.get(userId), user.getId());
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
    }
}
