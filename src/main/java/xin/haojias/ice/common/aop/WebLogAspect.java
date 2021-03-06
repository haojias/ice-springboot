package xin.haojias.ice.common.aop;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import xin.haojias.ice.common.log.LogEntity;
import xin.haojias.ice.common.log.LogRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

@Component
@Aspect
public class WebLogAspect {

	@Autowired
	LogRepository logRepository;

	/**
	 * 判断是否为ajax请求
	 * @param request
	 * @return
	 */
	public static String getRequestType(HttpServletRequest request) {
		return request.getHeader("X-Requested-With");
	}

	static LogEntity logEntity=null;

	private static final Logger logger = LoggerFactory
			.getLogger(WebLogAspect.class);

	ThreadLocal<Long> startTimeThreadLocal = new ThreadLocal<Long>();

	@Pointcut("execution(public * xin.haojias.ice.methods.controller..*.*(..))")
	public void webLog() {
	}

	@Before("webLog()")
	public void doBefore(JoinPoint joinPoint) throws Throwable {
		startTimeThreadLocal.set(System.currentTimeMillis());

		logEntity=new LogEntity();


		// 接收到请求，记录请求内容
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();

		// 记录下请求内容
		logger.info("URL : " + request.getRequestURL().toString());
		logger.info("HTTP_METHOD : " + request.getMethod());
		logger.info("IP : " + request.getRemoteAddr());
		logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
		logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));

		logEntity.setClientIp(request.getRemoteAddr());
		logEntity.setMethod(request.getMethod());
		logEntity.setParamData(Arrays.toString(joinPoint.getArgs()));
		logEntity.setUri(request.getRequestURL().toString());
		logEntity.setSessionId(request.getRequestedSessionId());
		logEntity.setType(getRequestType(request));
		logEntity.setTime(startTimeThreadLocal.get());

	}

	@AfterReturning(returning = "ret", pointcut = "webLog()")
	public void doAfterReturning(Object ret) throws Throwable {
		// 处理完请求，返回内容
		logger.info("RESPONSE : " + ret);
		logger.info("SPEND TIME : " + (System.currentTimeMillis() - startTimeThreadLocal.get()));

		logEntity.setReturnTime(System.currentTimeMillis());
		logEntity.setReturnData(ret.toString());
		logEntity.setTimeConsuming((int) (System.currentTimeMillis() - startTimeThreadLocal.get()));

		logRepository.save(logEntity);
	}
	
}