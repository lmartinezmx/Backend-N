package com.lmv.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_rols", uniqueConstraints = @UniqueConstraint(
        columnNames = {"rol", "email"}
))
public class UserRol {

    @Id
    @GeneratedValue
    @Column(name = "user_rol_id", unique = true, nullable = false)
    private Integer useerRolId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "email", nullable = false)
    private User user;
    @Column(name = "rol", nullable = false, length = 45)
    private String rol;

    public UserRol() {
    }

    public UserRol(Integer useerRolId, User user, String rol) {
        this.useerRolId = useerRolId;
        this.user = user;
        this.rol = rol;
    }

    public Integer getUseerRolId() {
        return useerRolId;
    }

    public void setUseerRolId(Integer useerRolId) {
        this.useerRolId = useerRolId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
