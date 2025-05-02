package com.satz.annotation.test;

import com.satz.annotation.DummyModelImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class AnnotationTest {

    private BeanInfo beanInfo;

    @BeforeEach
    void setUpTest() throws IntrospectionException {
        beanInfo = Introspector.getBeanInfo(DummyModelImpl.class);
    }

    @Test
    void getAnnotationTest() throws IntrospectionException {
        List<String> annotations = new ArrayList<>();
        Map<String, String> annotationMap = new HashMap<>();
        Arrays.stream(beanInfo.getPropertyDescriptors()).forEach((p) -> {
            System.out.println("Read Method : "+p.getReadMethod().getName());
            Arrays.stream(p.getReadMethod().getAnnotations()).forEach((annotation -> {
                System.out.println(annotation.annotationType().getName());
                annotations.add(annotation.annotationType().getName());
                annotationMap.put(p.getReadMethod().getName(), annotation.annotationType().getName());
            }));

        });

        assertTrue(annotations.contains("com.satz.annotation.MyAnnotation"));
        assertEquals("com.satz.annotation.MyAnnotation", annotationMap.get("getDefaultMethod"));
        assertEquals("com.satz.annotation.MyAnnotation", annotationMap.get("getNonDefaultMethod"));
    }
}
