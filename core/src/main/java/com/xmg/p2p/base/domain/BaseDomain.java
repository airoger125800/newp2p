package com.xmg.p2p.base.domain;

import java.io.Serializable;

public class BaseDomain implements Serializable {
    private static final long seriaVersionUID = 1L;

    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

