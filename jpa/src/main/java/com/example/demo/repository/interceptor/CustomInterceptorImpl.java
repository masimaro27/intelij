package com.example.demo.repository.interceptor;

import com.example.demo.annotation.PermissionCache;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.CallbackException;
import org.hibernate.EmptyInterceptor;
import org.hibernate.Interceptor;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.Iterator;

@Slf4j
public class CustomInterceptorImpl extends EmptyInterceptor implements Interceptor, Serializable {
    @Override
    public boolean onSave(Object o, Serializable serializable, Object[] objects, String[] strings, Type[] types) throws CallbackException {
        Annotation[] annotations = o.getClass().getAnnotations();
        log.info("isAnnotationPresent : {}", o.getClass().isAnnotationPresent(PermissionCache.class));

        for (Annotation annotation : annotations) {
            Annotation a = annotation;
        }
        System.out.println("onSave");
        return false;
    }

    public boolean onFlushDirty(Object entity,Serializable id,
                                Object[] currentState,Object[] previousState,
                                String[] propertyNames,Type[] types)
            throws CallbackException {

        System.out.println("onFlushDirty");

        return false;

    }

    public void onDelete(Object entity, Serializable id,
                         Object[] state, String[] propertyNames,
                         Type[] types) {

        System.out.println("onDelete");
    }

    public void preFlush(Iterator iterator) {
        System.out.println("preFlush");
    }


    public void postFlush(Iterator iterator) {
        System.out.println("postFlush");
    }
}
