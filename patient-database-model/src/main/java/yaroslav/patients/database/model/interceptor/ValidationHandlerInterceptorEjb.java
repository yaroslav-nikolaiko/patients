package yaroslav.patients.database.model.interceptor;


import yaroslav.patients.database.model.exception.EJBIllegalArgumentException;

import javax.annotation.Priority;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.validation.ConstraintViolationException;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by yaroslav on 6/14/14.
 */
@Interceptor
@ValidationHandlerEjb
@Priority(1010)
public class ValidationHandlerInterceptorEjb implements Serializable {
    @AroundInvoke
    Object perform(InvocationContext ic) throws EJBIllegalArgumentException {
        try {
            checkParameters(ic.getParameters());
            return ic.proceed();
        } catch (ConstraintViolationException e) {

            EJBIllegalArgumentException myException = new EJBIllegalArgumentException("Constraint Violations in EJB module ", e);
            myException.setExplanation(e.getMessage());
            myException.setMessageType(EJBIllegalArgumentException.MessageType.INFO);
            throw myException;

        }
        catch(EJBIllegalArgumentException e) {throw e;}
        catch (Exception e) {e.printStackTrace(); /*log*/ }
        return null;
    }

    private void checkParameters(Object[] parameters){
        for (Object parameter : parameters)
            checkParameter(parameter);
    }

    private void checkParameter(@NotNull Object parameter){
        //NOP
    }
}
