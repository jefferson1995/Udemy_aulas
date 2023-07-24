package exemplo1.services;

import exemplo1.entities.CarRental;
import exemplo1.entities.Invoice;

import java.time.Duration;

public class RentalService {

    private Double pricePerHour;
    private Double pricePerDay;

    private BrazilTaxService taxService;

    public RentalService(Double pricePerHour, Double pricePerDay, BrazilTaxService taxService) {
        this.pricePerHour = pricePerHour;
        this.pricePerDay = pricePerDay;
        this.taxService = taxService;
    }

    public void processInvoice(CarRental carRental){

        Long minutes = Duration.between(carRental.getStart(), carRental.getFinish()).toMinutes(); //Pega duração entre inicio e fim.
        double hours = minutes / 60;

        double basicPayment;

        if(hours <= 12.0){
            basicPayment = pricePerHour * Math.ceil(hours);
        }else {
            basicPayment = pricePerDay * Math.ceil(hours / 24.0); //calcula em dias
        }

        double tax = taxService.tax(basicPayment);

        carRental.setInvoice(new Invoice(basicPayment, tax));

    }
}
