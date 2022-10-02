package it.academy.java.sprint3.tasca3.n1exercisi1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Ticket implements Serializable {
    List<Object> items = new ArrayList<Object>();

    public Ticket() {
    }

    public Ticket(List<Object> items) {
        this.items = items;
    }

    public List<Object> getItems() {
        return items;
    }

    public void setItems(List<Object> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "items=" + items +
                '}';
    }
}
