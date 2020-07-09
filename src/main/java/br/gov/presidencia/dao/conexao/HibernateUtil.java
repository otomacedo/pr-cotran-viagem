package br.gov.presidencia.dao.conexao;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import br.gov.presidencia.entity.Atividade;
import br.gov.presidencia.entity.Departamento;
import br.gov.presidencia.entity.Ferias;
import br.gov.presidencia.entity.Funcionario;
import br.gov.presidencia.entity.Graduacao;
import br.gov.presidencia.entity.Gratificacao;
import br.gov.presidencia.entity.Rh;
import br.gov.presidencia.entity.Setor;
import br.gov.presidencia.entity.TipoGratificacao;

public class HibernateUtil {


    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                // Hibernate settings equivalent to hibernate.cfg.xml's properties
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/dbPr?useTimezone=true&amp&serverTimezone=UTC");
                settings.put(Environment.USER, "root");
                settings.put(Environment.PASS, "");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
                settings.put(Environment.SHOW_SQL, "true");
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                configuration.setProperties(settings);
                
                configuration.addAnnotatedClass(Gratificacao.class);
                configuration.addAnnotatedClass(TipoGratificacao.class);
                configuration.addAnnotatedClass(Atividade.class);
                configuration.addAnnotatedClass(Setor.class);
                configuration.addAnnotatedClass(Graduacao.class);
                configuration.addAnnotatedClass(Departamento.class);
                configuration.addAnnotatedClass(Funcionario.class);
                configuration.addAnnotatedClass(Rh.class);
                configuration.addAnnotatedClass(Ferias.class);
                
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
