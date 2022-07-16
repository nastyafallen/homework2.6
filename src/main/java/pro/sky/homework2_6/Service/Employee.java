package pro.sky.homework2_6.Service;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Employee {
    @JsonProperty("firstName")
    private String name;

    @JsonProperty("lastName")
    private String lastName;

    public Employee(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public String getName() { return name; }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Имя - " + getName() + ", фамилия - " +
                getLastName() + "; ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee service = (Employee) o;
        return name.equals(service.name) && lastName.equals(service.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastName);
    }
}
