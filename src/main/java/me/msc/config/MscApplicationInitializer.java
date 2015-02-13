package me.msc.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by jiachiliu on 2/12/15.
 */
public class MscApplicationInitializer implements WebApplicationInitializer {

    private static final Class[] configClasses = {WebConfig.class, PersistanceConfig.class, ServiceConfig.class};

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        register(servletContext);
    }

    private void register(ServletContext servletContext) {
        WebApplicationContext dispatcherContext = createContext(configClasses);
        DispatcherServlet dispatcherServlet = new DispatcherServlet(dispatcherContext);
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", dispatcherServlet);
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/mongo/*");
    }

    private WebApplicationContext createContext(final Class<?>... classes) {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(classes);
        return context;
    }
}
