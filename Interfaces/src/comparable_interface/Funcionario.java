package comparable_interface.application.entities;

public class Funcionario implements Comparable<Funcionario> { //Para conseguir usar o Collection sort

    private String name;
    private Double salary;

    public Funcionario(String name, Double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    //Compara um objeto com outroCom
    //No momento de usar o sort -> a comparação é feita por nome
    @Override
    public int compareTo(Funcionario other) {
        return name.compareTo(other.getName());
    }
}
