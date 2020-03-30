package com.ratel.modules.demo.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class MultiId implements Serializable {

    @Column(name = "key")
    private String key;

    @Column(name = "time")
    private String time;

    @Override
    public String toString() {
        return "PeopleKey [key=" + key + ", time=" + time + "]";
    }
}
