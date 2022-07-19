package com.example.UserService.model;

import lombok.Builder;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Builder
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String  username;

    @Column(name = "role")
    private String roles ;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "is_kyc_done")
    private Boolean is_kyc_done;

    public User() {

    }

//    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "users_roles",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id")
//    )
//
//   private Set<Role> roles = new HashSet<>();


    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public Boolean getIs_kyc_done() {
        return is_kyc_done;
    }

    public void setIs_kyc_done(Boolean is_kyc_done) {
        this.is_kyc_done = is_kyc_done;
    }

    public User(int id, String username, String roles, String password, String email, String mobile, Boolean is_kyc_done) {
        this.id = id;
        this.username = username;
        this.roles = roles;
        this.password = password;
        this.email = email;
        this.mobile = mobile;
        this.is_kyc_done = is_kyc_done;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public  String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password=password;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

//    public Set<Role> getRoles() {
//        return roles;
//    }

    public String toString()
    {
        return  id + "\n" + username + "\n" + roles + "\n"
                + password + "\n" + email + "\n" + mobile + "\n" + is_kyc_done ;
    }
}