package DeepCloning;

class Manager implements Cloneable {
    private String name;
    private double salary;


    public Manager(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Manager[Name=" + name + ", Salary=" + salary + "]";
    }
}