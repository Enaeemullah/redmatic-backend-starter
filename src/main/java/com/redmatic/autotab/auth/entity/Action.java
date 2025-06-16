package com.redmatic.autotab.auth.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "actions")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Action {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String module;
    private String description;

    private boolean createPermission;
    private boolean readPermission;
    private boolean updatePermission;
    private boolean deletePermission;
}
