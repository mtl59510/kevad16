package spring.ioc.customscope;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

@Qualifier
@Scope(TwinScope.TWIN_SCOPE)
//@Target({ ElementType.TYPE, ElementType.METHOD })
@Target({ ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface TwinScopeQualifierWithMeta {
	
	// JAVA 8
	ScopedProxyMode proxyMode() default ScopedProxyMode.DEFAULT;
	
}
