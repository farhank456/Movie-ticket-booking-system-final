package com.movieticket.entity;

import jakarta.persistence.*;

@Entity @Table(name="users")
public class User {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long userId;
    @Column(nullable=false) private String name;
    @Column(nullable=false, unique=true) private String email;
    @Column(nullable=false) private String password;
    private String phone;
    @Enumerated(EnumType.STRING) @Column(nullable=false) private Role role=Role.USER;
    public Long getUserId(){return userId;} public void setUserId(Long v){userId=v;}
    public String getName(){return name;} public void setName(String v){name=v;}
    public String getEmail(){return email;} public void setEmail(String v){email=v;}
    public String getPassword(){return password;} public void setPassword(String v){password=v;}
    public String getPhone(){return phone;} public void setPhone(String v){phone=v;}
    public Role getRole(){return role;} public void setRole(Role v){role=v;}
}
