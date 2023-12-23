package com.sol.turismmanagement.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.hibernate.collection.spi.PersistentList;

import java.util.List;

@Entity
public class Places {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String placeName;
    private String address;
    @OneToMany (mappedBy = "places",cascade = CascadeType.ALL)//, orphanRemoval=true)
    //@JoinColumn(name = "placeId")
    //@JsonManagedReference
    private List<Turist> turistList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Turist> getTuristList() {
        return turistList;
    }

    public void setTuristList(List<Turist> turistList) {
        /*
            this.getTuristList().clear();
            this.getTuristList().addAll(turistList);
*/
        this.turistList = turistList;
    }
}
