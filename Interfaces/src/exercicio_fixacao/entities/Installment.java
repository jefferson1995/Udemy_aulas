package exercicio_fixacao.entities;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Installment {

    private DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy"); //Para formar a data que irá imprimir na tela

    private LocalDate dueDate;
    private Double amount;

    public Installment(){

    }

    public Installment(LocalDate dueDate, Double amount) {
        this.dueDate = dueDate;
        this.amount = amount;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    //imprimir na tela
    @Override
    public String toString() {
        return fmt.format(dueDate) + " - " + String.format("%.2f", amount);
    }
}
