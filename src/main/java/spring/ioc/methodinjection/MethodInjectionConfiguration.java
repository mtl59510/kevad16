package spring.ioc.methodinjection;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Note the "full" inter-Bean dependencies!
 * 
 * @author A
 *
 */
@Configuration
public class MethodInjectionConfiguration {
	
	@Bean
	@Scope(BeanDefinition.SCOPE_PROTOTYPE)
	public Command getCommand() {
		return new Command();
	} //-getCommand
	
	@Bean
	public CommandManager getCommandManager() {
		
		// inline return
		return new CommandManager() {
			
			@Override
			protected Command createCommand() {
				return getCommand();
			}
			
		}; // -new
		
	} // -getCommandManager
	
}
