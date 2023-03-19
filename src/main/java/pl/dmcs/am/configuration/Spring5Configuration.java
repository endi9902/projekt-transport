package pl.dmcs.am.configuration;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;
import pl.dmcs.am.service.*;
import pl.dmcs.am.utils.*;

import javax.annotation.Resource;
import java.util.Locale;

@Configuration
@EnableWebMvc

@ComponentScan("pl.dmcs.am")
public class Spring5Configuration implements WebMvcConfigurer {

    @Bean
    public TilesConfigurer tilesConfigurer(){
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        tilesConfigurer.setDefinitions(new String[]{"tilesConfiguration/tiles.xml"});
        tilesConfigurer.setCheckRefresh(true);
        return tilesConfigurer;
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        TilesViewResolver viewResolver = new TilesViewResolver();
        registry.viewResolver(viewResolver);
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("/resources/i18n/messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    public LocaleResolver localeResolver() {
        CookieLocaleResolver resolver = new CookieLocaleResolver();
        resolver.setDefaultLocale(new Locale("en"));
        resolver.setCookieName("myLocaleCookie");
        resolver.setCookieMaxAge(4800);
        return resolver;
    }

    // Configure interceptor to switch language when 'lang' parameter found in request
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
        interceptor.setParamName("lang");
        registry.addInterceptor(interceptor);
    }
    @Bean
    @Override
    public LocalValidatorFactoryBean getValidator() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return bean;
    }

    @Resource(name="addressService")
    private AddressService addressService;

    @Resource(name="connectionService")
    private ConnectionService connectionService;

    @Resource(name="ticketService")
    private TicketService ticketService;

    @Resource(name="appUserRoleService")
    private AppUserRoleService appUserRoleService;

    @Override
    public void addFormatters(FormatterRegistry formatterRegistry)
    {
        formatterRegistry.addConverter(getMyAddressConverter());
        formatterRegistry.addConverter(getMyUserRoleConverter());
        formatterRegistry.addConverter(getMyUserRoleListConverter());
        formatterRegistry.addConverter(getMyConnectionConverter());
        formatterRegistry.addConverter(getMyTicketConverter());
    }

    @Bean
    public AddressConverter getMyAddressConverter() {
        return new AddressConverter(addressService);
    }

    @Bean
    public ConnectionConverter getMyConnectionConverter() {
        return new ConnectionConverter(connectionService);
    }

    @Bean
    public TicketConverter getMyTicketConverter() {
        return new TicketConverter(ticketService);
    }

    @Bean
    public AppUserRoleConverter getMyUserRoleConverter() {
        return new AppUserRoleConverter(appUserRoleService);
    }

    @Bean
    public AppUserRoleListConverter getMyUserRoleListConverter() {
        return new AppUserRoleListConverter(appUserRoleService);
    }

}
