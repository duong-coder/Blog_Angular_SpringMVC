package com.dependency.inject.stack.domain;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type Authority.
 */
@Data
@Entity
@Table(name = "hdht_authority")
@NoArgsConstructor
public class Authority implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "authority_name", nullable = false, unique = true)
    private String name;

    /**
     * Instantiates a new Authority.
     *
     * @param name the name
     */
    public Authority(String name) {
        this.name = name;
    }

}
