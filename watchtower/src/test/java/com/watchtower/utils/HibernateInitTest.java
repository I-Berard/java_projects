package com.watchtower.utils;

import com.watchtower.models.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.Test;
import static org.junit.Assert.*;

public class HibernateInitTest {

    @Test
    public void testSessionFactoryInitialization() {
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            assertNotNull("SessionFactory should not be null", sessionFactory);
            
            // Verify User entity is recognized
            boolean hasUser = sessionFactory.getMetamodel().getEntities().stream()
                    .anyMatch(e -> e.getName().equals("User"));
            
            assertTrue("Entity 'User' should be recognized by Hibernate", hasUser);
            System.out.println("Hibernate successfully recognized 'User' entity.");
            
        } catch (Exception e) {
            e.printStackTrace();
            fail("SessionFactory initialization failed: " + e.getMessage());
        }
    }
}
