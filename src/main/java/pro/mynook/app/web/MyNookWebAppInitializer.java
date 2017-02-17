package pro.mynook.app.web;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import pro.mynook.app.config.MainConfig;

/**
 * Created by Jaxichael on 2/16/2017.
 */
public class MyNookWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{MainConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/mynook/v1/*"};
    }
}
