package esprit.tn.examenprincip.services;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class InvoiceLoggingAspect {

    @AfterReturning(
            pointcut = "execution(* esprit.tn.examenprincip.services.PlatService.MontantApayerParClient(Integer))",
            returning = "result"
    )
    public void logSuccessfulInvoiceCalculation(Float result) {
        System.out.println("Montant de la facture calculé avec succès : " + result);
    }
}
