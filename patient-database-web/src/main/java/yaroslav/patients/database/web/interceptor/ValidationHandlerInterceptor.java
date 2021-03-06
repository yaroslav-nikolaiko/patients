package yaroslav.patients.database.web.interceptor;

import yaroslav.patients.database.model.exception.EJBIllegalArgumentException;
import yaroslav.patients.database.web.exception.WebException;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.io.Serializable;

/**
 * Created by yaroslav on 6/14/14.
 */
@Interceptor
@ValidationHandler
public class ValidationHandlerInterceptor implements Serializable {

    @AroundInvoke
    Object perform(InvocationContext ic) throws Exception{
        Object proceed = null;
        try {
            proceed = ic.proceed();
        } catch (WebException e){

            FacesMessage message = new FacesMessage(e.getMessageType(), e.getMessage(), e.getExplanation());
            FacesContext.getCurrentInstance().addMessage(null, message);

        } catch (EJBIllegalArgumentException e) {

            FacesMessage.Severity severityWarn = transformMessageType(e.getMessageType());
            FacesMessage message = new FacesMessage(severityWarn, e.getMessage(), e.getExplanation());
            FacesContext.getCurrentInstance().addMessage(null, message);

        }

        return proceed;
    }

    private FacesMessage.Severity transformMessageType(EJBIllegalArgumentException.MessageType type){
        if(type==null)
            return FacesMessage.SEVERITY_INFO;
        switch(type){
            case ERROR:
                return FacesMessage.SEVERITY_ERROR;
            case WARN:
                return FacesMessage.SEVERITY_WARN;
            case INFO:
                return FacesMessage.SEVERITY_INFO;
        }
        return FacesMessage.SEVERITY_INFO;
    }
}
