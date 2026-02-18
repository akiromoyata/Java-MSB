package DeepCloning;

class Department implements Cloneable {
    private String deptName;
    private Manager manager;

    public Department(String deptName, Manager manager) {
        this.deptName = deptName;
        this.manager = manager;
    }

    // This was missing in the previous snippet!
    public Manager getManager() {
        return manager;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // 1. Shallow clone of Department
        Department clonedDept = (Department) super.clone();

        // 2. Deep clone of the Manager object
        clonedDept.manager = (Manager) this.manager.clone();

        // 3. Apply 10% bonus custom logic
        double currentSalary = clonedDept.manager.getSalary();
        clonedDept.manager.setSalary(currentSalary * 1.10);

        return clonedDept;
    }

    @Override
    public String toString() {
        return "Department: " + deptName + " | " + manager;
    }
}