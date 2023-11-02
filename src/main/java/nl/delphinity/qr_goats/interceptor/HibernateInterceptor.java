package nl.delphinity.qr_goats.interceptor;

import java.util.Map;

import org.hibernate.Session;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import nl.delphinity.qr_goats.domain.Opleiding;
import nl.delphinity.qr_goats.persistence.factories.DAOFactories;
import nl.delphinity.qr_goats.persistence.factories.DAOFactory;
import nl.delphinity.qr_goats.persistence.utils.HibernateSessionManager;

public class HibernateInterceptor extends AbstractInterceptor {

    private static final long serialVersionUID = 1L;

    @Override
    public void init() {
        DAOFactory.setFactory(DAOFactories.HIBERNATE.getFactory());
        HibernateSessionManager.getSessionFactory().openSession();
    }

    @Override
    public void destroy() {
        DAOFactory.setFactory(null);
        HibernateSessionManager.getSessionFactory().getCurrentSession().close();
    }

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {

        try {

            Map<String, Object> sessionMap = invocation.getInvocationContext().getSession();
            Opleiding opleiding = (Opleiding) sessionMap.get("Opleiding");

            if (opleiding != null)
                DAOFactory.getFactory().getOpleidingDAO().save(opleiding);

            return invocation.invoke();
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

}