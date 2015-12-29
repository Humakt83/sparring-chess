package fi.ukkosnetti.chess

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

@Component
class SimpleCorsFilter extends Filter {
  
  override def doFilter(req : ServletRequest, res : ServletResponse, chain : FilterChain) {
    val response = res.asInstanceOf[HttpServletResponse];
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
		chain.doFilter(req, res);   
  }
  
  override def init(filterConfig : FilterConfig) {}
  
  override def destroy {}
}
