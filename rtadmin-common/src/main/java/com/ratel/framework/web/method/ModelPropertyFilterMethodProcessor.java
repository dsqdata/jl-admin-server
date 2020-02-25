package com.ratel.framework.web.method;


import com.ratel.framework.core.pagination.GroupPropertyFilter;
import com.ratel.framework.core.pagination.PropertyFilter;
import com.ratel.framework.security.AuthContextHolder;
import com.ratel.framework.web.annotation.ModelPropertyFilter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.MethodParameter;
import org.springframework.lang.Nullable;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

/**
 * 定制对 {@link ModelPropertyFilter} 注解参数处理，基于request请求构建查询参数对象
 *
 * @see org.springframework.web.servlet.mvc.method.annotation.ServletModelAttributeMethodProcessor
 */
public class ModelPropertyFilterMethodProcessor implements HandlerMethodArgumentResolver {


    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return (parameter.hasParameterAnnotation(ModelPropertyFilter.class));
    }

    /**
     * Resolve the argument from the model or if not found instantiate it with
     * its default if it is available. The model attribute is then populated
     * with request values via data binding and optionally validated
     * if {@code @java.validation.Valid} is present on the argument.
     *
     * @throws BindException if data binding and validation result in an error
     *                       and the next method parameter is not of type {@link Errors}
     * @throws Exception     if WebDataBinder initialization fails
     */
    @Override
    @Nullable
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        ModelPropertyFilter ann = parameter.getParameterAnnotation(ModelPropertyFilter.class);
        Class<?> clazz = ann.value();
        GroupPropertyFilter groupPropertyFilter = GroupPropertyFilter.buildFromHttpRequest(clazz, (HttpServletRequest) webRequest.getNativeRequest());
        String dataAccessControl = ann.dataAccessControl();
        if (StringUtils.isNotBlank(dataAccessControl)) {
            String loginAccountDataDomain = AuthContextHolder.getAuthUserDetails().getDataDomain();
            groupPropertyFilter.forceAnd(new PropertyFilter(PropertyFilter.MatchType.EQ, dataAccessControl, loginAccountDataDomain));
        }
        return groupPropertyFilter;
    }
}
