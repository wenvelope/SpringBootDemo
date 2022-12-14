package com.example.demo3.filter

import org.springframework.stereotype.Component
import javax.servlet.*

@Component
class SimpleFilter: Filter {
    override fun doFilter(request: ServletRequest, response: ServletResponse, chain: FilterChain) {
        chain.doFilter(request,response)
    }

    override fun destroy() {
        super.destroy()
    }

    override fun init(filterConfig: FilterConfig?) {
        super.init(filterConfig)
    }
}