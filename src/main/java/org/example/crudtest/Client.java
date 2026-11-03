package org.example.crudtest;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.time.OffsetDateTime;

@Entity
@Table(name = "client_account")
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("full_name")
    @Column(nullable = false)
    private String full_name;

    @JsonProperty("gender")
    @Column(length = 1)
    private String gender;

    @JsonProperty("status")
    @Column(length = 20)
    private String status;

    @Column(nullable = false)
    private OffsetDateTime create_dttm;

    @Column(nullable = false)
    private OffsetDateTime modify_dttm;

    @PrePersist
    protected void onCreate() {
        create_dttm = OffsetDateTime.now();
        modify_dttm = OffsetDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        modify_dttm = OffsetDateTime.now();
    }
}
