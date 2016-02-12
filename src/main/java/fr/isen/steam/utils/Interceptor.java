package fr.isen.steam.utils;

import org.slf4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by pierrezemb on 05/02/2016.
 *
 * This class is implementing AOP for Logging at beginning/ending of every methods
 */
@Aspect
@Component
public class Interceptor {

    // Logger
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * This function is adding log at beginning and end of every functions called
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("execution(* fr.isen..*.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {

        if (logger.isDebugEnabled() ) {
            logger.debug("Entering: " + joinPoint.getSignature().getName());
            Object[] signatureArgs = joinPoint.getArgs();

            // Looping through arguments
            for (Object signatureArg: signatureArgs) {
                logger.debug("Arg: " + signatureArg);
            }
        }

        Object o;

        try {
            // Executing function
            o = joinPoint.proceed();

        } catch (Exception e) {
            logger.error(e.toString());
            throw e;
        }
        if (logger.isDebugEnabled() ) {
            logger.debug("Exiting: " + joinPoint.getSignature().getName() + " with returns" + o);
        }
        return o;
    }

}
