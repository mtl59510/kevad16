package spring.ioc.customscope;

import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
//@Scope(value = TwinScope.TWIN_SCOPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
@TwinScopeQualifierWithMeta(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Twin {
	
}
